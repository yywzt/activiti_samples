package com.example.handler;

import com.example.bo.TaskDoForm;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.springframework.stereotype.Component;

/**
 * @author yanzt
 * @date 2018/12/20 15:24
 * @describe 驳回到上一节点
 */
@Component("prevProcessTaskHandler")
public class PrevProcessTaskHandler extends JumpTaskHandler {

    @Override
    protected String getActivitiId(TaskEntity taskEntity, TaskDoForm taskDoForm) {
        //上一级节点
        return null;
    }
}
