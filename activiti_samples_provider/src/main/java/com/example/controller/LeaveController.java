package com.example.controller;

import com.example.config.ResponseData;
import com.example.constant.LeaveStates;
import com.example.model.Leave;
import com.example.model.ProcessModel;
import com.example.service.LeaveService;
import com.example.service.ProcessModelService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ModelQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author ywyw2424@foxmail.com
 * @date 2018/11/26 17:05
 * @desc 请假单申请
 */
@RestController
@RequestMapping("/leave")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private ProcessModelService processModelService;

    /**
     * 请假单列表
     * */
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public ResponseData page(@RequestParam(value = "pageSize",required = false) Integer pageSize, @RequestParam(value = "pageNumber",required = false) Integer pageNumber){
        if(pageSize==null) {
            pageSize = 20;
        }
        if(pageNumber==null) {
            pageNumber = 1;
        }
        Page page = leaveService.findAll(pageSize, pageNumber);
        return ResponseData.success(page);
    }

    /**
     * 新增请假单
     * */
    @RequestMapping(value = "/newLeave",method = RequestMethod.POST)
    public ResponseData newLeave(@RequestBody @Valid Leave leave, BindingResult result){
        if(result.hasErrors()){
            StringBuffer msg = new StringBuffer();
            result.getAllErrors().forEach(objectError -> {
                msg.append(objectError.getDefaultMessage());
            });
            return ResponseData.failure(msg.toString());
        }
        leave.setLeaveDate(new Date());
        leave.setState("0");
        leaveService.getLeaveRepository().save(leave);
        return ResponseData.success();
    }

    /**
     * 提交申请
     * */
    @RequestMapping(value = "/start",method = RequestMethod.POST)
    public ResponseData start(Long leaveId){
        ProcessModel processModel = processModelService.getProcessRepository().findByModelCode("process");
        ProcessInstance processInstance = runtimeService.startProcessInstanceById(processModel.getModelDefinitionId());

        String processInstanceId = processInstance.getId();
        Task task = taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();
        taskService.complete(task.getId());

        Leave leave = leaveService.getLeaveRepository().findById(leaveId).get();
        leave.setState("1");
        leave.setProcessInstanceId(processInstanceId);
        leaveService.update(leave);

        taskService.addComment(task.getId(),processInstanceId,leave.getLeaveReason());

        return ResponseData.success();
    }
}
