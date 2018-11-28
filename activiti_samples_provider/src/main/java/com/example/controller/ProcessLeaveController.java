package com.example.controller;

import com.example.config.ResponseData;
import com.example.constant.Pagination;
import com.example.model.activiti.ProcessLeave;
import com.example.model.activiti.ProcessModel;
import com.example.service.activiti.ProcessLeaveService;
import com.example.service.activiti.ProcessModelService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

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

    /**
     * 请假单列表
     * */
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public ResponseData page(@RequestParam(value = "pageNumber",required = false) int pageNumber,@RequestParam(value = "pageSize",required = false) int pageSize){
        Pagination pagination = new Pagination(pageNumber,pageSize);
        Page page = processLeaveService.search(pagination);
        return ResponseData.success(page);
    }

    /**
     * 新增请假单
     * */
    @RequestMapping(value = "/newProcessLeave",method = RequestMethod.POST)
    public ResponseData newProcessLeave(@RequestBody @Valid ProcessLeave processLeave, BindingResult result){
        if(result.hasErrors()){
            StringBuffer msg = new StringBuffer();
            result.getAllErrors().forEach(objectError -> {
                msg.append(objectError.getDefaultMessage());
            });
            return ResponseData.failure(msg.toString());
        }
        processLeave.setLeaveDate(new Date());
        processLeave.setState("0");
        processLeaveService.insert(processLeave);
        return ResponseData.success();
    }

    /**
     * 提交申请
     * */
    @RequestMapping(value = "/start",method = RequestMethod.POST)
    public ResponseData start(Long leaveId){
        ProcessModel processModel = processModelService.getRepository().findByModelCode("process");
        ProcessInstance processInstance = runtimeService.startProcessInstanceById(processModel.getModelDefinitionId());

        String processInstanceId = processInstance.getId();
        Task task = taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();
        taskService.complete(task.getId());

        ProcessLeave processLeave = processLeaveService.get(leaveId).get();
        processLeave.setState("1");//状态更改为审核中
        processLeave.setProcessInstanceId(processInstanceId);
        processLeaveService.update(processLeave);

        taskService.addComment(task.getId(),processInstanceId,processLeave.getLeaveReason());

        return ResponseData.success();
    }
}
