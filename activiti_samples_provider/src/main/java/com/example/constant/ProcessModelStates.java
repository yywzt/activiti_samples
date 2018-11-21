package com.example.constant;

/**
 * @author ywyw2424@foxmail.com
 * @date 2018/11/16 11:16
 * @desc
 */
public enum ProcessModelStates {

    SAVE(0,"草稿"),
    ENBLED(1,"启用"),
    DISABLED(2,"停用");

    private int state;
    private String name;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private ProcessModelStates(int state, String name) {
        this.setState(state);
        this.setName(name);
    }

    public static String getName(int state)
    {
        for (ProcessModelStates e : ProcessModelStates.values()) {
            if(e.state==state)
                return  e.name;
        }
        return SAVE.name;
    }
}
