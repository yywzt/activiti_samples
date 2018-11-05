package com.example.model.activiti;

import java.io.Serializable;

/**
 * @Title act_id_membership表的实体类
 * @Description 
 * @version 1.0
 * @Author yanzt
 * @Date 2018-11-01 17:32:38
 */
public class ActIdMembershipKey implements Serializable {
    /**
     *  字段名称：
     * 
     * 数据库字段信息：USER_ID_ VARCHAR(64)
     */
    private String USER_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：GROUP_ID_ VARCHAR(64)
     */
    private String GROUP_ID_;

    /**
     * act_id_membership
     *
     * @mbg.generated 2018-11-01 17:32:38
     */
    private static final long serialVersionUID = 1L;

    public String getUSER_ID_() {
        return USER_ID_;
    }

    public void setUSER_ID_(String USER_ID_) {
        this.USER_ID_ = USER_ID_;
    }

    public String getGROUP_ID_() {
        return GROUP_ID_;
    }

    public void setGROUP_ID_(String GROUP_ID_) {
        this.GROUP_ID_ = GROUP_ID_;
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
        sb.append(", USER_ID_=").append(USER_ID_);
        sb.append(", GROUP_ID_=").append(GROUP_ID_);
        sb.append("]");
        return sb.toString();
    }
}