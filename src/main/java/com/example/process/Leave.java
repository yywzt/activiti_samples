package com.example.process;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ywyw2424@foxmail.com
 * @date 2018/11/5 15:23
 * @desc 请假model
 */
@Data
public class Leave implements Serializable {

    private static final long serialVersionUID = 2248469053125414262L;

    private String userId;

    private Boolean submit;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endDate;

    private float totalDay;

    private String desc;

    private String taskId;

    private String taskName;

    private String approver1;

    private Boolean agree1;

    private String approveDesc1;

    private String approver2;

    private Boolean agree2;

    private String approveDesc2;
}
