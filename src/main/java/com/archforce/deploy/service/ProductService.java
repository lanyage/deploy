package com.archforce.deploy.service;

import com.archforce.deploy.dao.ProductMapper;
import com.archforce.deploy.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lanyage on 2018/6/28.
 */
@Service
public class ProductService {
    @Autowired
    private ProductMapper mapper;

    public List<Product> list() {
        List<Product> products = mapper.selectAll();
        return products;
    }
}
