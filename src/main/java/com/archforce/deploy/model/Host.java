package com.archforce.deploy.model;

import java.util.Date;

public class Host {
    private Integer hostId;

    private String hostName;

    private String hostIp;

    private String sshPort;

    private String loginUser;

    private String loginPwd;

    private String loginPwdSalt;

    private Date createTime;

    private String createUser;

    private Date updateTime;

    private String updateUser;

    public Integer getHostId() {
        return hostId;
    }

    public Host setHostId(Integer hostId) {
        this.hostId = hostId;return this;
    }

    public String getHostName() {
        return hostName;
    }

    public Host setHostName(String hostName) {
        this.hostName = hostName == null ? null : hostName.trim();return this;
    }

    public String getHostIp() {
        return hostIp;
    }

    public Host setHostIp(String hostIp) {
        this.hostIp = hostIp == null ? null : hostIp.trim();return this;
    }

    public String getSshPort() {
        return sshPort;
    }

    public Host setSshPort(String sshPort) {
        this.sshPort = sshPort == null ? null : sshPort.trim();return this;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public Host setLoginUser(String loginUser) {
        this.loginUser = loginUser == null ? null : loginUser.trim();return this;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public Host setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd == null ? null : loginPwd.trim();return this;
    }

    public String getLoginPwdSalt() {
        return loginPwdSalt;
    }

    public Host setLoginPwdSalt(String loginPwdSalt) {
        this.loginPwdSalt = loginPwdSalt == null ? null : loginPwdSalt.trim();return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Host setCreateTime(Date createTime) {
        this.createTime = createTime;return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public Host setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public Host setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;return this;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public Host setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
        return this;
    }
}