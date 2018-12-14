package com.example.controller;

import com.example.config.ResponseData;
import com.example.model.activiti.ProcessModel;
import com.example.service.activiti.ProcessModelService;
import org.activiti.engine.FormService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.form.FormProperty;
import org.activiti.engine.form.FormType;
import org.activiti.engine.form.StartFormData;
import org.activiti.engine.form.TaskFormData;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yanzt
 * @date 2018/12/13 15:46
 * @describe
 */
@RestController
@RequestMapping("/form")
public class FormController {

    @Autowired
    private FormService formService;

    @Autowired
    private ProcessModelService processModelService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    /**
     * 启动流程实例
     * */
    @RequestMapping("/start")
    public ResponseData start(){
        ProcessModel processModel = processModelService.getRepository().findByModelCode("leave_form");
        ProcessInstance processInstance = runtimeService.startProcessInstanceById(processModel.getModelDefinitionId());
        String processDefinitionId = processInstance.getProcessDefinitionId();
        return ResponseData.success(processDefinitionId);
    }

    /**
     * 根据流程定义Id获取流程启动节点的表单内容
     * @param processDefinitionId 流程定义id
     * */
    @RequestMapping("/getStartForm")
    public ResponseData getStartForm(@RequestParam("processDefinitionId") String processDefinitionId){
        StartFormData startFormData = formService.getStartFormData(processDefinitionId);
        ProcessDefinition processDefinition = startFormData.getProcessDefinition();
        List<FormProperty> formProperties = startFormData.getFormProperties();
        formProperties.forEach(formProperty -> {
            String id = formProperty.getId();
            String name = formProperty.getName();
            FormType type = formProperty.getType();
            String value = formProperty.getValue();
        });
        return ResponseData.success(formProperties);
    }

    /**
     * 根据taskId获取流程任务中的表单内容
     * @param taskId 流程任务id
     * */
    @RequestMapping("/getTaskForm")
    public ResponseData getTaskForm(@RequestParam("taskId") String taskId){
        TaskFormData taskFormData = formService.getTaskFormData(taskId);
        Task task = taskFormData.getTask();
        List<FormProperty> formProperties = taskFormData.getFormProperties();
        formProperties.forEach(formProperty -> {
            String id = formProperty.getId();
            String name = formProperty.getName();
            FormType type = formProperty.getType();
            String typeName = type.getName();
            String value = formProperty.getValue();
            System.out.println("id: " + id + ","+"name: " + name + ","+"type: " + type + ","+"typeName: " + typeName + ","+"value: " + value);
        });
        return ResponseData.success(formProperties);
    }

    /**
     * 办理流程任务
     * @param taskId 流程任务id
     * @param map 流程任务表单内容、流程变量
     * */
    @RequestMapping(value = "/complete",method = RequestMethod.POST)
    public ResponseData complete(@RequestParam("taskId") String taskId,@RequestBody Map<String,String> map){
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        if(task!=null){
            //添加批注信息
            taskService.addComment(task.getId(),task.getProcessInstanceId(),map.get("comment")==null?map.get("leaveReason"):map.get("comment"));
            formService.submitTaskFormData(taskId,map);
            return ResponseData.success();
        }
        return ResponseData.failure();
    }
}
