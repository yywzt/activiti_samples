package com.example.controller;

import com.example.config.ResponseData;
import com.example.model.ProcessModel;
import com.example.repository.ProcessRepository;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ywyw2424@foxmail.com
 * @date 2018/11/23 10:06
 * @desc 流程实例
 */
@RestController
@RequestMapping("/processInstance")
public class ProcessInstanceController {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private ProcessRepository processRepository;

    @Autowired
    private HistoryService historyService;

    /**
     * 启动某个流程定义
     * */
    @RequestMapping(value = "/start",method = RequestMethod.POST)
    public ResponseData start(@RequestParam("activitiModelId") String activitiModelId){
        try {
            ProcessModel processModel = processRepository.findByActiviModelId(activitiModelId);
            Assert.notNull(processModel,"当前模型不存在啊");
            //获取流程实例ID
            String definitionId = processModel.getModelDefinitionId();
            if(StringUtils.isEmpty(definitionId)){
                return ResponseData.failure("此模型尚未发布喔");
            }
            //启动流程定义,返回流程实例
            ProcessInstance pi = runtimeService.startProcessInstanceById(definitionId);
            String procrssId = pi.getId();
            System.out.println("流程创建成功，当前流程实例ID：" + procrssId);
            Task task = taskService.createTaskQuery().processInstanceId(procrssId).singleResult();
            Map map = new HashMap(10);
            if(task!=null) {
                int i=0;
                do {
                    System.out.println("第" + (++i) + "次执行前，任务名称：" + task.getName());
                    map.put(task.getName(),task.getName() + "msg");
                    taskService.complete(task.getId(),map);
                    task = taskService.createTaskQuery().processInstanceId(procrssId).singleResult();
                }while (task!=null);
            }
            System.out.println("task为null，任务执行完毕：" + task);
            return ResponseData.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseData.failure("启动失败：" + e.getMessage());
        }
    }

    /**
     * 查询历史流程变量
     * */
    @RequestMapping(value="/findHisVariable", method = RequestMethod.GET)
    public List<Object> findClosed(String userId){
        List<HistoricTaskInstance> taskInstances = historyService.createHistoricTaskInstanceQuery().taskAssignee(userId).finished().list();
        List<HistoricVariableInstance> variableInstances = new ArrayList<>();
        taskInstances.forEach(historicTaskInstance -> {
            List<HistoricVariableInstance> variableInstanceList = historyService.createHistoricVariableInstanceQuery()
                    .processInstanceId(historicTaskInstance.getProcessInstanceId()).list();
            variableInstances.addAll(variableInstanceList);
        });

        List<Object> values = new ArrayList<>();
        for (HistoricVariableInstance variableInstance:variableInstances){
            Object value = variableInstance.getValue();
            values.add(value);
        }
        return values;
    }
}
