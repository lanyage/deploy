package com.archforce.deploy.controller;

import com.archforce.deploy.model.Product;
import com.archforce.deploy.pojo.Result;
import com.archforce.deploy.service.ProductService;
import com.archforce.deploy.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by lanyage on 2018/6/28.
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService service;
    @GetMapping("/list")
    public Result list() {
        List<Product> products = service.list();
        return ResultUtil.success(products);
    }
}
