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

    // 任务id
    private String id;

    // 任务名称
    private String name;

    // 创建日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    // 结束日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date endTime;

    //是否认领任务 true：已认领为个人任务   false：待认领
    private boolean isClaim;
}
