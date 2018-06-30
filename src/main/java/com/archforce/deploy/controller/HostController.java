package com.archforce.deploy.controller;

import com.archforce.deploy.model.Host;
import com.archforce.deploy.page.PageBean;
import com.archforce.deploy.pojo.Result;
import com.archforce.deploy.service.HostService;
import com.archforce.deploy.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/listInPage")
    public Result listInPage(int pageIndex, int pageSize) {
        PageBean<Host> pb = service.getAllInPage(pageIndex, pageSize);
        return ResultUtil.success(pb);
    }

    @PostMapping("/save")
    public Result save(Host host) {
        return ResultUtil.success(service.save(host));
    }

    @DeleteMapping("/deleteBatch")
    public Result deleteBatch(@RequestBody int[] ids) {
        int count = service.deleteBatch(ids);
        return ResultUtil.success(count);
    }

    @GetMapping("/listByHostIpLike")
    public Result listByHostIpLike(@RequestParam(value = "pageIndex", required = false, defaultValue = "1") int pageIndex,
                                   @RequestParam(value = "pageSize", required = false, defaultValue = "10")int pageSize,
                                   @RequestParam("ip") String ip) {
        PageBean<Host> pb = service.getAllByHostIpLike(pageIndex, pageSize, ip);
        return ResultUtil.success(pb);
    }

    @PutMapping("/modify")
    public Result modify(Host host) {
        int count = service.update(host);
        return ResultUtil.success(count);
    }
}
