package com.example.service;

import com.example.model.BaseModel;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author ywyw2424@foxmail.com
 * @date 2018/11/16 11:24
 * @desc
 */
@Transactional
public class BaseService<T> {

    /**
     * 设置添加公用参数
     *
     * @param data
     */
    protected void setDefault(T data, boolean isNew) {
        if (data instanceof BaseModel) {
            BaseModel model = (BaseModel) data;

            if (isNew) {
                if (model.getCreationDate() == null) {
                    model.setCreationDate(new Timestamp(new Date().getTime()));
                }
                model.setCreatedBy("-1");
            }

            model.setUpdationDate(new Timestamp(new Date().getTime()));

            model.setUpdatedBy("-1");

            if (model.getEnabledFlag() == null) {
                model.setEnabledFlag(1L);
            }
        }
    }
}
