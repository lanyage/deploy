package com.archforce.deploy.service;

import com.archforce.deploy.dao.HostMapper;
import com.archforce.deploy.model.Host;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lanyage on 2018/6/28.
 */
@Service
public class HostService {
    @Autowired
    private HostMapper dao;
    public List<Host> getAll() {
        List<Host> hosts = dao.selectAll();
        return hosts;
    }
}
