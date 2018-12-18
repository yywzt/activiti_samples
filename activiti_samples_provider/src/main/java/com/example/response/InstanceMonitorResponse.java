package com.example.response;

import lombok.Data;

/**
 * @author ywyw2424@foxmail.com
 * @date 2018/12/18 16:55
 * @desc
 */
@Data
public class InstanceMonitorResponse {

    private String taskId;

    private String currentNode;

    private String currentNodeId;

    private String instanceName;

    private String assigneeName;

    private String processDefinitionId;
    private String processDefinitionKey;
    private String processDefinitionName;
    private Integer processDefinitionVersion;
    private String processInstanceId;
}
