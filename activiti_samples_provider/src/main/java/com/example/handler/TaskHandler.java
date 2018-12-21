package com.example.handler;

import com.example.bo.TaskDoForm;
import org.activiti.engine.impl.persistence.entity.TaskEntity;

/**
 * @author yanzt
 * @date 2018/12/20 14:20
 * @describe
 */
public interface TaskHandler {

    void doHandler(TaskEntity taskEntity, TaskDoForm taskDoForm);
}
