package com.example.model.activiti;

import java.io.Serializable;

/**
 * @Title act_ru_variable表的实体类
 * @Description 
 * @version 1.0
 * @Author yanzt
 * @Date 2018-11-01 17:32:38
 */
public class ActRuVariable implements Serializable {
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
     * 数据库字段信息：NAME_ VARCHAR(255)
     */
    private String NAME_;

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
     * 数据库字段信息：TASK_ID_ VARCHAR(64)
     */
    private String TASK_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：BYTEARRAY_ID_ VARCHAR(64)
     */
    private String BYTEARRAY_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：DOUBLE_ DOUBLE(22)
     */
    private Double DOUBLE_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：LONG_ BIGINT(19)
     */
    private Long LONG_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：TEXT_ VARCHAR(4000)
     */
    private String TEXT_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：TEXT2_ VARCHAR(4000)
     */
    private String TEXT2_;

    /**
     * act_ru_variable
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

    public String getNAME_() {
        return NAME_;
    }

    public void setNAME_(String NAME_) {
        this.NAME_ = NAME_;
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

    public String getTASK_ID_() {
        return TASK_ID_;
    }

    public void setTASK_ID_(String TASK_ID_) {
        this.TASK_ID_ = TASK_ID_;
    }

    public String getBYTEARRAY_ID_() {
        return BYTEARRAY_ID_;
    }

    public void setBYTEARRAY_ID_(String BYTEARRAY_ID_) {
        this.BYTEARRAY_ID_ = BYTEARRAY_ID_;
    }

    public Double getDOUBLE_() {
        return DOUBLE_;
    }

    public void setDOUBLE_(Double DOUBLE_) {
        this.DOUBLE_ = DOUBLE_;
    }

    public Long getLONG_() {
        return LONG_;
    }

    public void setLONG_(Long LONG_) {
        this.LONG_ = LONG_;
    }

    public String getTEXT_() {
        return TEXT_;
    }

    public void setTEXT_(String TEXT_) {
        this.TEXT_ = TEXT_;
    }

    public String getTEXT2_() {
        return TEXT2_;
    }

    public void setTEXT2_(String TEXT2_) {
        this.TEXT2_ = TEXT2_;
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
        sb.append(", NAME_=").append(NAME_);
        sb.append(", EXECUTION_ID_=").append(EXECUTION_ID_);
        sb.append(", PROC_INST_ID_=").append(PROC_INST_ID_);
        sb.append(", TASK_ID_=").append(TASK_ID_);
        sb.append(", BYTEARRAY_ID_=").append(BYTEARRAY_ID_);
        sb.append(", DOUBLE_=").append(DOUBLE_);
        sb.append(", LONG_=").append(LONG_);
        sb.append(", TEXT_=").append(TEXT_);
        sb.append(", TEXT2_=").append(TEXT2_);
        sb.append("]");
        return sb.toString();
    }
}