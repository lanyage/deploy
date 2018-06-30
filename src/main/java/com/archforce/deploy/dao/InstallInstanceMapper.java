package com.archforce.deploy.dao;

import com.archforce.deploy.model.InstallInstance;
import com.archforce.deploy.pojo.InstanceVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

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

    List<InstanceVo> selectByProductInPage(@Param("startIndex") int startIndex,
                                           @Param("pageSize") int pageSize,
                                           @Param("productId") int productId);

    List<InstanceVo> selectAllInPage(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize);
}