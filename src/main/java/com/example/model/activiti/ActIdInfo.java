package com.example.model.activiti;

import java.io.Serializable;

/**
 * @Title act_id_info表的实体类
 * @Description 
 * @version 1.0
 * @Author yanzt
 * @Date 2018-11-01 17:32:38
 */
public class ActIdInfo implements Serializable {
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
     * 数据库字段信息：USER_ID_ VARCHAR(64)
     */
    private String USER_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：TYPE_ VARCHAR(64)
     */
    private String TYPE_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：KEY_ VARCHAR(255)
     */
    private String KEY_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：VALUE_ VARCHAR(255)
     */
    private String VALUE_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：PARENT_ID_ VARCHAR(255)
     */
    private String PARENT_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：PASSWORD_ LONGVARBINARY(2147483647)
     */
    private byte[] PASSWORD_;

    /**
     * act_id_info
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

    public String getUSER_ID_() {
        return USER_ID_;
    }

    public void setUSER_ID_(String USER_ID_) {
        this.USER_ID_ = USER_ID_;
    }

    public String getTYPE_() {
        return TYPE_;
    }

    public void setTYPE_(String TYPE_) {
        this.TYPE_ = TYPE_;
    }

    public String getKEY_() {
        return KEY_;
    }

    public void setKEY_(String KEY_) {
        this.KEY_ = KEY_;
    }

    public String getVALUE_() {
        return VALUE_;
    }

    public void setVALUE_(String VALUE_) {
        this.VALUE_ = VALUE_;
    }

    public String getPARENT_ID_() {
        return PARENT_ID_;
    }

    public void setPARENT_ID_(String PARENT_ID_) {
        this.PARENT_ID_ = PARENT_ID_;
    }

    public byte[] getPASSWORD_() {
        return PASSWORD_;
    }

    public void setPASSWORD_(byte[] PASSWORD_) {
        this.PASSWORD_ = PASSWORD_;
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
        sb.append(", USER_ID_=").append(USER_ID_);
        sb.append(", TYPE_=").append(TYPE_);
        sb.append(", KEY_=").append(KEY_);
        sb.append(", VALUE_=").append(VALUE_);
        sb.append(", PARENT_ID_=").append(PARENT_ID_);
        sb.append(", PASSWORD_=").append(PASSWORD_);
        sb.append("]");
        return sb.toString();
    }
}