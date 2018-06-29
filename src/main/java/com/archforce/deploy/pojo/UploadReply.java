package com.archforce.deploy.pojo;

/**
 * Created by lanyage on 2018/6/29.
 */
public class UploadReply {
    private String mainVersion;
    private String moduleName;
    private String targetVersion;
    private String fileName;
    private String installPath;

    public String getMainVersion() {
        return mainVersion;
    }

    public UploadReply setMainVersion(String mainVersion) {
        this.mainVersion = mainVersion;
        return this;
    }

    public String getModuleName() {
        return moduleName;
    }

    public UploadReply setModuleName(String moduleName) {
        this.moduleName = moduleName;
        return this;
    }

    public String getTargetVersion() {
        return targetVersion;
    }

    public UploadReply setTargetVersion(String targetVersion) {
        this.targetVersion = targetVersion;
        return this;
    }

    public String getFileName() {
        return fileName;
    }

    public UploadReply setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public String getInstallPath() {
        return installPath;
    }

    public UploadReply setInstallPath(String installPath) {
        this.installPath = installPath;
        return this;
    }
}
