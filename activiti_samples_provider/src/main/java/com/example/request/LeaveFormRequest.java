package com.example.request;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

/**
 * @author yanzt
 * @date 2018/12/14 14:01
 * @describe
 */
@Data
public class LeaveFormRequest implements Serializable {

    private Long id;
    private String processInstanceId;
    private String processDefinitionId;
    private String userId;
    private Date startTime;
    private Date endTime;
    @NotEmpty(message = "请假时长为空")
    private String leaveDays;

    @NotEmpty(message = "请假缘由为空")
    private String leaveReason;

    /**
     * 部门领导是否同意
     */
    private String deptLeaderApproved;
    private String deptLeaderApprovedMsg;

    /**
     * HR是否同意
     */
    private String directSuperiorApproved;
    private String directSuperiorApprovedMsg;

}
