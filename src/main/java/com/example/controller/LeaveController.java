package com.example.controller;

import com.example.process.Leave;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

}
