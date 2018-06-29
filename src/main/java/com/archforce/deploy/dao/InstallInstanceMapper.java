package com.archforce.deploy.dao;

import com.archforce.deploy.model.InstallInstance;

import java.util.List;

public interface InstallInstanceMapper {
    int deleteByPrimaryKey(Integer moduleInstId);

    int insert(InstallInstance record);

    int insertSelective(InstallInstance record);

    InstallInstance selectByPrimaryKey(Integer moduleInstId);

    int updateByPrimaryKeySelective(InstallInstance record);

    int updateByPrimaryKey(InstallInstance record);
    /*高级查询*/
    void saveBatch(List<InstallInstance> instances);

    List<InstallInstance> selectByProduct(int productId);
}