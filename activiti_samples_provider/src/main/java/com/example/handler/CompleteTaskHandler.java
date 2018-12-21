package com.example.handler;

import com.example.bo.TaskDoForm;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yanzt
 * @date 2018/12/20 14:45
 * @describe
 */
@Component("completeTaskHandler")
public class CompleteTaskHandler implements TaskHandler {

    @Autowired
    private TaskService taskService;

    @Override
    public void doHandler(TaskEntity taskEntity, TaskDoForm taskDoForm) {
        taskService.complete(taskDoForm.getTaskId(),taskDoForm.getVariables(),true);
    }
}
