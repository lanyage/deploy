package com.archforce.deploy.service;

import com.archforce.deploy.dao.InstallInstanceMapper;
import com.archforce.deploy.model.InstallInstance;
import com.archforce.deploy.page.PageBean;
import com.archforce.deploy.pojo.InstanceVo;
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

    public PageBean<InstanceVo> getByProductInPage(int pageIndex, int pageSize, int productId) {
        PageBean<InstanceVo> pb = new PageBean<>();
        pb.setPageNumber(pageIndex);
        pb.setPageSize(pageSize);
        int startIndex = pb.getStartIndex();
        List<InstanceVo> instanceVos = dao.selectByProductInPage(startIndex, pageSize, productId);
        pb.setBeanList(instanceVos);
        return pb;
    }

    public PageBean<InstanceVo> getAllInPage(int pageIndex, int pageSize) {
        PageBean<InstanceVo> pb = new PageBean<>();
        pb.setPageNumber(pageIndex);
        pb.setPageSize(pageSize);
        int startIndex = pb.getStartIndex();
        List<InstanceVo> instanceVos = dao.selectAllInPage(startIndex, pageSize);
        pb.setBeanList(instanceVos);
        return pb;
    }
}
