package com.example.model.activiti;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title act_ru_deadletter_job表的实体类
 * @Description 
 * @version 1.0
 * @Author yanzt
 * @Date 2018-11-01 17:32:38
 */
public class ActRuDeadletterJob implements Serializable {
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
     * 数据库字段信息：TYPE_ VARCHAR(255)
     */
    private String TYPE_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：EXCLUSIVE_ BIT(0)
     */
    private Boolean EXCLUSIVE_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：EXECUTION_ID_ VARCHAR(64)
     */
    private String EXECUTION_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：PROCESS_INSTANCE_ID_ VARCHAR(64)
     */
    private String PROCESS_INSTANCE_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：PROC_DEF_ID_ VARCHAR(64)
     */
    private String PROC_DEF_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：EXCEPTION_STACK_ID_ VARCHAR(64)
     */
    private String EXCEPTION_STACK_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：EXCEPTION_MSG_ VARCHAR(4000)
     */
    private String EXCEPTION_MSG_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：DUEDATE_ TIMESTAMP(19)
     */
    private Date DUEDATE_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：REPEAT_ VARCHAR(255)
     */
    private String REPEAT_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：HANDLER_TYPE_ VARCHAR(255)
     */
    private String HANDLER_TYPE_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：HANDLER_CFG_ VARCHAR(4000)
     */
    private String HANDLER_CFG_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：TENANT_ID_ VARCHAR(255)
     */
    private String TENANT_ID_;

    /**
     * act_ru_deadletter_job
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

    public String getTYPE_() {
        return TYPE_;
    }

    public void setTYPE_(String TYPE_) {
        this.TYPE_ = TYPE_;
    }

    public Boolean getEXCLUSIVE_() {
        return EXCLUSIVE_;
    }

    public void setEXCLUSIVE_(Boolean EXCLUSIVE_) {
        this.EXCLUSIVE_ = EXCLUSIVE_;
    }

    public String getEXECUTION_ID_() {
        return EXECUTION_ID_;
    }

    public void setEXECUTION_ID_(String EXECUTION_ID_) {
        this.EXECUTION_ID_ = EXECUTION_ID_;
    }

    public String getPROCESS_INSTANCE_ID_() {
        return PROCESS_INSTANCE_ID_;
    }

    public void setPROCESS_INSTANCE_ID_(String PROCESS_INSTANCE_ID_) {
        this.PROCESS_INSTANCE_ID_ = PROCESS_INSTANCE_ID_;
    }

    public String getPROC_DEF_ID_() {
        return PROC_DEF_ID_;
    }

    public void setPROC_DEF_ID_(String PROC_DEF_ID_) {
        this.PROC_DEF_ID_ = PROC_DEF_ID_;
    }

    public String getEXCEPTION_STACK_ID_() {
        return EXCEPTION_STACK_ID_;
    }

    public void setEXCEPTION_STACK_ID_(String EXCEPTION_STACK_ID_) {
        this.EXCEPTION_STACK_ID_ = EXCEPTION_STACK_ID_;
    }

    public String getEXCEPTION_MSG_() {
        return EXCEPTION_MSG_;
    }

    public void setEXCEPTION_MSG_(String EXCEPTION_MSG_) {
        this.EXCEPTION_MSG_ = EXCEPTION_MSG_;
    }

    public Date getDUEDATE_() {
        return DUEDATE_;
    }

    public void setDUEDATE_(Date DUEDATE_) {
        this.DUEDATE_ = DUEDATE_;
    }

    public String getREPEAT_() {
        return REPEAT_;
    }

    public void setREPEAT_(String REPEAT_) {
        this.REPEAT_ = REPEAT_;
    }

    public String getHANDLER_TYPE_() {
        return HANDLER_TYPE_;
    }

    public void setHANDLER_TYPE_(String HANDLER_TYPE_) {
        this.HANDLER_TYPE_ = HANDLER_TYPE_;
    }

    public String getHANDLER_CFG_() {
        return HANDLER_CFG_;
    }

    public void setHANDLER_CFG_(String HANDLER_CFG_) {
        this.HANDLER_CFG_ = HANDLER_CFG_;
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
        sb.append(", TYPE_=").append(TYPE_);
        sb.append(", EXCLUSIVE_=").append(EXCLUSIVE_);
        sb.append(", EXECUTION_ID_=").append(EXECUTION_ID_);
        sb.append(", PROCESS_INSTANCE_ID_=").append(PROCESS_INSTANCE_ID_);
        sb.append(", PROC_DEF_ID_=").append(PROC_DEF_ID_);
        sb.append(", EXCEPTION_STACK_ID_=").append(EXCEPTION_STACK_ID_);
        sb.append(", EXCEPTION_MSG_=").append(EXCEPTION_MSG_);
        sb.append(", DUEDATE_=").append(DUEDATE_);
        sb.append(", REPEAT_=").append(REPEAT_);
        sb.append(", HANDLER_TYPE_=").append(HANDLER_TYPE_);
        sb.append(", HANDLER_CFG_=").append(HANDLER_CFG_);
        sb.append(", TENANT_ID_=").append(TENANT_ID_);
        sb.append("]");
        return sb.toString();
    }
}