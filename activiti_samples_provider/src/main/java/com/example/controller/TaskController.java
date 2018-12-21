package com.example.controller;

import com.example.bo.TaskDoForm;
import com.example.config.ResponseData;
import com.example.constant.*;
import com.example.model.activiti.ProcessLeave;
import com.example.response.ActivitiInstResponse;
import com.example.response.CommentResponse;
import com.example.response.MyTaskResponse;
import com.example.service.activiti.ProcessLeaveService;
import com.example.service.activiti.ProcessTaskService;
import com.example.service.ssm.UserInfService;
import com.example.util.SessionUtil;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ywyw2424@foxmail.com
 * @date 2018/11/26 16:17
 * @desc
 */
@RestController
@RequestMapping("/task")
@Slf4j
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private ProcessLeaveService processLeaveService;

    @Autowired
    private UserInfService userInfService;

    @Autowired
    private ProcessTaskService processTaskService;

    @Autowired
    private RuntimeService runtimeService;

    /**
     * 代办任务
     * */
    @RequestMapping(value = "/taskPage",method = RequestMethod.POST)
    public ResponseData taskPage(HttpServletRequest request,@RequestBody Pagination pagination){
        String userId = SessionUtil.getUserId(request.getSession());
        TaskQuery taskQuery = taskService.createTaskQuery().taskCandidateOrAssigned(userId);
        long total = taskQuery.count();
        List<Task> tasks = taskQuery.listPage(pagination.getStart(), pagination.getEnd());
        log.info("当前代办任务：{}条---{}",total,tasks);
        List<MyTaskResponse> list = new ArrayList<>(pagination.getPageSize());
        for (Task task:tasks) {
//            String processInstanceId = task.getProcessInstanceId();
//            ProcessLeave processLeave = processLeaveService.getRepository().findByProcessInstanceId(processInstanceId);
            MyTaskResponse myTaskResponse = new MyTaskResponse();
            myTaskResponse.setId(task.getId());
            myTaskResponse.setName(task.getName());
            myTaskResponse.setCreateTime(task.getCreateTime());
            myTaskResponse.setClaim(task.getAssignee()!=null);
            list.add(myTaskResponse);
        }
        pagination.setRows(list);
        pagination.setRowTotal(Long.valueOf(total).intValue());
        return ResponseData.success(pagination);
    }

    /**
     * 已完成、历史任务
     * */
    @RequestMapping(value = "/finishedList",method = RequestMethod.POST)
    public ResponseData finishedList(HttpServletRequest request,@RequestBody Pagination pagination){
        String userId = SessionUtil.getUserId(request.getSession());
        HistoricTaskInstanceQuery historicTaskInstanceQuery = historyService.createHistoricTaskInstanceQuery().taskAssignee(userId).finished();
        long total = historicTaskInstanceQuery.count();
        List<HistoricTaskInstance> taskInstances = historicTaskInstanceQuery.listPage(pagination.getStart(), pagination.getEnd());
        log.info("当前已办任务：{}条---{}",total,taskInstances);
        List<MyTaskResponse> list = new ArrayList<>(pagination.getPageSize());
        for (HistoricTaskInstance historicTaskInstance:taskInstances) {
            historicTaskInstance.getProcessInstanceId();
            MyTaskResponse myTaskResponse = new MyTaskResponse();
            myTaskResponse.setId(historicTaskInstance.getId());
            myTaskResponse.setName(historicTaskInstance.getName());
            myTaskResponse.setCreateTime(historicTaskInstance.getCreateTime());
            myTaskResponse.setEndTime(historicTaskInstance.getEndTime());
            list.add(myTaskResponse);
        }
        pagination.setRows(list);
        pagination.setRowTotal(Long.valueOf(total).intValue());
        return ResponseData.success(pagination);
    }

    /**
     * 任务认领
     * 将组任务分配到个人
     * */
    @RequestMapping("/claim")
    public ResponseData claimTask(HttpServletRequest request,@RequestParam("taskId") String taskId){
        String userId = SessionUtil.getUserId(request.getSession());
        taskService.claim(taskId,userId);
        return ResponseData.success();
    }
    /**
     * 将个人任务回退到组任务（前提：之前组任务）
     * */
    @RequestMapping("/backClaim")
    public ResponseData backClaimTask(HttpServletRequest request,@RequestParam("taskId") String taskId){
        taskService.setAssignee(taskId,null);
        return ResponseData.success();
    }

    /**
     * 审批
     * 完成任务
     * */
    @RequestMapping(value = "/complete",method = RequestMethod.POST)
    public ResponseData complete(HttpServletRequest request, @RequestBody @Validated TaskDoForm taskDoForm){
        String userId = SessionUtil.getUserId(request.getSession());
        Task task = taskService.createTaskQuery()
                .taskCandidateOrAssigned(userId)
                .taskId(taskDoForm.getTaskId())
                .singleResult();
        if(task==null){
            return ResponseData.failure("当前不存在待办理任务啊");
        }
        if(task.getAssignee()==null){
            return ResponseData.failure("认领任务之后才可以办理任务喔");
        }
        Map<String,Object> variables=new HashMap<String,Object>();
        String processInstanceId = task.getProcessInstanceId();

        ProcessLeave processLeave = processLeaveService.getRepository().findByProcessInstanceId(processInstanceId);
        if(taskDoForm.getState().equals(ApprovalState.PASS.getState())){
            //通过
            taskDoForm.setOperate(ProcessOperator.AGREE.getValue());
            processLeave.setState(LeaveStates.PASS_APPROVAL.getState());
            variables.put("msg",true);
        }else if(taskDoForm.getState().equals(ApprovalState.ADOPT.getState())){
            taskDoForm.setOperate(ProcessOperator.DISAGREE.getValue());
            processLeave.setState(LeaveStates.FAILED_APPROVAL.getState());
            variables.put("msg",false);
        }else{
            return ResponseData.failure("审批状态错误，请重新审批");
        }
        if (StringUtils.isEmpty(taskDoForm.getUserId())) {
            taskDoForm.setUserId(userId);
        }
        processTaskService.submitTask(taskDoForm);
        processLeaveService.update(processLeave);

        return ResponseData.success();
    }

    /**
     * 根据taskID查询请假单
     * */
    @RequestMapping(value = "/getLeave",method = RequestMethod.GET)
    public ResponseData findLeaveByTaskId(@RequestParam("taskId") String taskId){
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        String processInstanceId = task.getProcessInstanceId();
        ProcessLeave processLeave = processLeaveService.getRepository().findByProcessInstanceId(processInstanceId);
        return ResponseData.success(processLeave);
    }

    /**
     * 查看历史批注
     * */
    @RequestMapping(value = "/showHisComment",method = RequestMethod.GET)
    public ResponseData showHisComment(@RequestParam("taskId") String taskId){
        HistoricTaskInstance historicTaskInstance = historyService.createHistoricTaskInstanceQuery()
                .taskId(taskId)
                .singleResult();
        List<Comment> comments = taskService.getProcessInstanceComments(historicTaskInstance.getProcessInstanceId());
        List<CommentResponse> commentResponses = new ArrayList<>(comments.size());
        for (Comment comment:comments){
            CommentResponse commentResponse = new CommentResponse();
            commentResponse.setUserId(comment.getUserId());
            commentResponse.setUserName(comment.getUserId()==null?null:userInfService.getUserNameByUserId(Long.valueOf(comment.getUserId())));
            commentResponse.setMessage(comment.getFullMessage());
            commentResponse.setTime(comment.getTime());
            commentResponses.add(commentResponse);
        }
        System.out.println("commentResponses: " + commentResponses);
        return ResponseData.success(commentResponses);
    }

    /**
     * 流程执行过程
     * */
    @RequestMapping(value = "/listAction",method = RequestMethod.GET)
    public ResponseData listAction(@RequestParam("taskId") String taskId){
        HistoricTaskInstance historicTaskInstance = historyService.createHistoricTaskInstanceQuery()
                .taskId(taskId)
                .singleResult();
        List<HistoricActivityInstance> list = historyService.createHistoricActivityInstanceQuery()
                .orderByHistoricActivityInstanceStartTime()
                .asc()
                .processInstanceId(historicTaskInstance.getProcessInstanceId())
                .list();
        List<ActivitiInstResponse> activitiInstResponses = new ArrayList<>(list.size());
        for (HistoricActivityInstance instance:list) {
            ActivitiInstResponse instResponse = new ActivitiInstResponse();
            instResponse.setActivitiId(instance.getActivityId());
            instResponse.setActivitiName(instance.getActivityName());
            instResponse.setStartTime(instance.getStartTime());
            instResponse.setEndTime(instance.getEndTime());
            activitiInstResponses.add(instResponse);
        }
        System.out.println("activitiInstResponses: " + activitiInstResponses);
        return ResponseData.success(activitiInstResponses);
    }

    /**
     * 结束流程
     * @param taskDoForm
     * @return
     */
    @RequestMapping(value = "/endTask", method = RequestMethod.POST)
    public ResponseData endTask(HttpServletRequest request,@RequestBody TaskDoForm taskDoForm){
        if (StringUtils.isEmpty(taskDoForm.getUserId())) {
            taskDoForm.setUserId(SessionUtil.getUserId(request.getSession()));
        }
        taskDoForm.setOperate(ProcessOperator.END.getValue());
        this.processTaskService.submitTask(taskDoForm);
        ProcessLeave processLeave = processLeaveService.getRepository().findByProcessInstanceId(taskDoForm.getProcessInstanceId());
        processLeave.setState(LeaveStates.END_APPROVAL.getState());
        processLeaveService.update(processLeave);
        return ResponseData.success();
    }


    /**
     * 流程跳转
     * @param taskDoForm
     * @return
     */
    @RequestMapping(value = "/jumpTask", method = RequestMethod.POST)
    public ResponseData jumpTask(HttpServletRequest request,@RequestBody TaskDoForm taskDoForm){
        if(StringUtils.isEmpty(taskDoForm.getTargetNodeId())){
            return ResponseData.failure(ProcessCode.PLATFORM_ARG_ERROR.format("没有要跳转的节点!").getMessage());
        }

        if(taskDoForm.getTargetNodeId().equals(taskDoForm.getCurrentNodeId())){
            return ResponseData.failure(ProcessCode.PLATFORM_ARG_ERROR.format("目标节点与当前节点相同!").getMessage());
        }

        if (StringUtils.isEmpty(taskDoForm.getUserId())) {
            taskDoForm.setUserId(SessionUtil.getUserId(request.getSession()));
        }
        taskDoForm.setOperate(ProcessOperator.JUMP.getValue());
        this.processTaskService.submitTask(taskDoForm);
        return ResponseData.success();
    }

    /**
     * 任务催办
     * @param processInstanceId
     * @return
     */
    @RequestMapping(value = "/reminder/{processInstanceId}", method = RequestMethod.POST)
    public ResponseData reminder(@PathVariable("processInstanceId") String processInstanceId){
        this.processTaskService.reminder(processInstanceId);
        return ResponseData.success();
    }
}
