package com.example.controller;

import com.example.config.ResponseData;
import org.activiti.engine.HistoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author ywyw2424@foxmail.com
 * @date 2018/11/26 16:17
 * @desc
 */
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    /**
     * 代办任务
     * */
    @RequestMapping("/taskPage")
    public ResponseData taskPage(String userId){
        TaskQuery taskQuery = taskService.createTaskQuery().taskAssignee(userId);
        long total = taskQuery.count();
        List<Task> tasks = taskQuery.listPage(1, 10);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("tasks",tasks);
        return ResponseData.success(map);
    }

    /**
     * 已完成、历史任务
     * */
    @RequestMapping("/finishedList")
    public ResponseData finishedList(String userId){
        HistoricTaskInstanceQuery historicTaskInstanceQuery = historyService.createHistoricTaskInstanceQuery().taskAssignee(userId);
        long total = historicTaskInstanceQuery.count();
        List<HistoricTaskInstance> taskInstances = historicTaskInstanceQuery.listPage(1, 10);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("taskInstances",taskInstances);
        return ResponseData.success(map);
    }
}
