package com.example.bo;

import lombok.Data;

/**
 * @author yanzt
 * @date 2018/12/20 16:20
 * @describe
 */
@Data
public class ActivitiBo {

    private String id;

    private String name;

    public ActivitiBo(String id, String name) {
        this.id = id;
        this.name = name;
    }
}

