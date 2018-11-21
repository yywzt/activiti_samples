package com.example.model.activiti;

import java.io.Serializable;

/**
 * @Title act_procdef_info表的实体类
 * @Description 
 * @version 1.0
 * @Author yanzt
 * @Date 2018-11-01 17:32:38
 */
public class ActProcdefInfo implements Serializable {
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
     * 数据库字段信息：REV_ INTEGER(10)
     */
    private Integer REV_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：INFO_JSON_ID_ VARCHAR(64)
     */
    private String INFO_JSON_ID_;

    /**
     * act_procdef_info
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

    public Integer getREV_() {
        return REV_;
    }

    public void setREV_(Integer REV_) {
        this.REV_ = REV_;
    }

    public String getINFO_JSON_ID_() {
        return INFO_JSON_ID_;
    }

    public void setINFO_JSON_ID_(String INFO_JSON_ID_) {
        this.INFO_JSON_ID_ = INFO_JSON_ID_;
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
        sb.append(", REV_=").append(REV_);
        sb.append(", INFO_JSON_ID_=").append(INFO_JSON_ID_);
        sb.append("]");
        return sb.toString();
    }
}