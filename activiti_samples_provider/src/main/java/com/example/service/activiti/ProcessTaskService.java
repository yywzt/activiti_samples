package com.example.service.activiti;

import com.example.bo.TaskDoForm;
import com.example.constant.ProcessCode;
import com.example.handler.TaskHandler;
import com.example.handler.TaskHandlerFactory;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.RepositoryServiceImpl;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.impl.pvm.ReadOnlyProcessDefinition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author yanzt
 * @date 2018/12/20 13:47
 * @describe
 */
@Service
@Slf4j
public class ProcessTaskService {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskHandlerFactory taskHandlerFactory;

    /**
     *  根据ActivityId 查询出来想要活动Activity
     * @param id
     * @return
     */
    public ActivityImpl  queryTargetActivity(String id){

        ReadOnlyProcessDefinition deployedProcessDefinition = (ProcessDefinitionEntity)((RepositoryServiceImpl)repositoryService).getDeployedProcessDefinition("ziyouliu:1:4");
        List<ActivityImpl> activities = (List<ActivityImpl>) deployedProcessDefinition.getActivities();
        for (ActivityImpl activityImpl : activities) {
            if(activityImpl.getId().equals(id)){
                return activityImpl;
            }
        }
        return null;
    }

    /**
     * 查询当前的活动节点
     */
    public ActivityImpl qureyCurrentTask(String processDefinitionId) {
//		String processDefinitionId="ziyouliu:1:4";
        Execution execution = runtimeService.createExecutionQuery().processDefinitionId(processDefinitionId).singleResult();
        String activityId = execution.getActivityId();
        ActivityImpl currentActivity = queryTargetActivity(activityId);
        System.out.println(currentActivity.getId() + "" + currentActivity.getProperty("name"));
        return currentActivity;
    }

    /**
     * 保存任务数据并提交任务
     *
     * @param taskDoForm
     */
    public void submitTask(TaskDoForm taskDoForm) {
        //设置用户id
        Authentication.setAuthenticatedUserId(taskDoForm.getUserId());
        TaskEntity taskEntity = (TaskEntity) taskService.createTaskQuery()
                .taskId(taskDoForm.getTaskId())
                .includeTaskLocalVariables()
                .includeProcessVariables()
                .singleResult();
        taskDoForm.setProcessInstanceId(taskEntity.getProcessInstanceId());
        this.saveTaskData(taskDoForm);
        taskEntity.setAssignee(taskDoForm.getUserId());
        taskService.saveTask(taskEntity);
        TaskHandler taskHandler = taskHandlerFactory.getTaskHanlder(taskDoForm.getOperate());
        if (taskHandler != null) {
            taskHandler.doHandler(taskEntity, taskDoForm);
        } else {
            throw new RuntimeException(ProcessCode.VALID_OPERATOR.getMessage());
        }
    }

    /**
     * 保存批注数据
     *
     * @param taskDoForm
     */
    public void saveTaskData(TaskDoForm taskDoForm) {
        if (taskDoForm == null
                || StringUtils.isEmpty(taskDoForm.getTaskId())
                || StringUtils.isEmpty(taskDoForm.getProcessInstanceId())) {
            return;
        }
        if (!StringUtils.isEmpty(taskDoForm.getCommentId())) {
            Comment comment = taskService.getComment(taskDoForm.getCommentId());
            if (comment != null) {
                taskService.deleteComment(taskDoForm.getCommentId());
            }
        }
        Authentication.setAuthenticatedUserId(taskDoForm.getUserId());
        String message = "{\"operate\":\"" + taskDoForm.getOperate() + "\",\"message\":\"" + taskDoForm.getMessage() + "\"}";
        taskService.addComment(taskDoForm.getTaskId(), taskDoForm.getProcessInstanceId(), message);
    }

    /**
     * 任务催办
     * */
    public void reminder(String instanceId) {
        List<Task> taskList = taskService.createTaskQuery()
                .processInstanceId(instanceId)
                .includeTaskLocalVariables()
                .includeProcessVariables().list();
        for (Task task :
                taskList) {
            //通知待办人
        }
    }
}
