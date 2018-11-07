package com.example.model.activiti;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title act_ru_execution表的实体类
 * @Description 
 * @version 1.0
 * @Author yanzt
 * @Date 2018-11-01 17:32:38
 */
public class ActRuExecution implements Serializable {
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
     * 数据库字段信息：PROC_INST_ID_ VARCHAR(64)
     */
    private String PROC_INST_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：BUSINESS_KEY_ VARCHAR(255)
     */
    private String BUSINESS_KEY_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：PARENT_ID_ VARCHAR(64)
     */
    private String PARENT_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：PROC_DEF_ID_ VARCHAR(64)
     */
    private String PROC_DEF_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：SUPER_EXEC_ VARCHAR(64)
     */
    private String SUPER_EXEC_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：ROOT_PROC_INST_ID_ VARCHAR(64)
     */
    private String ROOT_PROC_INST_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：ACT_ID_ VARCHAR(255)
     */
    private String ACT_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：IS_ACTIVE_ TINYINT(3)
     */
    private Byte IS_ACTIVE_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：IS_CONCURRENT_ TINYINT(3)
     */
    private Byte IS_CONCURRENT_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：IS_SCOPE_ TINYINT(3)
     */
    private Byte IS_SCOPE_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：IS_EVENT_SCOPE_ TINYINT(3)
     */
    private Byte IS_EVENT_SCOPE_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：IS_MI_ROOT_ TINYINT(3)
     */
    private Byte IS_MI_ROOT_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：SUSPENSION_STATE_ INTEGER(10)
     */
    private Integer SUSPENSION_STATE_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：CACHED_ENT_STATE_ INTEGER(10)
     */
    private Integer CACHED_ENT_STATE_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：TENANT_ID_ VARCHAR(255)
     */
    private String TENANT_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：NAME_ VARCHAR(255)
     */
    private String NAME_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：START_TIME_ TIMESTAMP(19)
     */
    private Date START_TIME_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：START_USER_ID_ VARCHAR(255)
     */
    private String START_USER_ID_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：LOCK_TIME_ TIMESTAMP(19)
     */
    private Date LOCK_TIME_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：IS_COUNT_ENABLED_ TINYINT(3)
     */
    private Byte IS_COUNT_ENABLED_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：EVT_SUBSCR_COUNT_ INTEGER(10)
     */
    private Integer EVT_SUBSCR_COUNT_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：TASK_COUNT_ INTEGER(10)
     */
    private Integer TASK_COUNT_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：JOB_COUNT_ INTEGER(10)
     */
    private Integer JOB_COUNT_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：TIMER_JOB_COUNT_ INTEGER(10)
     */
    private Integer TIMER_JOB_COUNT_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：SUSP_JOB_COUNT_ INTEGER(10)
     */
    private Integer SUSP_JOB_COUNT_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：DEADLETTER_JOB_COUNT_ INTEGER(10)
     */
    private Integer DEADLETTER_JOB_COUNT_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：VAR_COUNT_ INTEGER(10)
     */
    private Integer VAR_COUNT_;

    /**
     *  字段名称：
     * 
     * 数据库字段信息：ID_LINK_COUNT_ INTEGER(10)
     */
    private Integer ID_LINK_COUNT_;

