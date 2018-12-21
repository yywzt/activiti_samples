package com.example.command;

import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.interceptor.CommandContext;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.impl.pvm.process.ProcessDefinitionImpl;

/**
 * @author yanzt
 * @date 2018/12/20 14:05
 * @describe
 */
public class JumpActivitiCommand implements Command<Object> {

    //当前正在执行的流程实例Id
    private String processInstanceId;
    //目标节点id
    private String activitiId;
    private String reason;

    public JumpActivitiCommand(String processInstanceId, String activitiId, String reason) {
        this.processInstanceId = processInstanceId;
        this.activitiId = activitiId;
        this.reason = reason;
    }

    public JumpActivitiCommand(String processInstanceId, String activitiId) {
        this(processInstanceId,activitiId,"jump");
    }

    @Override
    public Object execute(CommandContext commandContext) {
        ExecutionEntity execution = commandContext.getExecutionEntityManager().findExecutionById(processInstanceId);
        execution.destroyScope(reason);  //
        ProcessDefinitionImpl processDefinition = execution.getProcessDefinition();
        ActivityImpl findActivity = processDefinition.findActivity(activitiId);
        if(findActivity==null){
            throw new RuntimeException("节点不存在");
        }
        execution.executeActivity(findActivity);
        return execution;
    }
}
