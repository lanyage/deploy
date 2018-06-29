package com.archforce.deploy.service;

import com.archforce.deploy.dao.ModuleMapper;
import com.archforce.deploy.model.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lanyage on 2018/6/28.
 */
@Service
public class ModuleService {
    @Autowired
    private ModuleMapper dao;
    public List<Module> getAllByProduct(int productId) {
       List<Module> modules =  dao.selectByProduct(productId);
       return modules;
    }
}
