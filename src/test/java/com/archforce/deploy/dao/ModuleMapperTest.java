package com.archforce.deploy.dao;

import com.archforce.deploy.model.Module;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by lanyage on 2018/6/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ModuleMapperTest {
    @Autowired
    private ModuleMapper dao;
    @Test
    public void selectByProduct() throws Exception {
//        List<Module> modules = dao.selectByProduct(1);
//        System.out.println(modules.size());
    }

}