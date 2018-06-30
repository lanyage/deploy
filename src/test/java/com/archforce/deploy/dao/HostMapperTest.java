package com.archforce.deploy.dao;

import com.archforce.deploy.model.Host;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by lanyage on 2018/6/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HostMapperTest {
    @Autowired
    private HostMapper dao;

    @Test
    public void deleteBatch() throws Exception {
        int count = dao.deleteBatch(new int[]{4,5,6});
        System.out.println(count);
    }
    @Test
    public void selectAllByHostIpLike() {
        List<Host> hosts = dao.selectAllByHostIpLike(0,5,"1");
        for (Host host : hosts) {
            System.out.println(host.getHostIp());
        }
    }
    @Test
    public void testSelectCountAll() {
        int count = dao.selectAllCount();
        System.out.println(count);
    }
}