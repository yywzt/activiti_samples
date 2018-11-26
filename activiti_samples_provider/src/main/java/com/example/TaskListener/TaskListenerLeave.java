package com.example.TaskListener;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 * @author ywyw2424@foxmail.com
 * @date 2018/11/26 11:31
 * @desc 设置任务办理人
 */
public class TaskListenerLeave implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {
        delegateTask.setAssignee("a");
    }
}
