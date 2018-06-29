package com.archforce.deploy.controller;

import com.archforce.deploy.model.Host;
import com.archforce.deploy.pojo.Result;
import com.archforce.deploy.service.HostService;
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
@RequestMapping("/host")
public class HostController {
    @Autowired
    private HostService service;

    @GetMapping("/list")
    public Result list() {
        List<Host> hosts = service.getAll();
        return ResultUtil.success(hosts);
    }
}
