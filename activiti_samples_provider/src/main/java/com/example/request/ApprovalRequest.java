package com.example.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author yanzt
 * @date 2018/12/10 16:46
 * @describe  审批请求参数
 */
@Data
public class ApprovalRequest {

    //任务id
    @NotEmpty(message = "任务id为空")
    private String id;

    /**
     * 是否审批通过
     * 0：不通过
     * 1：通过
     * */
    @NotNull(message = "审批状态为空")
    private Integer state;

    //批注
    private String comment;
}
