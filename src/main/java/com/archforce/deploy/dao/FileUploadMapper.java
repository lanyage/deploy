package com.archforce.deploy.dao;

import com.archforce.deploy.model.FileUpload;

public interface FileUploadMapper {
    int deleteByPrimaryKey(Integer fileUploadId);

    int insert(FileUpload record);

    int insertSelective(FileUpload record);

    FileUpload selectByPrimaryKey(Integer fileUploadId);

    int updateByPrimaryKeySelective(FileUpload record);

    int updateByPrimaryKey(FileUpload record);
}