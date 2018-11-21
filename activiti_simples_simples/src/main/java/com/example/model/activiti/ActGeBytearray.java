package com.example.model.activiti;

import java.io.Serializable;

/**
 * @Title act_ge_bytearray表的实体类
 * @Description 
 * @version 1.0
 * @Author yanzt
 * @Date 2018-11-01 17:32:38
 */
public class ActGeBytearray implements Serializable {
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
     * 数据库字段信息：NAME_ VARCHAR(255)
     */
    private String NAME_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：DEPLOYMENT_ID_ VARCHAR(64)
     */
    private String DEPLOYMENT_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：GENERATED_ TINYINT(3)
     */
    private Byte GENERATED_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：BYTES_ LONGVARBINARY(2147483647)
     */
    private byte[] BYTES_;

    /**
     * act_ge_bytearray
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

    public String getNAME_() {
        return NAME_;
    }

    public void setNAME_(String NAME_) {
        this.NAME_ = NAME_;
    }

    public String getDEPLOYMENT_ID_() {
        return DEPLOYMENT_ID_;
    }

    public void setDEPLOYMENT_ID_(String DEPLOYMENT_ID_) {
        this.DEPLOYMENT_ID_ = DEPLOYMENT_ID_;
    }

    public Byte getGENERATED_() {
        return GENERATED_;
    }

    public void setGENERATED_(Byte GENERATED_) {
        this.GENERATED_ = GENERATED_;
    }

    public byte[] getBYTES_() {
        return BYTES_;
    }

    public void setBYTES_(byte[] BYTES_) {
        this.BYTES_ = BYTES_;
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
        sb.append(", NAME_=").append(NAME_);
        sb.append(", DEPLOYMENT_ID_=").append(DEPLOYMENT_ID_);
        sb.append(", GENERATED_=").append(GENERATED_);
        sb.append(", BYTES_=").append(BYTES_);
        sb.append("]");
        return sb.toString();
    }
}