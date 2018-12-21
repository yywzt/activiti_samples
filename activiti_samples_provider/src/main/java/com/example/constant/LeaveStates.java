package com.example.constant;

/**
 * @author ywyw2424@foxmail.com
 * @date 2018/11/26 16:59
 * @desc
 */
public enum LeaveStates {

    NO_COMMIT("0","未提交"),
    IN_APPROVAL("1","审核中 "),
    PASS_APPROVAL("2","审核通过 "),
    FAILED_APPROVAL("3","审核未通过"),
    END_APPROVAL("4","流程终止");

    private String state;
    private String name;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    LeaveStates(String state, String name) {
        this.setState(state);
        this.setName(name);
    }

    public static String getName(String state)
    {
        for (LeaveStates e : LeaveStates.values()) {
            if(e.state.equals(state))
                return  e.name;
        }
        return NO_COMMIT.name;
    }
}
