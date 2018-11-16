package com.example;

import org.junit.Test;

import java.sql.Date;

/**
 * @author ywyw2424@foxmail.com
 * @date 2018/11/15 10:40
 * @desc
 */
public class Tests {

    @Test
    public void test1(){
        Date date = new Date(System.currentTimeMillis());
        System.out.println(date);
    }

}
