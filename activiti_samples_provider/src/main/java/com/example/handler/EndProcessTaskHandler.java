package com.example.handler;

import com.example.bo.TaskDoForm;
import com.example.constant.ProcessCode;
import com.example.service.common.ActivityService;
import org.activiti.bpmn.model.EndEvent;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yanzt
 * @date 2018/12/20 15:15
 * @describe 终止流程
 */
@Component("endProcessTaskHandler")
public class EndProcessTaskHandler extends JumpTaskHandler {

    @Autowired
    private ActivityService activityService;

    @Override
    protected String getActivitiId(TaskEntity taskEntity, TaskDoForm taskDoForm) {
        EndEvent endEvent = activityService.getEndEvent(taskEntity.getProcessDefinitionId());
        if (endEvent == null) {
            throw new RuntimeException(ProcessCode.END_NOT_EXSIT.getMessage());
        }
        return endEvent.getId();
    }
}
