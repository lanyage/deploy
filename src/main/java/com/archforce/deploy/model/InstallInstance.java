package com.archforce.deploy.model;

import java.util.Date;

public class InstallInstance {
    private Integer moduleInstId;

    private Integer moduleId;

    private Integer hostId;

    private String moduleInstName;

    private String bindIp;

    private String bindPorts;

    private String previousVersion;

    private String currentVersion;

    private String initialPath;

    private Integer state;

    private Date createTime;

    private String createUser;

    private Date updateTime;

    private String updateUser;

    private String extension;

    public Integer getModuleInstId() {
        return moduleInstId;
    }

    public InstallInstance setModuleInstId(Integer moduleInstId) {
        this.moduleInstId = moduleInstId;return this;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public InstallInstance setModuleId(Integer moduleId) {
        this.moduleId = moduleId;return this;
    }

    public Integer getHostId() {
        return hostId;
    }

    public InstallInstance setHostId(Integer hostId) {
        this.hostId = hostId;return this;
    }

    public String getModuleInstName() {
        return moduleInstName;
    }

    public InstallInstance setModuleInstName(String moduleInstName) {
        this.moduleInstName = moduleInstName == null ? null : moduleInstName.trim();return this;
    }

    public String getBindIp() {
        return bindIp;
    }

    public InstallInstance setBindIp(String bindIp) {
        this.bindIp = bindIp == null ? null : bindIp.trim();return this;
    }

    public String getBindPorts() {
        return bindPorts;
    }

    public InstallInstance setBindPorts(String bindPorts) {
        this.bindPorts = bindPorts == null ? null : bindPorts.trim();return this;
    }

    public String getPreviousVersion() {
        return previousVersion;
    }

    public InstallInstance setPreviousVersion(String previousVersion) {
        this.previousVersion = previousVersion == null ? null : previousVersion.trim();return this;
    }

    public String getCurrentVersion() {
        return currentVersion;
    }

    public InstallInstance setCurrentVersion(String currentVersion) {
        this.currentVersion = currentVersion == null ? null : currentVersion.trim();
        return this;
    }

    public String getInitialPath() {
        return initialPath;
    }

    public InstallInstance setInitialPath(String initialPath) {
        this.initialPath = initialPath == null ? null : initialPath.trim();
        return this;
    }

    public Integer getState() {
        return state;
    }

    public InstallInstance setState(Integer state) {
        this.state = state;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public InstallInstance setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public InstallInstance setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public InstallInstance setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public InstallInstance setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
        return this;
    }

    public String getExtension() {
        return extension;
    }

    public InstallInstance setExtension(String extension) {
        this.extension = extension == null ? null : extension.trim();
        return this;
    }
}