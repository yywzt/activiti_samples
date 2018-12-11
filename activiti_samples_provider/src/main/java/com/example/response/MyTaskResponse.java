package com.example.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yanzt
 * @date 2018/12/7 16:34
 * @describe
 */
@Data
public class MyTaskResponse implements Serializable {

    private String id; // 任务id
    private String name; // 任务名称
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;  // 创建日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endTime; // 结束日期
}
