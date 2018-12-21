package com.example.handler;

import com.example.bo.TaskDoForm;
import com.example.command.JumpActivitiCommand;
import com.example.constant.ProcessCode;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ManagementService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

/**
 * @author yanzt
 * @date 2018/12/20 14:24
 * @describe
 */
public abstract class JumpTaskHandler implements TaskHandler {

    @Autowired
    private ManagementService managementService;

    @Autowired
    private HistoryService historyService;

    protected abstract String getActivitiId(TaskEntity taskEntity, TaskDoForm taskDoForm);

    /**
     * 第一种自由跳转的方式:
     *   这种方式是通过 重写命令  ，推荐这种方式进行实现(这种方式的跳转，最后可以通过taskDeleteReason 来进行查询 )
     */
    @Override
    public void doHandler(TaskEntity taskEntity, TaskDoForm taskDoForm) {
        if (taskEntity == null) {
            throw new RuntimeException(ProcessCode.TASK_NOT_EXSIT.getMessage());
        }

        String activitiId = getActivitiId(taskEntity,taskDoForm);
        if (StringUtils.isEmpty(activitiId)) {
            throw new RuntimeException(ProcessCode.PLATFORM_ARG_ERROR.format("无法找到回退节点").getMessage());
        }

        HistoricTaskInstance historicTaskInstance = historyService
                .createHistoricTaskInstanceQuery()
                .taskId(taskEntity.getId()).finished().singleResult();
        if (historicTaskInstance != null) {
            throw new RuntimeException(ProcessCode.TASK_FINISHED.getMessage());
        }
        String processInstanceId = taskEntity.getProcessInstanceId();
        JumpActivitiCommand jumpActivitiCommand = new JumpActivitiCommand(processInstanceId, activitiId);
        managementService.executeCommand(jumpActivitiCommand);
    }
}
