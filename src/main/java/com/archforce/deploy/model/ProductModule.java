package com.archforce.deploy.model;

import java.util.Date;

public class ProductModule {
    private Integer productModuleId;

    private Integer productId;

    private Integer moduleId;

    private Date createTime;

    private String createUser;

    private Date updateTime;

    private String updateUser;

    public Integer getProductModuleId() {
        return productModuleId;
    }

    public void setProductModuleId(Integer productModuleId) {
        this.productModuleId = productModuleId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }
}