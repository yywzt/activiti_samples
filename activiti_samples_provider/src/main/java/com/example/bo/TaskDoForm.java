package com.example.bo;

import lombok.Data;

import java.util.Map;

/**
 * @author yanzt
 * @date 2018/12/20 14:21
 * @describe
 */
@Data
public class TaskDoForm {

    /**
     * 当前任务处理人
     * */
    private String userId;
    /**
     * 任务ID
     */
    private String taskId;

    /**
     * 流程实例ID
     */
    private String processInstanceId;

    /**
     * 流程变量
     * */
    private Map<String,Object> variables;

    /**
     * 处理意见ID
     */
    private String commentId;

    /**
     * 操作：同意 驳回 跳转
     * */
    private String operate;

    /**
     * 处理意见
     */
    private String message;

    /**
     * 当前任务节点
     * */
    private String currentNodeId;
    /**
     * 目标节点（任务跳转用）
     */
    private String targetNodeId;

    /**
     * 审批状态 0-驳回 1-同意
     * */
    private Integer state;
}
