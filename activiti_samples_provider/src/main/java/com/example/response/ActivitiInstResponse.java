package com.example.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author yanzt
 * @date 2018/12/11 11:33
 * @describe 流程执行过程响应
 */
@Data
public class ActivitiInstResponse {

    /**
     * 任务节点ID
     * */
    private String activitiId;

    /**
     * 任务节点名称
     * */
    private String activitiName;

    /**
     * 开始时间
     * */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**
     * 结束时间
     * */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
}
