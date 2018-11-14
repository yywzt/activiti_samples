package com.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author ywyw2424@foxmail.com
 * @date 2018/11/14 14:43
 * @desc
 */
@Data
@MappedSuperclass
public class BaseModel<PK> implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    protected PK id;

    /**
     * 创建人
     */
    @Column(name = "created_by")
    protected String createdBy;

    /**
     * 创建日期
     */
    @Column(name = "creation_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    protected Timestamp creationDate;

    /**
     * 修改人
     */
    @Column(name = "updated_by")
    protected String updatedBy;

    /**
     * 修改日期
     */
    @Column(name = "updation_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    protected Timestamp updationDate;

    /**
     * 是否可用
     */
    @Column(name = "enabled_flag")
    protected Long enabledFlag = 1L;
}
