package com.example.model.activiti;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title act_ru_task表的实体类
 * @Description 
 * @version 1.0
 * @Author yanzt
 * @Date 2018-11-01 17:32:38
 */
public class ActRuTask implements Serializable {
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
     * 数据库字段信息：PROC_DEF_ID_ VARCHAR(64)
     */
    private String PROC_DEF_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：NAME_ VARCHAR(255)
     */
    private String NAME_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：PARENT_TASK_ID_ VARCHAR(64)
     */
    private String PARENT_TASK_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：DESCRIPTION_ VARCHAR(4000)
     */
    private String DESCRIPTION_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：TASK_DEF_KEY_ VARCHAR(255)
     */
    private String TASK_DEF_KEY_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：OWNER_ VARCHAR(255)
     */
    private String OWNER_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：ASSIGNEE_ VARCHAR(255)
     */
    private String ASSIGNEE_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：DELEGATION_ VARCHAR(64)
     */
    private String DELEGATION_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：PRIORITY_ INTEGER(10)
     */
    private Integer PRIORITY_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：CREATE_TIME_ TIMESTAMP(19)
     */
    private Date CREATE_TIME_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：DUE_DATE_ TIMESTAMP(19)
     */
    private Date DUE_DATE_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：CATEGORY_ VARCHAR(255)
     */
    private String CATEGORY_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：SUSPENSION_STATE_ INTEGER(10)
     */
    private Integer SUSPENSION_STATE_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：TENANT_ID_ VARCHAR(255)
     */
    private String TENANT_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：FORM_KEY_ VARCHAR(255)
     */
    private String FORM_KEY_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：CLAIM_TIME_ TIMESTAMP(19)
     */
    private Date CLAIM_TIME_;

    /**
     * act_ru_task
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

    public String getPROC_DEF_ID_() {
        return PROC_DEF_ID_;
    }

    public void setPROC_DEF_ID_(String PROC_DEF_ID_) {
        this.PROC_DEF_ID_ = PROC_DEF_ID_;
    }

    public String getNAME_() {
        return NAME_;
    }

    public void setNAME_(String NAME_) {
        this.NAME_ = NAME_;
    }

    public String getPARENT_TASK_ID_() {
        return PARENT_TASK_ID_;
    }

    public void setPARENT_TASK_ID_(String PARENT_TASK_ID_) {
        this.PARENT_TASK_ID_ = PARENT_TASK_ID_;
    }

    public String getDESCRIPTION_() {
        return DESCRIPTION_;
    }

    public void setDESCRIPTION_(String DESCRIPTION_) {
        this.DESCRIPTION_ = DESCRIPTION_;
    }

    public String getTASK_DEF_KEY_() {
        return TASK_DEF_KEY_;
    }

    public void setTASK_DEF_KEY_(String TASK_DEF_KEY_) {
        this.TASK_DEF_KEY_ = TASK_DEF_KEY_;
    }

    public String getOWNER_() {
        return OWNER_;
    }

    public void setOWNER_(String OWNER_) {
        this.OWNER_ = OWNER_;
    }

    public String getASSIGNEE_() {
        return ASSIGNEE_;
    }

    public void setASSIGNEE_(String ASSIGNEE_) {
        this.ASSIGNEE_ = ASSIGNEE_;
    }

    public String getDELEGATION_() {
        return DELEGATION_;
    }

    public void setDELEGATION_(String DELEGATION_) {
        this.DELEGATION_ = DELEGATION_;
    }

    public Integer getPRIORITY_() {
        return PRIORITY_;
    }

    public void setPRIORITY_(Integer PRIORITY_) {
        this.PRIORITY_ = PRIORITY_;
    }

    public Date getCREATE_TIME_() {
        return CREATE_TIME_;
    }

    public void setCREATE_TIME_(Date CREATE_TIME_) {
        this.CREATE_TIME_ = CREATE_TIME_;
    }

    public Date getDUE_DATE_() {
        return DUE_DATE_;
    }

    public void setDUE_DATE_(Date DUE_DATE_) {
        this.DUE_DATE_ = DUE_DATE_;
    }

    public String getCATEGORY_() {
        return CATEGORY_;
    }

    public void setCATEGORY_(String CATEGORY_) {
        this.CATEGORY_ = CATEGORY_;
    }

    public Integer getSUSPENSION_STATE_() {
        return SUSPENSION_STATE_;
    }

    public void setSUSPENSION_STATE_(Integer SUSPENSION_STATE_) {
        this.SUSPENSION_STATE_ = SUSPENSION_STATE_;
    }

    public String getTENANT_ID_() {
        return TENANT_ID_;
    }

    public void setTENANT_ID_(String TENANT_ID_) {
        this.TENANT_ID_ = TENANT_ID_;
    }

    public String getFORM_KEY_() {
        return FORM_KEY_;
    }

    public void setFORM_KEY_(String FORM_KEY_) {
        this.FORM_KEY_ = FORM_KEY_;
    }

    public Date getCLAIM_TIME_() {
        return CLAIM_TIME_;
    }

    public void setCLAIM_TIME_(Date CLAIM_TIME_) {
        this.CLAIM_TIME_ = CLAIM_TIME_;
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
        sb.append(", EXECUTION_ID_=").append(EXECUTION_ID_);
        sb.append(", PROC_INST_ID_=").append(PROC_INST_ID_);
        sb.append(", PROC_DEF_ID_=").append(PROC_DEF_ID_);
        sb.append(", NAME_=").append(NAME_);
        sb.append(", PARENT_TASK_ID_=").append(PARENT_TASK_ID_);
        sb.append(", DESCRIPTION_=").append(DESCRIPTION_);
        sb.append(", TASK_DEF_KEY_=").append(TASK_DEF_KEY_);
        sb.append(", OWNER_=").append(OWNER_);
        sb.append(", ASSIGNEE_=").append(ASSIGNEE_);
        sb.append(", DELEGATION_=").append(DELEGATION_);
        sb.append(", PRIORITY_=").append(PRIORITY_);
        sb.append(", CREATE_TIME_=").append(CREATE_TIME_);
        sb.append(", DUE_DATE_=").append(DUE_DATE_);
        sb.append(", CATEGORY_=").append(CATEGORY_);
        sb.append(", SUSPENSION_STATE_=").append(SUSPENSION_STATE_);
        sb.append(", TENANT_ID_=").append(TENANT_ID_);
        sb.append(", FORM_KEY_=").append(FORM_KEY_);
        sb.append(", CLAIM_TIME_=").append(CLAIM_TIME_);
        sb.append("]");
        return sb.toString();
    }
}