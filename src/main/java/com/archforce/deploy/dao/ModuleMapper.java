package com.archforce.deploy.dao;

import com.archforce.deploy.model.Module;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ModuleMapper {
    int deleteByPrimaryKey(Integer moduleId);

    int insert(Module record);

    int insertSelective(Module record);

    Module selectByPrimaryKey(Integer moduleId);

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);

    /*高级查询*/
    List<Module> selectByProduct(int productId);

    Module selectByName(@Param("moduleName") String moduleName);
}