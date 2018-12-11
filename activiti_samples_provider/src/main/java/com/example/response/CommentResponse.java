package com.example.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author yanzt
 * @date 2018/12/11 10:40
 * @describe 历史批注响应信息
 */
@Data
public class CommentResponse {

    private String userId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date time;

    //批注信息
    private String message;
}
