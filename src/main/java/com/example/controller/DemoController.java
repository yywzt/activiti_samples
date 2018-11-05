package com.example.controller;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ywyw2424@foxmail.com
 * @date 2018/11/1 13:57
 * @desc
 */
@RestController
public class DemoController {

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @RequestMapping("/firstDemo")
    public void firstDemo(){
        //根据bpm文件部署流程
//        Deployment deployment = repositoryService.createDeployment().addClasspathResource("processes/demo1.bpmn").deploy();
//        //获取流程定义
//        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deployment.getId()).singleResult();
        //启动流程定义,返回流程实例
//        ProcessInstance pi = runtimeService.startProcessInstanceById(processDefinition.getId());
        ProcessInstance pi = runtimeService.startProcessInstanceByKey("myProcess_1");
        String procrssId = pi.getId();
        System.out.println("流程创建成功，当前流程实例ID：" + procrssId);

        Task task = taskService.createTaskQuery().processInstanceId(procrssId).singleResult();
        System.out.println("第一次执行前，任务名称：" + task.getName());
        taskService.complete(task.getId());

        task = taskService.createTaskQuery().processInstanceId(procrssId).singleResult();
        System.out.println("第二次执行前，任务名称：" + task.getName());
        taskService.complete(task.getId());

        task = taskService.createTaskQuery().processInstanceId(procrssId).singleResult();
        System.out.println("task为null，任务执行完毕：" + task);

    }

}
