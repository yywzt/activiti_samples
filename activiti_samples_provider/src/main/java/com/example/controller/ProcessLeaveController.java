package com.example.controller;

import com.example.bo.TaskDoForm;
import com.example.config.ResponseData;
import com.example.constant.LeaveStates;
import com.example.constant.Pagination;
import com.example.constant.ProcessOperator;
import com.example.model.activiti.ProcessLeave;
import com.example.model.activiti.ProcessModel;
import com.example.response.CommentResponse;
import com.example.service.activiti.ProcessLeaveService;
import com.example.service.activiti.ProcessModelService;
import com.example.service.activiti.ProcessTaskService;
import com.example.service.ssm.UserInfService;
import com.example.util.SessionUtil;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author ywyw2424@foxmail.com
 * @date 2018/11/26 17:05
 * @desc 请假单申请
 */
@RestController
@RequestMapping("/processLeave")
public class ProcessLeaveController {

    @Autowired
    private ProcessLeaveService processLeaveService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private ProcessModelService processModelService;

    @Autowired
    private UserInfService userInfService;

    @Autowired
    private ProcessTaskService processTaskService;

    /**
     * 请假单列表
     * */
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public ResponseData page(HttpServletRequest request,Pagination pagination){
        String userId = SessionUtil.getUserId(request.getSession());
        ProcessLeave processLeave = new ProcessLeave();
        processLeave.setUserId(userId);
        Example<Object> example = Example.of(processLeave);
        Page page = processLeaveService.search(example,pagination);
        return ResponseData.success(page);
    }

    /**
     * 新增请假单
     * */
    @RequestMapping(value = "/newProcessLeave",method = RequestMethod.POST)
    public ResponseData newProcessLeave(HttpServletRequest request, @RequestBody @Validated ProcessLeave processLeave){
        String userId = SessionUtil.getUserId(request.getSession());
        processLeave.setUserId(userId);
        processLeave.setLeaveDate(new Date());
        processLeave.setState("0");
        processLeaveService.insert(processLeave);
        return ResponseData.success();
    }

    /**
     * 提交申请
     * */
    @RequestMapping(value = "/start",method = RequestMethod.POST)
    public ResponseData start(HttpServletRequest request, @RequestParam(value = "leaveId") String leaveId){
        ProcessLeave processLeave = processLeaveService.get(Long.valueOf(leaveId)).get();
        if(!processLeave.getState().equals(LeaveStates.NO_COMMIT.getState())){
            return ResponseData.failure("已经提交过了啊，请耐心等候");
        }
        String userId = SessionUtil.getUserId(request.getSession());
        Map<String,Object> variables=new HashMap<String,Object>();
        //设置流程变量
        variables.put("submitter",userId);
        ProcessModel processModel = processModelService.getRepository().findByModelCode("leave");
        ProcessInstance processInstance = runtimeService.startProcessInstanceById(processModel.getModelDefinitionId(),variables);

        String processInstanceId = processInstance.getId();
        String processDefinitionId = processInstance.getProcessDefinitionId();
        Task task = taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();
//        taskService.setAssignee(task.getId(),processLeave.getUserId());

        TaskDoForm taskDoForm = new TaskDoForm();
        //设置用户id
        taskDoForm.setUserId(userId);
        //添加批注信息
        taskDoForm.setTaskId(task.getId());
        taskDoForm.setProcessInstanceId(processInstanceId);
        taskDoForm.setMessage(processLeave.getLeaveReason());
        //设置流程变量
        taskDoForm.setVariables(variables);
        taskDoForm.setOperate(ProcessOperator.AGREE.getValue());
        processTaskService.submitTask(taskDoForm);

        processLeave.setState("1");//状态更改为审核中
        processLeave.setProcessInstanceId(processInstanceId);
        processLeave.setProcessDefinitionId(processDefinitionId);
        processLeaveService.update(processLeave);

        return ResponseData.success();
    }

    /**
     * 查看历史流程批注
     * @param processInstanceId 流程实例ID
     * */
    @RequestMapping(value = "/showHisComment",method = RequestMethod.GET)
    public ResponseData showHisComment(@RequestParam("processInstanceId") String processInstanceId){
        List<Comment> comments = taskService.getProcessInstanceComments(processInstanceId);
        List<CommentResponse> commentResponses = new ArrayList<>(comments.size());
        for (Comment comment:comments){
            CommentResponse commentResponse = new CommentResponse();
            commentResponse.setUserId(comment.getUserId());
            commentResponse.setUserName(userInfService.getUserNameByUserId(Long.valueOf(comment.getUserId())));
            commentResponse.setMessage(comment.getFullMessage());
            commentResponse.setTime(comment.getTime());
            commentResponses.add(commentResponse);
        }
        System.out.println("commentResponses: " + commentResponses);
        return ResponseData.success(commentResponses);
    }
}
