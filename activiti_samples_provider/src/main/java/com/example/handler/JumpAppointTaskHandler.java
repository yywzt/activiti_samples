package com.example.handler;

import com.example.bo.TaskDoForm;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.springframework.stereotype.Component;

/**
 * @author yanzt
 * @date 2018/12/20 15:25
 * @describe 跳转到任意节点
 */
@Component("jumpAppointTaskHandler")
public class JumpAppointTaskHandler extends JumpTaskHandler {

    @Override
    protected String getActivitiId(TaskEntity taskEntity, TaskDoForm taskDoForm) {
        return taskDoForm.getTargetNodeId();
    }
}
