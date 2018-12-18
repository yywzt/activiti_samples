package com.example.controller;

import com.example.config.ResponseData;
import com.example.constant.Pagination;
import com.example.model.activiti.ProcessModel;
import com.example.repository.activiti.ProcessRepository;
import com.example.response.InstanceMonitorResponse;
import com.example.service.activiti.ProcessModelService;
import lombok.extern.slf4j.Slf4j;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.FlowElement;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author ywyw2424@foxmail.com
 * @date 2018/11/23 10:06
 * @desc 流程实例
 */
@RestController
@RequestMapping("/processInstance")
@Slf4j
public class ProcessInstanceController {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private ProcessRepository processRepository;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private ProcessModelService processModelService;

    @Autowired
    private RepositoryService repositoryService;

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

    /**
     * 流程监控、正在执行的流程
     * */
    @RequestMapping(value = "/getInstancePage",method = RequestMethod.GET)
    public ResponseData getInstancePage(@RequestParam(value = "pageSize",required = false) Integer pageSize,@RequestParam(value = "pageNumber",required = false) Integer pageNumber) {

        Pagination pagination = new Pagination(pageNumber,pageSize);

        ProcessInstanceQuery processInstanceQuery = runtimeService.createProcessInstanceQuery();

        List<ProcessModel> processModelList = processModelService.getRepository().findAll(Example.of(new ProcessModel()));
        if(processModelList.size()>0){
            Set<String> setProDefId = new HashSet<String>();
            for (ProcessModel model:
                    processModelList) {
                setProDefId.add(model.getModelDefinitionId());
            }
            processInstanceQuery.processDefinitionIds(setProDefId);
        }else{
            return ResponseData.success();
        }

        int totalCount = (int) processInstanceQuery.count();

        List<ProcessInstance> insList =
                processInstanceQuery
                        .orderByProcessDefinitionKey()
                        .asc().listPage(pagination.getStart(),pagination.getEnd());

        log.info("流程实例监控：{}条---{}",totalCount,insList);

        List<InstanceMonitorResponse> instanceMonitorResponses = new ArrayList<InstanceMonitorResponse>();
        for (ProcessInstance ins:insList) {
            InstanceMonitorResponse insRes = new InstanceMonitorResponse();
            String processDefinitionId = ins.getProcessDefinitionId();
            String activityId = ins.getActivityId();
            String processInstanceId = ins.getProcessInstanceId();

            insRes.setProcessDefinitionName(ins.getProcessDefinitionName());
            insRes.setProcessDefinitionVersion(ins.getProcessDefinitionVersion());
            insRes.setProcessDefinitionId(ins.getProcessDefinitionId());
            insRes.setProcessDefinitionKey(ins.getProcessDefinitionKey());
            insRes.setProcessInstanceId(ins.getProcessInstanceId());

            BpmnModel model = repositoryService.getBpmnModel(processDefinitionId);
            FlowElement element =  model.getMainProcess().getFlowElement(activityId);
            insRes.setCurrentNode(element.getName());
            insRes.setCurrentNodeId(element.getId());

            Task task = taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult();
            if(task!=null){
                insRes.setTaskId(task.getId());
                insRes.setInstanceName(task.getName());
                if(!StringUtils.isEmpty(task.getAssignee())){
                    insRes.setAssigneeName(task.getAssignee());
                }
            }
            instanceMonitorResponses.add(insRes);
        }
        pagination.setRows(instanceMonitorResponses);
        pagination.setRowTotal(totalCount);
        return ResponseData.success(pagination);
    }
}
