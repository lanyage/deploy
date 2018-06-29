package com.archforce.deploy.controller;

import com.archforce.deploy.model.Module;
import com.archforce.deploy.pojo.Result;
import com.archforce.deploy.service.ModuleService;
import com.archforce.deploy.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lanyage on 2018/6/28.
 */
@RestController
@RequestMapping("/module")
public class ModuleController {

    @Autowired
    private ModuleService service;
    @GetMapping("/listByProduct/{productId}")
    public Result listByProduct(@PathVariable("productId") int productId) {
        List<Module> modules = service.getAllByProduct(productId);
        return ResultUtil.success(modules);
    }
}
