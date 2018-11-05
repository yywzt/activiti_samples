package com.example.model.activiti;

import java.io.Serializable;

/**
 * @Title act_ru_identitylink表的实体类
 * @Description 
 * @version 1.0
 * @Author yanzt
 * @Date 2018-11-01 17:32:38
 */
public class ActRuIdentitylink implements Serializable {
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
     * 数据库字段信息：GROUP_ID_ VARCHAR(255)
     */
    private String GROUP_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：TYPE_ VARCHAR(255)
     */
    private String TYPE_;

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
     * 数据库字段信息：PROC_DEF_ID_ VARCHAR(64)
     */
    private String PROC_DEF_ID_;

    /**
     * act_ru_identitylink
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

    public String getGROUP_ID_() {
        return GROUP_ID_;
    }

    public void setGROUP_ID_(String GROUP_ID_) {
        this.GROUP_ID_ = GROUP_ID_;
    }

    public String getTYPE_() {
        return TYPE_;
    }

    public void setTYPE_(String TYPE_) {
        this.TYPE_ = TYPE_;
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

    public String getPROC_DEF_ID_() {
        return PROC_DEF_ID_;
    }

    public void setPROC_DEF_ID_(String PROC_DEF_ID_) {
        this.PROC_DEF_ID_ = PROC_DEF_ID_;
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
        sb.append(", GROUP_ID_=").append(GROUP_ID_);
        sb.append(", TYPE_=").append(TYPE_);
        sb.append(", USER_ID_=").append(USER_ID_);
        sb.append(", TASK_ID_=").append(TASK_ID_);
        sb.append(", PROC_INST_ID_=").append(PROC_INST_ID_);
        sb.append(", PROC_DEF_ID_=").append(PROC_DEF_ID_);
        sb.append("]");
        return sb.toString();
    }
}