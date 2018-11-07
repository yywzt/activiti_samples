package com.example.model.activiti;

import java.io.Serializable;

/**
 * @Title act_re_procdef表的实体类
 * @Description 
 * @version 1.0
 * @Author yanzt
 * @Date 2018-11-01 17:32:38
 */
public class ActReProcdef implements Serializable {
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
     * 数据库字段信息：CATEGORY_ VARCHAR(255)
     */
    private String CATEGORY_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：NAME_ VARCHAR(255)
     */
    private String NAME_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：KEY_ VARCHAR(255)
     */
    private String KEY_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：VERSION_ INTEGER(10)
     */
    private Integer VERSION_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：DEPLOYMENT_ID_ VARCHAR(64)
     */
    private String DEPLOYMENT_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：RESOURCE_NAME_ VARCHAR(4000)
     */
    private String RESOURCE_NAME_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：DGRM_RESOURCE_NAME_ VARCHAR(4000)
     */
    private String DGRM_RESOURCE_NAME_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：DESCRIPTION_ VARCHAR(4000)
     */
    private String DESCRIPTION_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：HAS_START_FORM_KEY_ TINYINT(3)
     */
    private Byte HAS_START_FORM_KEY_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：HAS_GRAPHICAL_NOTATION_ TINYINT(3)
     */
    private Byte HAS_GRAPHICAL_NOTATION_;

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
     * 数据库字段信息：ENGINE_VERSION_ VARCHAR(255)
     */
    private String ENGINE_VERSION_;

    /**
     * act_re_procdef
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

    public String getCATEGORY_() {
        return CATEGORY_;
    }

    public void setCATEGORY_(String CATEGORY_) {
        this.CATEGORY_ = CATEGORY_;
    }

    public String getNAME_() {
        return NAME_;
    }

    public void setNAME_(String NAME_) {
        this.NAME_ = NAME_;
    }

    public String getKEY_() {
        return KEY_;
    }

    public void setKEY_(String KEY_) {
        this.KEY_ = KEY_;
    }

    public Integer getVERSION_() {
        return VERSION_;
    }

    public void setVERSION_(Integer VERSION_) {
        this.VERSION_ = VERSION_;
    }

    public String getDEPLOYMENT_ID_() {
        return DEPLOYMENT_ID_;
    }

    public void setDEPLOYMENT_ID_(String DEPLOYMENT_ID_) {
        this.DEPLOYMENT_ID_ = DEPLOYMENT_ID_;
    }

    public String getRESOURCE_NAME_() {
        return RESOURCE_NAME_;
    }

    public void setRESOURCE_NAME_(String RESOURCE_NAME_) {
        this.RESOURCE_NAME_ = RESOURCE_NAME_;
    }

    public String getDGRM_RESOURCE_NAME_() {
        return DGRM_RESOURCE_NAME_;
    }

    public void setDGRM_RESOURCE_NAME_(String DGRM_RESOURCE_NAME_) {
        this.DGRM_RESOURCE_NAME_ = DGRM_RESOURCE_NAME_;
    }

    public String getDESCRIPTION_() {
        return DESCRIPTION_;
    }

    public void setDESCRIPTION_(String DESCRIPTION_) {
        this.DESCRIPTION_ = DESCRIPTION_;
    }

    public Byte getHAS_START_FORM_KEY_() {
        return HAS_START_FORM_KEY_;
    }

    public void setHAS_START_FORM_KEY_(Byte HAS_START_FORM_KEY_) {
        this.HAS_START_FORM_KEY_ = HAS_START_FORM_KEY_;
    }

    public Byte getHAS_GRAPHICAL_NOTATION_() {
        return HAS_GRAPHICAL_NOTATION_;
    }

    public void setHAS_GRAPHICAL_NOTATION_(Byte HAS_GRAPHICAL_NOTATION_) {
        this.HAS_GRAPHICAL_NOTATION_ = HAS_GRAPHICAL_NOTATION_;
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

    public String getENGINE_VERSION_() {
        return ENGINE_VERSION_;
    }

    public void setENGINE_VERSION_(String ENGINE_VERSION_) {
        this.ENGINE_VERSION_ = ENGINE_VERSION_;
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
        sb.append(", CATEGORY_=").append(CATEGORY_);
        sb.append(", NAME_=").append(NAME_);
        sb.append(", KEY_=").append(KEY_);
        sb.append(", VERSION_=").append(VERSION_);
        sb.append(", DEPLOYMENT_ID_=").append(DEPLOYMENT_ID_);
        sb.append(", RESOURCE_NAME_=").append(RESOURCE_NAME_);
        sb.append(", DGRM_RESOURCE_NAME_=").append(DGRM_RESOURCE_NAME_);
        sb.append(", DESCRIPTION_=").append(DESCRIPTION_);
        sb.append(", HAS_START_FORM_KEY_=").append(HAS_START_FORM_KEY_);
        sb.append(", HAS_GRAPHICAL_NOTATION_=").append(HAS_GRAPHICAL_NOTATION_);
        sb.append(", SUSPENSION_STATE_=").append(SUSPENSION_STATE_);
        sb.append(", TENANT_ID_=").append(TENANT_ID_);
        sb.append(", ENGINE_VERSION_=").append(ENGINE_VERSION_);
        sb.append("]");
        return sb.toString();
    }
}