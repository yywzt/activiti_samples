package com.example.constant;

/**
 * @author yanzt
 * @date 2018/12/10 16:54
 * @describe
 */
public enum ApprovalState {

    ADOPT(0,"不通过"),
    PASS(1,"通过");

    private Integer state;
    private String name;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private ApprovalState(Integer state, String name) {
        this.setState(state);
        this.setName(name);
    }

    public static String getName(Integer state)
    {
        for (ApprovalState e : ApprovalState.values()) {
            if(e.state.equals(state))
                return  e.name;
        }
        return ADOPT.name;
    }
}
