package com.example.model;

import com.example.constant.LeaveStates;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

/**
 * @author ywyw2424@foxmail.com
 * @date 2018/11/26 16:51
 * @desc 请假单model
 */
@Data
@Entity
@Table(name = "leave")
public class Leave extends BaseModel<Long> implements Serializable {

    @NotEmpty(message = "用户id为空")
    @Column(name = "userId")
    private String userId;

    @Column(name = "leaveDate")
    private Date leaveDate;

    @NotEmpty(message = "请假时长为空")
    @Column(name = "leaveDays")
    private Long leaveDays;

    @NotEmpty(message = "请假缘由为空")
    @Column(name = "leaveReason")
    private String leaveReason;

    /**
     * 审核状态  0未提交  1审核中 2审核通过 3审核未通过
     * */
    @Column(name = "state")
    private String state;

    //流程实例ID
    @Column(name = "processInstanceId")
    private String processInstanceId;

    public String getLeaveState(){
        return LeaveStates.getName(getState());
    }
}
