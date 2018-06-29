package com.archforce.deploy.model;

import java.util.Date;

public class Module {
    private Integer moduleId;

    private String moduleName;

    private String moduleChsName;

    private String moduleType;

    private String lastVersion;

    private String currentVersion;

    private String haType;

    private String virtualIp;

    private String virtualService;

    private Date createTime;

    private String createUser;

    private Date updateTime;

    private String updateUser;

    private Integer defaultInstPort;

    public Integer getModuleId() {
        return moduleId;
    }

    public Module setModuleId(Integer moduleId) {
        this.moduleId = moduleId; return this;
    }

    public String getModuleName() {
        return moduleName;
    }

    public Module setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim(); return this;
    }

    public String getModuleChsName() {
        return moduleChsName;
    }

    public Module setModuleChsName(String moduleChsName) {
        this.moduleChsName = moduleChsName == null ? null : moduleChsName.trim(); return this;
    }

    public String getModuleType() {
        return moduleType;
    }

    public Module setModuleType(String moduleType) {
        this.moduleType = moduleType == null ? null : moduleType.trim(); return this;
    }

    public String getLastVersion() {
        return lastVersion;
    }

    public Module setLastVersion(String lastVersion) {
        this.lastVersion = lastVersion == null ? null : lastVersion.trim(); return this;
    }

    public String getCurrentVersion() {
        return currentVersion;
    }

    public Module setCurrentVersion(String currentVersion) {
        this.currentVersion = currentVersion == null ? null : currentVersion.trim(); return this;
    }

    public String getHaType() {
        return haType;
    }

    public Module setHaType(String haType) {
        this.haType = haType == null ? null : haType.trim(); return this;
    }

    public String getVirtualIp() {
        return virtualIp;
    }

    public Module setVirtualIp(String virtualIp) {
        this.virtualIp = virtualIp == null ? null : virtualIp.trim();
        return this;
    }

    public String getVirtualService() {
        return virtualService;
    }

    public Module setVirtualService(String virtualService) {
        this.virtualService = virtualService == null ? null : virtualService.trim(); return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Module setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public Module setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public Module setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public Module setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
        return this;
    }

    public Integer getDefaultInstPort() {
        return defaultInstPort;
    }

    public Module setDefaultInstPort(Integer defaultInstPort) {
        this.defaultInstPort = defaultInstPort;
        return this;
    }
}