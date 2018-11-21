package com.example.controller;

import com.example.process.Leave;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author ywyw2424@foxmail.com
 * @date 2018/11/5 16:14
 * @desc
 */
@RestController
@RequestMapping("/leave")
@Slf4j
public class LeaveController {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private ProcessEngine processEngine;

    @Autowired
    private RepositoryService repositoryService;

    /**
     * 启动流程
     * */
    @RequestMapping(value = "/start",method = RequestMethod.GET)
    public Map<String,Object> start(@RequestParam String userId){
        Map<String,Object> map = new HashMap<>();
        Leave leave = new Leave();
        leave.setUserId(userId);
        map.put("leave",leave);
        runtimeService.startProcessInstanceByKey("leave1",map);
        return map;
    }

    /**
     *
     * 填写请假单*/
    @RequestMapping(value = "/apply",method = RequestMethod.POST)
    public Map<String,Object> apply(@RequestBody Leave leave){
        Task task = taskService.createTaskQuery().taskId(leave.getTaskId()).singleResult();
        Map<String,Object> map = new HashMap<>();
        Leave origin = (Leave) taskService.getVariable(leave.getTaskId(), "leave");
        origin.setDesc(leave.getDesc());
        origin.setStartDate(leave.getStartDate());
        origin.setEndDate(leave.getEndDate());
        origin.setTotalDay(leave.getTotalDay());
        origin.setApprover1(leave.getApprover1());
        origin.setApprover2(leave.getApprover2());
        origin.setSubmit(leave.getSubmit());
        map.put("leave",origin);
        taskService.complete(leave.getTaskId(),map);
        return map;
    }

    /**
     * 查询用户流程
     * @param userId
     * @return
     */
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public Map<String, Object> find(@RequestParam("userId")String userId){
        List<Task> taskList = taskService.createTaskQuery().taskAssignee(userId).list();
        List<Leave> resultList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(taskList)){
            for(Task task : taskList){
                Leave leave = (Leave) taskService.getVariable(task.getId(),"leave");
                leave.setTaskId(task.getId());
                leave.setTaskName(task.getName());
                resultList.add(leave);
            }
        }
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("datas", resultList);
        return resultMap;
    }

    /**
     * 直接主管审批
     * @param leave
     * @return
     */
    @RequestMapping(value = "/approve1", method = RequestMethod.POST)
    public Map<String,Object> approve1(@RequestBody Leave leave){
        Task task = taskService.createTaskQuery().taskId(leave.getTaskId()).singleResult();
        Map<String, Object> vars = new HashMap<>();
        Leave origin = (Leave) taskService.getVariable(leave.getTaskId(), "leave");
        origin.setApproveDesc1(leave.getApproveDesc1());
        origin.setAgree1(leave.getAgree1());
        vars.put("leave", origin);
        taskService.complete(leave.getTaskId(),vars);
        return vars;
    }

    /**
     * 部门主管审批
     * @param leave
     * @return
     */
    @RequestMapping(value = "/approve2", method = RequestMethod.POST)
    public Map<String,Object> approve2(@RequestBody Leave leave) {
        Task task = taskService.createTaskQuery().taskId(leave.getTaskId()).singleResult();
        Map<String, Object> vars = new HashMap<>();
        Leave origin = (Leave) taskService.getVariable(leave.getTaskId(), "leave");
        origin.setApproveDesc2(leave.getApproveDesc2());
        origin.setAgree2(leave.getAgree2());
        vars.put("leave", origin);
        taskService.complete(leave.getTaskId(), vars);
        return vars;
    }

    /**
     * 查看历史任务记录
     * @param userId
     * @return
     */
    @RequestMapping(value="/findClosed", method = RequestMethod.GET)
    public List<Leave> findClosed(String userId){
        HistoryService historyService = processEngine.getHistoryService();
        List<HistoricTaskInstance> taskInstances = historyService.createHistoricTaskInstanceQuery().taskAssignee(userId).finished().list();
        List<HistoricVariableInstance> variableInstances = new ArrayList<>();
        taskInstances.forEach(historicTaskInstance -> {
            List<HistoricVariableInstance> variableInstanceList = historyService.createHistoricVariableInstanceQuery()
                    .processInstanceId(historicTaskInstance.getProcessInstanceId()).list();
            variableInstances.addAll(variableInstanceList);
        });

        List<Leave> leaves = new ArrayList<>();
        for (HistoricVariableInstance variableInstance:variableInstances){
            Leave leave = (Leave) variableInstance.getValue();
            leaves.add(leave);
        }
        return leaves;
    }

    @RequestMapping(value = "/findAllHistory",method = RequestMethod.GET)
    public void findAllHistory(){
        HistoryService historyService = processEngine.getHistoryService();
        //历史任务查询
        List<HistoricTaskInstance> taskInstances = historyService.createHistoricTaskInstanceQuery()
//                .taskAssignee("1")//指定办理人
//                .processInstanceId("5")//流程实例ID
                .finished().list();
        Iterator<HistoricTaskInstance> iterator = taskInstances.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+"---");
        }
        System.out.println("");

        //历史流程实例查询
        List<HistoricProcessInstance> processInstances = historyService.createHistoricProcessInstanceQuery()
//                .processInstanceId("5")//指定流程实例ID
                .list();
        Iterator<HistoricProcessInstance> iterator2 = processInstances.iterator();
        while (iterator2.hasNext()){
            HistoricProcessInstance processInstance = iterator2.next();
            Map<String, Object> processVariables = processInstance.getProcessVariables();
            System.out.println(processVariables);
            System.out.print(processInstance+"---");
        }
        System.out.println("");

        //历史活动查询
        List<HistoricActivityInstance> activityInstances = historyService.createHistoricActivityInstanceQuery()
//                .processInstanceId("5")//指定流程实例ID
                .finished().list();
        Iterator<HistoricActivityInstance> iterator3 = activityInstances.iterator();
        while (iterator3.hasNext()){
            System.out.print(iterator3.next()+"---");
        }
        System.out.println("");
    }

    /**查询历史流程变量*/
    @RequestMapping(value = "/findHistoryProcessVariables",method = RequestMethod.GET)
    public void findHistoryProcessVariables(String processInstanceId){
        List<HistoricVariableInstance> list = processEngine.getHistoryService()//
                .createHistoricVariableInstanceQuery()//创建一个历史的流程变量查询对象
                .processInstanceId(processInstanceId)//流程实例ID
                .list();
        if(list!=null && list.size()>0){
            for(HistoricVariableInstance hvi:list){
                System.out.println(hvi.getId()+"   "+hvi.getProcessInstanceId()+"   "+hvi.getVariableName()+"   "+hvi.getVariableTypeName()+"    "+hvi.getValue());
                System.out.println("###############################################");
            }
        }
    }

}