package com.archforce.deploy.dao;

import com.archforce.deploy.model.Host;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HostMapper {
    int deleteByPrimaryKey(Integer hostId);

    int insert(Host record);

    int insertSelective(Host record);

    Host selectByPrimaryKey(Integer hostId);

    int updateByPrimaryKeySelective(Host record);

    int updateByPrimaryKey(Host record);

    /*高级查询*/
    List<Host> selectAll();

    List<Host> selectAllInPage(@Param("pageIndex") int pageIndex, int pageSize);

    int deleteBatch(int[] ids);

    List<Host> selectAllByHostIpLike(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize, @Param("ip") String ip);

    int selectAllCount();

    int selectAllCountByIpLike(@Param("ip") String ip);

}