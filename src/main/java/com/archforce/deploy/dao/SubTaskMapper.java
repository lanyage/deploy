package com.archforce.deploy.dao;

import com.archforce.deploy.model.SubTask;

public interface SubTaskMapper {
    int deleteByPrimaryKey(Integer subTaskId);

    int insert(SubTask record);

    int insertSelective(SubTask record);

    SubTask selectByPrimaryKey(Integer subTaskId);

    int updateByPrimaryKeySelective(SubTask record);

    int updateByPrimaryKey(SubTask record);
}