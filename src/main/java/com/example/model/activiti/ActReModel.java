package com.example.model.activiti;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title act_re_model表的实体类
 * @Description 
 * @version 1.0
 * @Author yanzt
 * @Date 2018-11-01 17:32:38
 */
public class ActReModel implements Serializable {
    /**
     *  字段名称：
     * 
     * 数据库字段信息：ID_ VARCHAR(64)
     */
    private String ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：REV_ INTEGER(10)
     */
    private Integer REV_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：NAME_ VARCHAR(255)
     */
    private String NAME_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：KEY_ VARCHAR(255)
     */
    private String KEY_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：CATEGORY_ VARCHAR(255)
     */
    private String CATEGORY_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：CREATE_TIME_ TIMESTAMP(19)
     */
    private Date CREATE_TIME_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：LAST_UPDATE_TIME_ TIMESTAMP(19)
     */
    private Date LAST_UPDATE_TIME_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：VERSION_ INTEGER(10)
     */
    private Integer VERSION_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：META_INFO_ VARCHAR(4000)
     */
    private String META_INFO_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：DEPLOYMENT_ID_ VARCHAR(64)
     */
    private String DEPLOYMENT_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：EDITOR_SOURCE_VALUE_ID_ VARCHAR(64)
     */
    private String EDITOR_SOURCE_VALUE_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：EDITOR_SOURCE_EXTRA_VALUE_ID_ VARCHAR(64)
     */
    private String EDITOR_SOURCE_EXTRA_VALUE_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：TENANT_ID_ VARCHAR(255)
     */
    private String TENANT_ID_;

    /**
     * act_re_model
     *
     * @mbg.generated 2018-11-01 17:32:38
     */
    private static final long serialVersionUID = 1L;

    public String getID_() {
        return ID_;
    }

    public void setID_(String ID_) {
        this.ID_ = ID_;
    }

    public Integer getREV_() {
        return REV_;
    }

    public void setREV_(Integer REV_) {
        this.REV_ = REV_;
    }

    public String getNAME_() {
        return NAME_;
    }

    public void setNAME_(String NAME_) {
        this.NAME_ = NAME_;
    }

    public String getKEY_() {
        return KEY_;
    }

    public void setKEY_(String KEY_) {
        this.KEY_ = KEY_;
    }

    public String getCATEGORY_() {
        return CATEGORY_;
    }

    public void setCATEGORY_(String CATEGORY_) {
        this.CATEGORY_ = CATEGORY_;
    }

    public Date getCREATE_TIME_() {
        return CREATE_TIME_;
    }

    public void setCREATE_TIME_(Date CREATE_TIME_) {
        this.CREATE_TIME_ = CREATE_TIME_;
    }

    public Date getLAST_UPDATE_TIME_() {
        return LAST_UPDATE_TIME_;
    }

    public void setLAST_UPDATE_TIME_(Date LAST_UPDATE_TIME_) {
        this.LAST_UPDATE_TIME_ = LAST_UPDATE_TIME_;
    }

    public Integer getVERSION_() {
        return VERSION_;
    }

    public void setVERSION_(Integer VERSION_) {
        this.VERSION_ = VERSION_;
    }

    public String getMETA_INFO_() {
        return META_INFO_;
    }

    public void setMETA_INFO_(String META_INFO_) {
        this.META_INFO_ = META_INFO_;
    }

    public String getDEPLOYMENT_ID_() {
        return DEPLOYMENT_ID_;
    }

    public void setDEPLOYMENT_ID_(String DEPLOYMENT_ID_) {
        this.DEPLOYMENT_ID_ = DEPLOYMENT_ID_;
    }

    public String getEDITOR_SOURCE_VALUE_ID_() {
        return EDITOR_SOURCE_VALUE_ID_;
    }

    public void setEDITOR_SOURCE_VALUE_ID_(String EDITOR_SOURCE_VALUE_ID_) {
        this.EDITOR_SOURCE_VALUE_ID_ = EDITOR_SOURCE_VALUE_ID_;
    }

    public String getEDITOR_SOURCE_EXTRA_VALUE_ID_() {
        return EDITOR_SOURCE_EXTRA_VALUE_ID_;
    }

    public void setEDITOR_SOURCE_EXTRA_VALUE_ID_(String EDITOR_SOURCE_EXTRA_VALUE_ID_) {
        this.EDITOR_SOURCE_EXTRA_VALUE_ID_ = EDITOR_SOURCE_EXTRA_VALUE_ID_;
    }

    public String getTENANT_ID_() {
        return TENANT_ID_;
    }

    public void setTENANT_ID_(String TENANT_ID_) {
        this.TENANT_ID_ = TENANT_ID_;
    }

    /**
     * @describe
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ID_=").append(ID_);
        sb.append(", REV_=").append(REV_);
        sb.append(", NAME_=").append(NAME_);
        sb.append(", KEY_=").append(KEY_);
        sb.append(", CATEGORY_=").append(CATEGORY_);
        sb.append(", CREATE_TIME_=").append(CREATE_TIME_);
        sb.append(", LAST_UPDATE_TIME_=").append(LAST_UPDATE_TIME_);
        sb.append(", VERSION_=").append(VERSION_);
        sb.append(", META_INFO_=").append(META_INFO_);
        sb.append(", DEPLOYMENT_ID_=").append(DEPLOYMENT_ID_);
        sb.append(", EDITOR_SOURCE_VALUE_ID_=").append(EDITOR_SOURCE_VALUE_ID_);
        sb.append(", EDITOR_SOURCE_EXTRA_VALUE_ID_=").append(EDITOR_SOURCE_EXTRA_VALUE_ID_);
        sb.append(", TENANT_ID_=").append(TENANT_ID_);
        sb.append("]");
        return sb.toString();
    }
}