package com.example.model.activiti;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title act_hi_actinst表的实体类
 * @Description 
 * @version 1.0
 * @Author yanzt
 * @Date 2018-11-01 17:32:38
 */
public class ActHiActinst implements Serializable {
    /**
     *  字段名称：
     * 
     * 数据库字段信息：ID_ VARCHAR(64)
     */
    private String ID_;

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
     * 数据库字段信息：ACT_ID_ VARCHAR(255)
     */
    private String ACT_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：TASK_ID_ VARCHAR(64)
     */
    private String TASK_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：CALL_PROC_INST_ID_ VARCHAR(64)
     */
    private String CALL_PROC_INST_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：ACT_NAME_ VARCHAR(255)
     */
    private String ACT_NAME_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：ACT_TYPE_ VARCHAR(255)
     */
    private String ACT_TYPE_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：ASSIGNEE_ VARCHAR(255)
     */
    private String ASSIGNEE_;

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
     * act_hi_actinst
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

    public String getACT_ID_() {
        return ACT_ID_;
    }

    public void setACT_ID_(String ACT_ID_) {
        this.ACT_ID_ = ACT_ID_;
    }

    public String getTASK_ID_() {
        return TASK_ID_;
    }

    public void setTASK_ID_(String TASK_ID_) {
        this.TASK_ID_ = TASK_ID_;
    }

    public String getCALL_PROC_INST_ID_() {
        return CALL_PROC_INST_ID_;
    }

    public void setCALL_PROC_INST_ID_(String CALL_PROC_INST_ID_) {
        this.CALL_PROC_INST_ID_ = CALL_PROC_INST_ID_;
    }

    public String getACT_NAME_() {
        return ACT_NAME_;
    }

    public void setACT_NAME_(String ACT_NAME_) {
        this.ACT_NAME_ = ACT_NAME_;
    }

    public String getACT_TYPE_() {
        return ACT_TYPE_;
    }

    public void setACT_TYPE_(String ACT_TYPE_) {
        this.ACT_TYPE_ = ACT_TYPE_;
    }

    public String getASSIGNEE_() {
        return ASSIGNEE_;
    }

    public void setASSIGNEE_(String ASSIGNEE_) {
        this.ASSIGNEE_ = ASSIGNEE_;
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
        sb.append(", PROC_DEF_ID_=").append(PROC_DEF_ID_);
        sb.append(", PROC_INST_ID_=").append(PROC_INST_ID_);
        sb.append(", EXECUTION_ID_=").append(EXECUTION_ID_);
        sb.append(", ACT_ID_=").append(ACT_ID_);
        sb.append(", TASK_ID_=").append(TASK_ID_);
        sb.append(", CALL_PROC_INST_ID_=").append(CALL_PROC_INST_ID_);
        sb.append(", ACT_NAME_=").append(ACT_NAME_);
        sb.append(", ACT_TYPE_=").append(ACT_TYPE_);
        sb.append(", ASSIGNEE_=").append(ASSIGNEE_);
        sb.append(", START_TIME_=").append(START_TIME_);
        sb.append(", END_TIME_=").append(END_TIME_);
        sb.append(", DURATION_=").append(DURATION_);
        sb.append(", DELETE_REASON_=").append(DELETE_REASON_);
        sb.append(", TENANT_ID_=").append(TENANT_ID_);
        sb.append("]");
        return sb.toString();
    }
}