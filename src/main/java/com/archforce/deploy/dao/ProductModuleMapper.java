package com.archforce.deploy.dao;

import com.archforce.deploy.model.ProductModule;

public interface ProductModuleMapper {
    int deleteByPrimaryKey(Integer productModuleId);

    int insert(ProductModule record);

    int insertSelective(ProductModule record);

    ProductModule selectByPrimaryKey(Integer productModuleId);

    int updateByPrimaryKeySelective(ProductModule record);

    int updateByPrimaryKey(ProductModule record);
}