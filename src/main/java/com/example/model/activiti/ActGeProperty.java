package com.example.model.activiti;

import java.io.Serializable;

/**
 * @Title act_ge_property表的实体类
 * @Description 
 * @version 1.0
 * @Author yanzt
 * @Date 2018-11-01 17:32:38
 */
public class ActGeProperty implements Serializable {
    /**
     *  字段名称：
     * 
     * 数据库字段信息：NAME_ VARCHAR(64)
     */
    private String NAME_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：VALUE_ VARCHAR(300)
     */
    private String VALUE_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：REV_ INTEGER(10)
     */
    private Integer REV_;

    /**
     * act_ge_property
     *
     * @mbg.generated 2018-11-01 17:32:38
     */
    private static final long serialVersionUID = 1L;

    public String getNAME_() {
        return NAME_;
    }

    public void setNAME_(String NAME_) {
        this.NAME_ = NAME_;
    }

    public String getVALUE_() {
        return VALUE_;
    }

    public void setVALUE_(String VALUE_) {
        this.VALUE_ = VALUE_;
    }

    public Integer getREV_() {
        return REV_;
    }

    public void setREV_(Integer REV_) {
        this.REV_ = REV_;
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
        sb.append(", NAME_=").append(NAME_);
        sb.append(", VALUE_=").append(VALUE_);
        sb.append(", REV_=").append(REV_);
        sb.append("]");
        return sb.toString();
    }
}