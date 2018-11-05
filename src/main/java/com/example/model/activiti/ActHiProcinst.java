package com.example.model.activiti;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title act_hi_procinst表的实体类
 * @Description 
 * @version 1.0
 * @Author yanzt
 * @Date 2018-11-01 17:32:38
 */
public class ActHiProcinst implements Serializable {
    /**
     *  字段名称：
     * 
     * 数据库字段信息：ID_ VARCHAR(64)
     */
    private String ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：PROC_INST_ID_ VARCHAR(64)
     */
    private String PROC_INST_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：BUSINESS_KEY_ VARCHAR(255)
     */
    private String BUSINESS_KEY_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：PROC_DEF_ID_ VARCHAR(64)
     */
    private String PROC_DEF_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：START_TIME_ TIMESTAMP(19)
     */
    private Date START_TIME_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：END_TIME_ TIMESTAMP(19)
     */
    private Date END_TIME_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：DURATION_ BIGINT(19)
     */
    private Long DURATION_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：START_USER_ID_ VARCHAR(255)
     */
    private String START_USER_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：START_ACT_ID_ VARCHAR(255)
     */
    private String START_ACT_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：END_ACT_ID_ VARCHAR(255)
     */
    private String END_ACT_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：SUPER_PROCESS_INSTANCE_ID_ VARCHAR(64)
     */
    private String SUPER_PROCESS_INSTANCE_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：DELETE_REASON_ VARCHAR(4000)
     */
    private String DELETE_REASON_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：TENANT_ID_ VARCHAR(255)
     */
    private String TENANT_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：NAME_ VARCHAR(255)
     */
    private String NAME_;

    /**
     * act_hi_procinst
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

    public String getPROC_INST_ID_() {
        return PROC_INST_ID_;
    }

    public void setPROC_INST_ID_(String PROC_INST_ID_) {
        this.PROC_INST_ID_ = PROC_INST_ID_;
    }

    public String getBUSINESS_KEY_() {
        return BUSINESS_KEY_;
    }

    public void setBUSINESS_KEY_(String BUSINESS_KEY_) {
        this.BUSINESS_KEY_ = BUSINESS_KEY_;
    }

    public String getPROC_DEF_ID_() {
        return PROC_DEF_ID_;
    }

    public void setPROC_DEF_ID_(String PROC_DEF_ID_) {
        this.PROC_DEF_ID_ = PROC_DEF_ID_;
    }

    public Date getSTART_TIME_() {
        return START_TIME_;
    }

    public void setSTART_TIME_(Date START_TIME_) {
        this.START_TIME_ = START_TIME_;
    }

    public Date getEND_TIME_() {
        return END_TIME_;
    }

    public void setEND_TIME_(Date END_TIME_) {
        this.END_TIME_ = END_TIME_;
    }

    public Long getDURATION_() {
        return DURATION_;
    }

    public void setDURATION_(Long DURATION_) {
        this.DURATION_ = DURATION_;
    }

    public String getSTART_USER_ID_() {
        return START_USER_ID_;
    }

    public void setSTART_USER_ID_(String START_USER_ID_) {
        this.START_USER_ID_ = START_USER_ID_;
    }

    public String getSTART_ACT_ID_() {
        return START_ACT_ID_;
    }

    public void setSTART_ACT_ID_(String START_ACT_ID_) {
        this.START_ACT_ID_ = START_ACT_ID_;
    }

    public String getEND_ACT_ID_() {
        return END_ACT_ID_;
    }

    public void setEND_ACT_ID_(String END_ACT_ID_) {
        this.END_ACT_ID_ = END_ACT_ID_;
    }

    public String getSUPER_PROCESS_INSTANCE_ID_() {
        return SUPER_PROCESS_INSTANCE_ID_;
    }

    public void setSUPER_PROCESS_INSTANCE_ID_(String SUPER_PROCESS_INSTANCE_ID_) {
        this.SUPER_PROCESS_INSTANCE_ID_ = SUPER_PROCESS_INSTANCE_ID_;
    }

    public String getDELETE_REASON_() {
        return DELETE_REASON_;
    }

    public void setDELETE_REASON_(String DELETE_REASON_) {
        this.DELETE_REASON_ = DELETE_REASON_;
    }

    public String getTENANT_ID_() {
        return TENANT_ID_;
    }

    public void setTENANT_ID_(String TENANT_ID_) {
        this.TENANT_ID_ = TENANT_ID_;
    }

    public String getNAME_() {
        return NAME_;
    }

    public void setNAME_(String NAME_) {
        this.NAME_ = NAME_;
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
        sb.append(", PROC_INST_ID_=").append(PROC_INST_ID_);
        sb.append(", BUSINESS_KEY_=").append(BUSINESS_KEY_);
        sb.append(", PROC_DEF_ID_=").append(PROC_DEF_ID_);
        sb.append(", START_TIME_=").append(START_TIME_);
        sb.append(", END_TIME_=").append(END_TIME_);
        sb.append(", DURATION_=").append(DURATION_);
        sb.append(", START_USER_ID_=").append(START_USER_ID_);
        sb.append(", START_ACT_ID_=").append(START_ACT_ID_);
        sb.append(", END_ACT_ID_=").append(END_ACT_ID_);
        sb.append(", SUPER_PROCESS_INSTANCE_ID_=").append(SUPER_PROCESS_INSTANCE_ID_);
        sb.append(", DELETE_REASON_=").append(DELETE_REASON_);
        sb.append(", TENANT_ID_=").append(TENANT_ID_);
        sb.append(", NAME_=").append(NAME_);
        sb.append("]");
        return sb.toString();
    }
}