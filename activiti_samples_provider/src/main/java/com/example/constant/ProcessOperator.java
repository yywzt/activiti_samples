package com.example.constant;

public enum ProcessOperator {
    JUMP("jump","跳转"),
    END("end","终止"),
    WITHDRAW("withdraw","撤回"),
    REJECT_BACK("rejectBack","驳回（上一节点）"),
    REJECT_FIRST("rejectFirst","驳回（发起人）"),
    DISAGREE("disagree","不同意（结束流程）"),
    AGREE("agree","同意");



    private String value;
    private String name;

    ProcessOperator(String value, String name){
        this.value=value;
        this.name=name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
}
