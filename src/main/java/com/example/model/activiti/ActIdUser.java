package com.example.model.activiti;

import java.io.Serializable;

/**
 * @Title act_id_user表的实体类
 * @Description 
 * @version 1.0
 * @Author yanzt
 * @Date 2018-11-01 17:32:38
 */
public class ActIdUser implements Serializable {
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
     * 数据库字段信息：FIRST_ VARCHAR(255)
     */
    private String FIRST_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：LAST_ VARCHAR(255)
     */
    private String LAST_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：EMAIL_ VARCHAR(255)
     */
    private String EMAIL_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：PWD_ VARCHAR(255)
     */
    private String PWD_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：PICTURE_ID_ VARCHAR(64)
     */
    private String PICTURE_ID_;

    /**
     * act_id_user
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

    public String getFIRST_() {
        return FIRST_;
    }

    public void setFIRST_(String FIRST_) {
        this.FIRST_ = FIRST_;
    }

    public String getLAST_() {
        return LAST_;
    }

    public void setLAST_(String LAST_) {
        this.LAST_ = LAST_;
    }

    public String getEMAIL_() {
        return EMAIL_;
    }

    public void setEMAIL_(String EMAIL_) {
        this.EMAIL_ = EMAIL_;
    }

    public String getPWD_() {
        return PWD_;
    }

    public void setPWD_(String PWD_) {
        this.PWD_ = PWD_;
    }

    public String getPICTURE_ID_() {
        return PICTURE_ID_;
    }

    public void setPICTURE_ID_(String PICTURE_ID_) {
        this.PICTURE_ID_ = PICTURE_ID_;
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
        sb.append(", FIRST_=").append(FIRST_);
        sb.append(", LAST_=").append(LAST_);
        sb.append(", EMAIL_=").append(EMAIL_);
        sb.append(", PWD_=").append(PWD_);
        sb.append(", PICTURE_ID_=").append(PICTURE_ID_);
        sb.append("]");
        return sb.toString();
    }
}