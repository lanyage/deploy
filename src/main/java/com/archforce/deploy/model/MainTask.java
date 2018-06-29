package com.archforce.deploy.model;

import java.util.Date;

public class MainTask {
    private Integer taskId;

    private String taskType;

    private Integer productId;

    private String targetVersion;

    private Integer taskState;

    private String taskDesc;

    private Date createTime;

    private String createUser;

    private Date updateTime;

    private String updateUser;

    public Integer getTaskId() {
        return taskId;
    }

    public MainTask setTaskId(Integer taskId) {
        this.taskId = taskId;
        return this;
    }

    public String getTaskType() {
        return taskType;
    }

    public MainTask setTaskType(String taskType) {
        this.taskType = taskType == null ? null : taskType.trim();
        return this;
    }

    public Integer getProductId() {
        return productId;
    }

    public MainTask setProductId(Integer productId) {
        this.productId = productId;
        return this;
    }

    public String getTargetVersion() {
        return targetVersion;
    }

    public MainTask setTargetVersion(String targetVersion) {
        this.targetVersion = targetVersion == null ? null : targetVersion.trim();
        return this;
    }

    public Integer getTaskState() {
        return taskState;
    }

    public MainTask setTaskState(Integer taskState) {
        this.taskState = taskState;
        return this;
    }

    public String getTaskDesc() {
        return taskDesc;
    }

    public MainTask setTaskDesc(String taskDesc) {
        this.taskDesc = taskDesc == null ? null : taskDesc.trim();
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public MainTask setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public MainTask setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public MainTask setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public MainTask setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
        return this;
    }
}