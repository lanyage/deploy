package com.archforce.deploy.pojo;

import java.util.Date;

/**
 * Created by lanyage on 2018/6/29.
 */
public class InstanceVo {
    private String productName;
    private String moduleName;
    private String currentVersion;
    private Date createTime;
    private String installFile;
    private String installPath;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getCurrentVersion() {
        return currentVersion;
    }

    public void setCurrentVersion(String currentVersion) {
        this.currentVersion = currentVersion;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getInstallFile() {
        return installFile;
    }

    public void setInstallFile(String installFile) {
        this.installFile = installFile;
    }

    public String getInstallPath() {
        return installPath;
    }

    public void setInstallPath(String installPath) {

        this.installPath = installPath;
    }

    @Override
    public String toString() {
        return "InstanceVo{" +
                "productName='" + productName + '\'' +
                ", moduleName='" + moduleName + '\'' +
                ", currentVersion='" + currentVersion + '\'' +
                ", createTime=" + createTime +
                ", installFile='" + installFile + '\'' +
                ", installPath='" + installPath + '\'' +
                '}';
    }
}
