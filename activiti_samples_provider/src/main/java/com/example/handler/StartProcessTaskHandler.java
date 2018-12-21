package com.example.handler;

import com.example.bo.TaskDoForm;
import com.example.constant.ProcessCode;
import com.example.service.common.ActivityService;
import org.activiti.bpmn.model.EndEvent;
import org.activiti.bpmn.model.StartEvent;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yanzt
 * @date 2018/12/20 15:15
 * @describe 回退到申请人
 */
@Component("startProcessTaskHandler")
public class StartProcessTaskHandler extends JumpTaskHandler {

    @Autowired
    private ActivityService activityService;

    @Override
    protected String getActivitiId(TaskEntity taskEntity, TaskDoForm taskDoForm) {
        StartEvent startEvent = activityService.getStartEvent(taskEntity.getProcessDefinitionId());
        if (startEvent == null) {
            throw new RuntimeException(ProcessCode.NOT_FIND_START.getMessage());
        }
        return startEvent.getId();
    }
}