    /**
     * act_ru_execution
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

    public String getPROC_INST_ID_() {
        return PROC_INST_ID_;
    }

    public void setPROC_INST_ID_(String PROC_INST_ID_) {
        this.PROC_INST_ID_ = PROC_INST_ID_;
    }

    public String getBUSINESS_KEY_() {
        return BUSINESS_KEY_;
    }

    public void setBUSINESS_KEY_(String BUSINESS_KEY_) {
        this.BUSINESS_KEY_ = BUSINESS_KEY_;
    }

    public String getPARENT_ID_() {
        return PARENT_ID_;
    }

    public void setPARENT_ID_(String PARENT_ID_) {
        this.PARENT_ID_ = PARENT_ID_;
    }

    public String getPROC_DEF_ID_() {
        return PROC_DEF_ID_;
    }

    public void setPROC_DEF_ID_(String PROC_DEF_ID_) {
        this.PROC_DEF_ID_ = PROC_DEF_ID_;
    }

    public String getSUPER_EXEC_() {
        return SUPER_EXEC_;
    }

    public void setSUPER_EXEC_(String SUPER_EXEC_) {
        this.SUPER_EXEC_ = SUPER_EXEC_;
    }

    public String getROOT_PROC_INST_ID_() {
        return ROOT_PROC_INST_ID_;
    }

    public void setROOT_PROC_INST_ID_(String ROOT_PROC_INST_ID_) {
        this.ROOT_PROC_INST_ID_ = ROOT_PROC_INST_ID_;
    }

    public String getACT_ID_() {
        return ACT_ID_;
    }

    public void setACT_ID_(String ACT_ID_) {
        this.ACT_ID_ = ACT_ID_;
    }

    public Byte getIS_ACTIVE_() {
        return IS_ACTIVE_;
    }

    public void setIS_ACTIVE_(Byte IS_ACTIVE_) {
        this.IS_ACTIVE_ = IS_ACTIVE_;
    }

    public Byte getIS_CONCURRENT_() {
        return IS_CONCURRENT_;
    }

    public void setIS_CONCURRENT_(Byte IS_CONCURRENT_) {
        this.IS_CONCURRENT_ = IS_CONCURRENT_;
    }

    public Byte getIS_SCOPE_() {
        return IS_SCOPE_;
    }

    public void setIS_SCOPE_(Byte IS_SCOPE_) {
        this.IS_SCOPE_ = IS_SCOPE_;
    }

    public Byte getIS_EVENT_SCOPE_() {
        return IS_EVENT_SCOPE_;
    }

    public void setIS_EVENT_SCOPE_(Byte IS_EVENT_SCOPE_) {
        this.IS_EVENT_SCOPE_ = IS_EVENT_SCOPE_;
    }

    public Byte getIS_MI_ROOT_() {
        return IS_MI_ROOT_;
    }

    public void setIS_MI_ROOT_(Byte IS_MI_ROOT_) {
        this.IS_MI_ROOT_ = IS_MI_ROOT_;
    }

    public Integer getSUSPENSION_STATE_() {
        return SUSPENSION_STATE_;
    }

    public void setSUSPENSION_STATE_(Integer SUSPENSION_STATE_) {
        this.SUSPENSION_STATE_ = SUSPENSION_STATE_;
    }

    public Integer getCACHED_ENT_STATE_() {
        return CACHED_ENT_STATE_;
    }

    public void setCACHED_ENT_STATE_(Integer CACHED_ENT_STATE_) {
        this.CACHED_ENT_STATE_ = CACHED_ENT_STATE_;
    }

    public String getTENANT_ID_() {
        return TENANT_ID_;
    }

    public void setTENANT_ID_(String TENANT_ID_) {
        this.TENANT_ID_ = TENANT_ID_;
    }

    public String getNAME_() {
        return NAME_;
    }

    public void setNAME_(String NAME_) {
        this.NAME_ = NAME_;
    }

    public Date getSTART_TIME_() {
        return START_TIME_;
    }

    public void setSTART_TIME_(Date START_TIME_) {
        this.START_TIME_ = START_TIME_;
    }

    public String getSTART_USER_ID_() {
        return START_USER_ID_;
    }

    public void setSTART_USER_ID_(String START_USER_ID_) {
        this.START_USER_ID_ = START_USER_ID_;
    }

    public Date getLOCK_TIME_() {
        return LOCK_TIME_;
    }

    public void setLOCK_TIME_(Date LOCK_TIME_) {
        this.LOCK_TIME_ = LOCK_TIME_;
    }

    public Byte getIS_COUNT_ENABLED_() {
        return IS_COUNT_ENABLED_;
    }

    public void setIS_COUNT_ENABLED_(Byte IS_COUNT_ENABLED_) {
        this.IS_COUNT_ENABLED_ = IS_COUNT_ENABLED_;
    }

    public Integer getEVT_SUBSCR_COUNT_() {
        return EVT_SUBSCR_COUNT_;
    }

    public void setEVT_SUBSCR_COUNT_(Integer EVT_SUBSCR_COUNT_) {
        this.EVT_SUBSCR_COUNT_ = EVT_SUBSCR_COUNT_;
    }

    public Integer getTASK_COUNT_() {
        return TASK_COUNT_;
    }

    public void setTASK_COUNT_(Integer TASK_COUNT_) {
        this.TASK_COUNT_ = TASK_COUNT_;
    }

    public Integer getJOB_COUNT_() {
        return JOB_COUNT_;
    }

    public void setJOB_COUNT_(Integer JOB_COUNT_) {
        this.JOB_COUNT_ = JOB_COUNT_;
    }

    public Integer getTIMER_JOB_COUNT_() {
        return TIMER_JOB_COUNT_;
    }

    public void setTIMER_JOB_COUNT_(Integer TIMER_JOB_COUNT_) {
        this.TIMER_JOB_COUNT_ = TIMER_JOB_COUNT_;
    }

    public Integer getSUSP_JOB_COUNT_() {
        return SUSP_JOB_COUNT_;
    }

    public void setSUSP_JOB_COUNT_(Integer SUSP_JOB_COUNT_) {
        this.SUSP_JOB_COUNT_ = SUSP_JOB_COUNT_;
    }

    public Integer getDEADLETTER_JOB_COUNT_() {
        return DEADLETTER_JOB_COUNT_;
    }

    public void setDEADLETTER_JOB_COUNT_(Integer DEADLETTER_JOB_COUNT_) {
        this.DEADLETTER_JOB_COUNT_ = DEADLETTER_JOB_COUNT_;
    }

    public Integer getVAR_COUNT_() {
        return VAR_COUNT_;
    }

    public void setVAR_COUNT_(Integer VAR_COUNT_) {
        this.VAR_COUNT_ = VAR_COUNT_;
    }

    public Integer getID_LINK_COUNT_() {
        return ID_LINK_COUNT_;
    }

    public void setID_LINK_COUNT_(Integer ID_LINK_COUNT_) {
        this.ID_LINK_COUNT_ = ID_LINK_COUNT_;
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
        sb.append(", PROC_INST_ID_=").append(PROC_INST_ID_);
        sb.append(", BUSINESS_KEY_=").append(BUSINESS_KEY_);
        sb.append(", PARENT_ID_=").append(PARENT_ID_);
        sb.append(", PROC_DEF_ID_=").append(PROC_DEF_ID_);
        sb.append(", SUPER_EXEC_=").append(SUPER_EXEC_);
        sb.append(", ROOT_PROC_INST_ID_=").append(ROOT_PROC_INST_ID_);
        sb.append(", ACT_ID_=").append(ACT_ID_);
        sb.append(", IS_ACTIVE_=").append(IS_ACTIVE_);
        sb.append(", IS_CONCURRENT_=").append(IS_CONCURRENT_);
        sb.append(", IS_SCOPE_=").append(IS_SCOPE_);
        sb.append(", IS_EVENT_SCOPE_=").append(IS_EVENT_SCOPE_);
        sb.append(", IS_MI_ROOT_=").append(IS_MI_ROOT_);
        sb.append(", SUSPENSION_STATE_=").append(SUSPENSION_STATE_);
        sb.append(", CACHED_ENT_STATE_=").append(CACHED_ENT_STATE_);
        sb.append(", TENANT_ID_=").append(TENANT_ID_);
        sb.append(", NAME_=").append(NAME_);
        sb.append(", START_TIME_=").append(START_TIME_);
        sb.append(", START_USER_ID_=").append(START_USER_ID_);
        sb.append(", LOCK_TIME_=").append(LOCK_TIME_);
        sb.append(", IS_COUNT_ENABLED_=").append(IS_COUNT_ENABLED_);
        sb.append(", EVT_SUBSCR_COUNT_=").append(EVT_SUBSCR_COUNT_);
        sb.append(", TASK_COUNT_=").append(TASK_COUNT_);
        sb.append(", JOB_COUNT_=").append(JOB_COUNT_);
        sb.append(", TIMER_JOB_COUNT_=").append(TIMER_JOB_COUNT_);
        sb.append(", SUSP_JOB_COUNT_=").append(SUSP_JOB_COUNT_);
        sb.append(", DEADLETTER_JOB_COUNT_=").append(DEADLETTER_JOB_COUNT_);
        sb.append(", VAR_COUNT_=").append(VAR_COUNT_);
        sb.append(", ID_LINK_COUNT_=").append(ID_LINK_COUNT_);
        sb.append("]");
        return sb.toString();
    }
}