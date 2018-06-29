package com.archforce.deploy.dao;

import com.archforce.deploy.model.MainTask;

public interface MainTaskMapper {
    int deleteByPrimaryKey(Integer taskId);

    int insert(MainTask record);

    int insertSelective(MainTask record);

    MainTask selectByPrimaryKey(Integer taskId);

    int updateByPrimaryKeySelective(MainTask record);

    int updateByPrimaryKey(MainTask record);
}