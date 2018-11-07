package com.example.model.activiti;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title act_ru_event_subscr表的实体类
 * @Description 
 * @version 1.0
 * @Author yanzt
 * @Date 2018-11-01 17:32:38
 */
public class ActRuEventSubscr implements Serializable {
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
     * 数据库字段信息：EVENT_TYPE_ VARCHAR(255)
     */
    private String EVENT_TYPE_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：EVENT_NAME_ VARCHAR(255)
     */
    private String EVENT_NAME_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：EXECUTION_ID_ VARCHAR(64)
     */
    private String EXECUTION_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：PROC_INST_ID_ VARCHAR(64)
     */
    private String PROC_INST_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：ACTIVITY_ID_ VARCHAR(64)
     */
    private String ACTIVITY_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：CONFIGURATION_ VARCHAR(255)
     */
    private String CONFIGURATION_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：CREATED_ TIMESTAMP(19)
     */
    private Date CREATED_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：PROC_DEF_ID_ VARCHAR(64)
     */
    private String PROC_DEF_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：TENANT_ID_ VARCHAR(255)
     */
    private String TENANT_ID_;

    /**
     * act_ru_event_subscr
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

    public String getEVENT_TYPE_() {
        return EVENT_TYPE_;
    }

    public void setEVENT_TYPE_(String EVENT_TYPE_) {
        this.EVENT_TYPE_ = EVENT_TYPE_;
    }

    public String getEVENT_NAME_() {
        return EVENT_NAME_;
    }

    public void setEVENT_NAME_(String EVENT_NAME_) {
        this.EVENT_NAME_ = EVENT_NAME_;
    }

    public String getEXECUTION_ID_() {
        return EXECUTION_ID_;
    }

    public void setEXECUTION_ID_(String EXECUTION_ID_) {
        this.EXECUTION_ID_ = EXECUTION_ID_;
    }

    public String getPROC_INST_ID_() {
        return PROC_INST_ID_;
    }

    public void setPROC_INST_ID_(String PROC_INST_ID_) {
        this.PROC_INST_ID_ = PROC_INST_ID_;
    }

    public String getACTIVITY_ID_() {
        return ACTIVITY_ID_;
    }

    public void setACTIVITY_ID_(String ACTIVITY_ID_) {
        this.ACTIVITY_ID_ = ACTIVITY_ID_;
    }

    public String getCONFIGURATION_() {
        return CONFIGURATION_;
    }

    public void setCONFIGURATION_(String CONFIGURATION_) {
        this.CONFIGURATION_ = CONFIGURATION_;
    }

    public Date getCREATED_() {
        return CREATED_;
    }

    public void setCREATED_(Date CREATED_) {
        this.CREATED_ = CREATED_;
    }

    public String getPROC_DEF_ID_() {
        return PROC_DEF_ID_;
    }

    public void setPROC_DEF_ID_(String PROC_DEF_ID_) {
        this.PROC_DEF_ID_ = PROC_DEF_ID_;
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
        sb.append(", EVENT_TYPE_=").append(EVENT_TYPE_);
        sb.append(", EVENT_NAME_=").append(EVENT_NAME_);
        sb.append(", EXECUTION_ID_=").append(EXECUTION_ID_);
        sb.append(", PROC_INST_ID_=").append(PROC_INST_ID_);
        sb.append(", ACTIVITY_ID_=").append(ACTIVITY_ID_);
        sb.append(", CONFIGURATION_=").append(CONFIGURATION_);
        sb.append(", CREATED_=").append(CREATED_);
        sb.append(", PROC_DEF_ID_=").append(PROC_DEF_ID_);
        sb.append(", TENANT_ID_=").append(TENANT_ID_);
        sb.append("]");
        return sb.toString();
    }
}