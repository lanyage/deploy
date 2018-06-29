package com.archforce.deploy.model;

import java.util.Date;

public class SubTask {
    private Integer subTaskId;

    private Integer taskId;

    private Integer subTaskOrder;

    private Integer moduleInstId;

    private String previousVersion;

    private String targetVersion;

    private Integer subTaskState;

    private Date createTime;

    private String createUser;

    private Date updateTime;

    private String updateUser;

    public Integer getSubTaskId() {
        return subTaskId;
    }

    public SubTask setSubTaskId(Integer subTaskId) {
        this.subTaskId = subTaskId;
        return this;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public SubTask setTaskId(Integer taskId) {
        this.taskId = taskId;
        return this;
    }

    public Integer getSubTaskOrder() {
        return subTaskOrder;
    }

    public SubTask setSubTaskOrder(Integer subTaskOrder) {
        this.subTaskOrder = subTaskOrder;
        return this;
    }

    public Integer getModuleInstId() {
        return moduleInstId;
    }

    public SubTask setModuleInstId(Integer moduleInstId) {
        this.moduleInstId = moduleInstId;
        return this;
    }

    public String getPreviousVersion() {
        return previousVersion;
    }

    public SubTask setPreviousVersion(String previousVersion) {
        this.previousVersion = previousVersion == null ? null : previousVersion.trim();
        return this;
    }

    public String getTargetVersion() {
        return targetVersion;
    }

    public SubTask setTargetVersion(String targetVersion) {
        this.targetVersion = targetVersion == null ? null : targetVersion.trim();
        return this;
    }

    public Integer getSubTaskState() {
        return subTaskState;
    }

    public SubTask setSubTaskState(Integer subTaskState) {
        this.subTaskState = subTaskState;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public SubTask setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public SubTask setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public SubTask setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public SubTask setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
        return this;
    }
}