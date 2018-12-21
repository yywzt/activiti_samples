package com.example.constant;

/***
 * 消息中心错误码定义
 * @author weishuichao
 * @createTime 2017-02-16 10:03
 */
public enum ProcessCode {
    //	16000-16499
    PLATFORM_ARG_ERROR(16000,"参数错误,%s"),

    FLOW_ARG_ERROR(16001,"流程错误,%s"),
    DEPLOY_ERROR(16002,"部署流程错误"),
    NOT_FIND_PROCESS_MODEL(16003,"未找到流程定义"),
    NOT_FIND_START(16004,"未找到流程开始结点"),
    SAVE_FORM_DATA_FAIL(16005,"保存流程表单失败"),
    NOT_FIND_ORG(16006,"未找到组织"),
    APPROVE_SUBIMTI(16007,"申请单已提交，不能重复提交"),
    TASK_FINISHED(16008,"任务已完成,不能进行回退操作"),
    TASK_NOT_EXSIT(16009,"任务不存在"),
    TASK_NODE_NOT_EXSIT(16010,"节点不存在"),
    END_NOT_EXSIT(16011,"结束节点不存在"),
    VALID_OPERATOR(16012,"无此操作"),
    NOT_FIND_BACK_TRAN(16013,"未找到回退的路径"),
    TASK_WITHDRAW_FAIL(16014,"任务撤回失败，未找到该任务"),
    FLOW_OTHER_ERROR(16015,"%s");

    private int code;
    private String message;
    private String format;

    ProcessCode(int code, String message) {
        this.setCode(code);
        this.setMessage(message);
        this.format=message;
    }

    public  ProcessCode format(Object... msgArgs) {
        this.message =  String.format(this.format, msgArgs);
        return this;
    }

    @Override
    public String toString() {
        return Integer.toString(getCode());
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }


}
