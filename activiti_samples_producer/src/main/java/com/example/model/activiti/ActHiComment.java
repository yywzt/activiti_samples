package com.example.model.activiti;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title act_hi_comment表的实体类
 * @Description 
 * @version 1.0
 * @Author yanzt
 * @Date 2018-11-01 17:32:38
 */
public class ActHiComment implements Serializable {
    /**
     *  字段名称：
     * 
     * 数据库字段信息：ID_ VARCHAR(64)
     */
    private String ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：TYPE_ VARCHAR(255)
     */
    private String TYPE_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：TIME_ TIMESTAMP(19)
     */
    private Date TIME_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：USER_ID_ VARCHAR(255)
     */
    private String USER_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：TASK_ID_ VARCHAR(64)
     */
    private String TASK_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：PROC_INST_ID_ VARCHAR(64)
     */
    private String PROC_INST_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：ACTION_ VARCHAR(255)
     */
    private String ACTION_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：MESSAGE_ VARCHAR(4000)
     */
    private String MESSAGE_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：FULL_MSG_ LONGVARBINARY(2147483647)
     */
    private byte[] FULL_MSG_;

    /**
     * act_hi_comment
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

    public String getTYPE_() {
        return TYPE_;
    }

    public void setTYPE_(String TYPE_) {
        this.TYPE_ = TYPE_;
    }

    public Date getTIME_() {
        return TIME_;
    }

    public void setTIME_(Date TIME_) {
        this.TIME_ = TIME_;
    }

    public String getUSER_ID_() {
        return USER_ID_;
    }

    public void setUSER_ID_(String USER_ID_) {
        this.USER_ID_ = USER_ID_;
    }

    public String getTASK_ID_() {
        return TASK_ID_;
    }

    public void setTASK_ID_(String TASK_ID_) {
        this.TASK_ID_ = TASK_ID_;
    }

    public String getPROC_INST_ID_() {
        return PROC_INST_ID_;
    }

    public void setPROC_INST_ID_(String PROC_INST_ID_) {
        this.PROC_INST_ID_ = PROC_INST_ID_;
    }

    public String getACTION_() {
        return ACTION_;
    }

    public void setACTION_(String ACTION_) {
        this.ACTION_ = ACTION_;
    }

    public String getMESSAGE_() {
        return MESSAGE_;
    }

    public void setMESSAGE_(String MESSAGE_) {
        this.MESSAGE_ = MESSAGE_;
    }

    public byte[] getFULL_MSG_() {
        return FULL_MSG_;
    }

    public void setFULL_MSG_(byte[] FULL_MSG_) {
        this.FULL_MSG_ = FULL_MSG_;
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
        sb.append(", TYPE_=").append(TYPE_);
        sb.append(", TIME_=").append(TIME_);
        sb.append(", USER_ID_=").append(USER_ID_);
        sb.append(", TASK_ID_=").append(TASK_ID_);
        sb.append(", PROC_INST_ID_=").append(PROC_INST_ID_);
        sb.append(", ACTION_=").append(ACTION_);
        sb.append(", MESSAGE_=").append(MESSAGE_);
        sb.append(", FULL_MSG_=").append(FULL_MSG_);
        sb.append("]");
        return sb.toString();
    }
}