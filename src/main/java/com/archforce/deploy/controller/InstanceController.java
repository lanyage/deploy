package com.archforce.deploy.controller;

import com.archforce.deploy.page.PageBean;
import com.archforce.deploy.pojo.InstanceVo;
import com.archforce.deploy.pojo.Result;
import com.archforce.deploy.service.InstallInstanceService;
import com.archforce.deploy.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lanyage on 2018/6/29.
 */
@RestController
@RequestMapping("/instance")
public class InstanceController {
    @Autowired
    private InstallInstanceService service;
    @GetMapping("/listByProductInPage")
    public Result listByProductInPage(int pageIndex, int pageSize, int productId) {
        PageBean<InstanceVo> pb = service.getByProductInPage(pageIndex, pageSize,productId);
        return ResultUtil.success(pb);
    }
    @GetMapping("/listInPage")
    public Result listInPage(int pageIndex, int pageSize) {
        PageBean<InstanceVo> pb = service.getAllInPage(pageIndex, pageSize);
        return ResultUtil.success(pb);
    }
}
