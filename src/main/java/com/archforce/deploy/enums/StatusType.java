package com.archforce.deploy.enums;

/**
 * Created by lanyage on 2018/6/29.
 */
public enum StatusType {
    SUCCEED(0),
    FAILED(1),
    INSTALLING(2),
    UPGRADING(3),
    EXPANDING(4),
    REGAINING(5),
    NOT_INSTALLED(-2),
    NOT_UPGRADED(-3),
    NOT_EXPANDED(-4),
    NOT_REGAINED(-5),
    DELETED(-6);
    private int i;

    StatusType(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }
}
