package com.archforce.deploy.service;

import com.archforce.deploy.dao.InstallInstanceMapper;
import com.archforce.deploy.model.InstallInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lanyage on 2018/6/28.
 */
@Service
public class InstallInstanceService {
    @Autowired
    private InstallInstanceMapper dao;

    public List<InstallInstance> getByProduct(int productId){
        return dao.selectByProduct(productId);
    }
}
