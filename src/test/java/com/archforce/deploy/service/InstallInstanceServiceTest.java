package com.archforce.deploy.service;

import com.archforce.deploy.dao.InstallInstanceMapper;
import com.archforce.deploy.page.PageBean;
import com.archforce.deploy.pojo.InstanceVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by lanyage on 2018/6/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class InstallInstanceServiceTest {
    @Test
    public void getAllInPage() throws Exception {
        PageBean<InstanceVo> pb =  service.getAllInPage(3, 2);
        List<InstanceVo> ls = pb.getBeanList();
        for (InstanceVo l : ls) {
            System.out.println(l);
        }
    }

    @Autowired
    private InstallInstanceService service;

    @Test
    public void getByProductInPage() throws Exception {
        PageBean<InstanceVo> pb =  service.getByProductInPage(3, 2, 1);
        List<InstanceVo> ls = pb.getBeanList();
        for (InstanceVo l : ls) {
            System.out.println(l);
        }
     }
}