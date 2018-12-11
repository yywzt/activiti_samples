package com.example.controller;

import com.example.config.ResponseData;
import com.example.constant.ApprovalState;
import com.example.constant.LeaveStates;
import com.example.constant.Pagination;
import com.example.model.activiti.ProcessLeave;
import com.example.request.ApprovalRequest;
import com.example.response.ActivitiInstResponse;
import com.example.response.CommentResponse;
import com.example.response.MyTaskResponse;
import com.example.service.activiti.ProcessLeaveService;
import com.example.service.ssm.UserInfService;
import com.example.util.SessionUtil;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.HistoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    /**
     * 代办任务
     * */
    @RequestMapping(value = "/taskPage",method = RequestMethod.POST)
    public ResponseData taskPage(HttpServletRequest request,@RequestBody Pagination pagination){
        String userId = SessionUtil.getUserId(request.getSession());
        TaskQuery taskQuery = taskService.createTaskQuery().taskCandidateUser(userId);
        long total = taskQuery.count();
        List<Task> tasks = taskQuery.listPage(pagination.getPageNumber(), pagination.getPageSize());
        log.info("当前代办任务：{}条---{}",total,tasks);
        List<MyTaskResponse> list = new ArrayList<>(pagination.getPageSize());
        for (Task task:tasks) {
//            String processInstanceId = task.getProcessInstanceId();
//            ProcessLeave processLeave = processLeaveService.getRepository().findByProcessInstanceId(processInstanceId);
            MyTaskResponse myTaskResponse = new MyTaskResponse();
            myTaskResponse.setId(task.getId());
            myTaskResponse.setName(task.getName());
            myTaskResponse.setCreateTime(task.getCreateTime());
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
        HistoricTaskInstanceQuery historicTaskInstanceQuery = historyService.createHistoricTaskInstanceQuery().taskCandidateUser(userId);
        HistoricTaskInstanceQuery historicTaskInstanceQuery2 = historyService.createHistoricTaskInstanceQuery().taskAssignee(userId);
        List<HistoricTaskInstance> list1 = historicTaskInstanceQuery2.list();
        System.out.println(list1);
        long total = historicTaskInstanceQuery.count();
        List<HistoricTaskInstance> taskInstances = historicTaskInstanceQuery.listPage(pagination.getPageNumber(), pagination.getPageSize());
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
     * 审批
     * 完成任务
     * */
    @RequestMapping(value = "/complete",method = RequestMethod.POST)
    public ResponseData complete(HttpServletRequest request, @RequestBody @Validated ApprovalRequest approvalRequest){
        Task task = taskService.createTaskQuery()
                .taskId(approvalRequest.getId())
                .singleResult();
        if(task==null){
            return ResponseData.failure("当前任务不存在啊");
        }
        Map<String,Object> variables=new HashMap<String,Object>();
        String userId = SessionUtil.getUserId(request.getSession());
        String processInstanceId = task.getProcessInstanceId();

        ProcessLeave processLeave = processLeaveService.getRepository().findByProcessInstanceId(processInstanceId);
        if(approvalRequest.getState().equals(ApprovalState.PASS.getState())){
            //通过
            processLeave.setState(LeaveStates.PASS_APPROVAL.getState());
            variables.put("msg",true);
        }else if(approvalRequest.getState().equals(ApprovalState.ADOPT.getState())){
            processLeave.setState(LeaveStates.FAILED_APPROVAL.getState());
            variables.put("msg",false);
        }else{
            return ResponseData.failure("审批状态错误，请重新审批");
        }
        //设置用户id
        Authentication.setAuthenticatedUserId(SessionUtil.getUserName(request.getSession()));
        //添加批注信息
        taskService.addComment(task.getId(),processInstanceId,approvalRequest.getComment());
        taskService.complete(task.getId(),variables);
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
}
