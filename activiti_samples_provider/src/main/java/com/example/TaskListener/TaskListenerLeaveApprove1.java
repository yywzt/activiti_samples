package com.example.TaskListener;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ywyw2424@foxmail.com
 * @date 2018/11/26 11:31
 * @desc 设置任务办理人-直接主管
 */
public class TaskListenerLeaveApprove1 implements TaskListener {

    //分配个人任务
    /*@Override
    public void notify(DelegateTask delegateTask) {
        //审批节点的办理人，查询当前用户的直接主管
        delegateTask.setAssignee("a");
    }*/

    //分配组任务
    @Override
    public void notify(DelegateTask delegateTask) {
        //直接主管审批节点的办理人，查询当前用户的直接主管
        List<String> userIds = new ArrayList<>(2);
        userIds.add("14");
        userIds.add("15");
        delegateTask.addCandidateUsers(userIds);
    }
}
