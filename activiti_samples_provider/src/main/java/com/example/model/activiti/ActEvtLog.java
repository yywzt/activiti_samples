package com.example.model.activiti;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title act_evt_log表的实体类
 * @Description 
 * @version 1.0
 * @Author yanzt
 * @Date 2018-11-01 17:32:38
 */
public class ActEvtLog implements Serializable {
    /**
     *  字段名称：
     * 
     * 数据库字段信息：LOG_NR_ BIGINT(19)
     */
    private Long LOG_NR_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：TYPE_ VARCHAR(64)
     */
    private String TYPE_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：PROC_DEF_ID_ VARCHAR(64)
     */
    private String PROC_DEF_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：PROC_INST_ID_ VARCHAR(64)
     */
    private String PROC_INST_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：EXECUTION_ID_ VARCHAR(64)
     */
    private String EXECUTION_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：TASK_ID_ VARCHAR(64)
     */
    private String TASK_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：TIME_STAMP_ TIMESTAMP(19)
     */
    private Date TIME_STAMP_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：USER_ID_ VARCHAR(255)
     */
    private String USER_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：LOCK_OWNER_ VARCHAR(255)
     */
    private String LOCK_OWNER_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：LOCK_TIME_ TIMESTAMP(19)
     */
    private Date LOCK_TIME_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：IS_PROCESSED_ TINYINT(3)
     */
    private Byte IS_PROCESSED_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：DATA_ LONGVARBINARY(2147483647)
     */
    private byte[] DATA_;

    /**
     * act_evt_log
     *
     * @mbg.generated 2018-11-01 17:32:38
     */
    private static final long serialVersionUID = 1L;

    public Long getLOG_NR_() {
        return LOG_NR_;
    }

    public void setLOG_NR_(Long LOG_NR_) {
        this.LOG_NR_ = LOG_NR_;
    }

    public String getTYPE_() {
        return TYPE_;
    }

    public void setTYPE_(String TYPE_) {
        this.TYPE_ = TYPE_;
    }

    public String getPROC_DEF_ID_() {
        return PROC_DEF_ID_;
    }

    public void setPROC_DEF_ID_(String PROC_DEF_ID_) {
        this.PROC_DEF_ID_ = PROC_DEF_ID_;
    }

    public String getPROC_INST_ID_() {
        return PROC_INST_ID_;
    }

    public void setPROC_INST_ID_(String PROC_INST_ID_) {
        this.PROC_INST_ID_ = PROC_INST_ID_;
    }

    public String getEXECUTION_ID_() {
        return EXECUTION_ID_;
    }

    public void setEXECUTION_ID_(String EXECUTION_ID_) {
        this.EXECUTION_ID_ = EXECUTION_ID_;
    }

    public String getTASK_ID_() {
        return TASK_ID_;
    }

    public void setTASK_ID_(String TASK_ID_) {
        this.TASK_ID_ = TASK_ID_;
    }

    public Date getTIME_STAMP_() {
        return TIME_STAMP_;
    }

    public void setTIME_STAMP_(Date TIME_STAMP_) {
        this.TIME_STAMP_ = TIME_STAMP_;
    }

    public String getUSER_ID_() {
        return USER_ID_;
    }

    public void setUSER_ID_(String USER_ID_) {
        this.USER_ID_ = USER_ID_;
    }

    public String getLOCK_OWNER_() {
        return LOCK_OWNER_;
    }

    public void setLOCK_OWNER_(String LOCK_OWNER_) {
        this.LOCK_OWNER_ = LOCK_OWNER_;
    }

    public Date getLOCK_TIME_() {
        return LOCK_TIME_;
    }

    public void setLOCK_TIME_(Date LOCK_TIME_) {
        this.LOCK_TIME_ = LOCK_TIME_;
    }

    public Byte getIS_PROCESSED_() {
        return IS_PROCESSED_;
    }

    public void setIS_PROCESSED_(Byte IS_PROCESSED_) {
        this.IS_PROCESSED_ = IS_PROCESSED_;
    }

    public byte[] getDATA_() {
        return DATA_;
    }

    public void setDATA_(byte[] DATA_) {
        this.DATA_ = DATA_;
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
        sb.append(", LOG_NR_=").append(LOG_NR_);
        sb.append(", TYPE_=").append(TYPE_);
        sb.append(", PROC_DEF_ID_=").append(PROC_DEF_ID_);
        sb.append(", PROC_INST_ID_=").append(PROC_INST_ID_);
        sb.append(", EXECUTION_ID_=").append(EXECUTION_ID_);
        sb.append(", TASK_ID_=").append(TASK_ID_);
        sb.append(", TIME_STAMP_=").append(TIME_STAMP_);
        sb.append(", USER_ID_=").append(USER_ID_);
        sb.append(", LOCK_OWNER_=").append(LOCK_OWNER_);
        sb.append(", LOCK_TIME_=").append(LOCK_TIME_);
        sb.append(", IS_PROCESSED_=").append(IS_PROCESSED_);
        sb.append(", DATA_=").append(DATA_);
        sb.append("]");
        return sb.toString();
    }
}