package com.archforce.deploy.enums;

/**
 * Created by lanyage on 2018/6/28.
 */
public enum TaskType {
    INSTALLING("首次安装"), UPGRADING("产品升级"), EXPANDING("产品扩容"), REGAINING("产品回退");
    private final String v;

    TaskType(String v) {
        this.v = v;
    }

    public String getV() {
        return v;
    }
}
