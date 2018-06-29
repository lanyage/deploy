package com.archforce.deploy.dao;

import com.archforce.deploy.model.Product;
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
public class ProductMapperTest {
    @Autowired
    private ProductMapper dao;

    @Test
    public void selectAll() throws Exception {
//        List<Product> products = dao.selectAll();
//        for (Product product : products) {
//            System.out.println(product.getProductName());
//        }
//        System.out.println(products.size());
    }
}