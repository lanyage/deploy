package com.archforce.deploy.service;

import com.archforce.deploy.dao.HostMapper;
import com.archforce.deploy.model.Host;
import com.archforce.deploy.page.PageBean;
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

    public PageBean<Host> getAllInPage(int pageIndex, int pageSize) {

        int total = dao.selectAllCount();
        PageBean<Host> pb = new PageBean<>();
        pb.setPageNumber(pageIndex);
        pb.setPageSize(pageSize);
        pb.setTotal(total);
        int startIndex = pb.getStartIndex();
        List<Host> hosts = dao.selectAllInPage(startIndex, pageSize);
        pb.setBeanList(hosts);
        return pb;
    }

    public int deleteBatch(int[] ids) {
        int count = dao.deleteBatch(ids);
        return count;
    }

    public int update(Host host) {
        int count = dao.updateByPrimaryKeySelective(host);
        return count;
    }

    public Host save(Host host) {
        dao.insertSelective(host);
        return host;
    }

    public PageBean<Host> getAllByHostIpLike(int pageIndex, int pageSize, String ip) {
        int total = dao.selectAllCountByIpLike(ip);
        PageBean<Host> pb = new PageBean<>();
        pb.setPageNumber(pageIndex);
        pb.setPageSize(pageSize);
        pb.setTotal(total);
        int startIndex = pb.getStartIndex();
        List<Host> list = dao.selectAllByHostIpLike(startIndex, pageSize, ip);
        pb.setBeanList(list);
        return pb;
    }
}
