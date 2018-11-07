package com.example.model.activiti;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title act_re_deployment表的实体类
 * @Description 
 * @version 1.0
 * @Author yanzt
 * @Date 2018-11-01 17:32:38
 */
public class ActReDeployment implements Serializable {
    /**
     *  字段名称：
     * 
     * 数据库字段信息：ID_ VARCHAR(64)
     */
    private String ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：NAME_ VARCHAR(255)
     */
    private String NAME_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：CATEGORY_ VARCHAR(255)
     */
    private String CATEGORY_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：KEY_ VARCHAR(255)
     */
    private String KEY_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：TENANT_ID_ VARCHAR(255)
     */
    private String TENANT_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：DEPLOY_TIME_ TIMESTAMP(19)
     */
    private Date DEPLOY_TIME_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：ENGINE_VERSION_ VARCHAR(255)
     */
    private String ENGINE_VERSION_;

    /**
     * act_re_deployment
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

    public String getNAME_() {
        return NAME_;
    }

    public void setNAME_(String NAME_) {
        this.NAME_ = NAME_;
    }

    public String getCATEGORY_() {
        return CATEGORY_;
    }

    public void setCATEGORY_(String CATEGORY_) {
        this.CATEGORY_ = CATEGORY_;
    }

    public String getKEY_() {
        return KEY_;
    }

    public void setKEY_(String KEY_) {
        this.KEY_ = KEY_;
    }

    public String getTENANT_ID_() {
        return TENANT_ID_;
    }

    public void setTENANT_ID_(String TENANT_ID_) {
        this.TENANT_ID_ = TENANT_ID_;
    }

    public Date getDEPLOY_TIME_() {
        return DEPLOY_TIME_;
    }

    public void setDEPLOY_TIME_(Date DEPLOY_TIME_) {
        this.DEPLOY_TIME_ = DEPLOY_TIME_;
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
        sb.append(", NAME_=").append(NAME_);
        sb.append(", CATEGORY_=").append(CATEGORY_);
        sb.append(", KEY_=").append(KEY_);
        sb.append(", TENANT_ID_=").append(TENANT_ID_);
        sb.append(", DEPLOY_TIME_=").append(DEPLOY_TIME_);
        sb.append(", ENGINE_VERSION_=").append(ENGINE_VERSION_);
        sb.append("]");
        return sb.toString();
    }
}