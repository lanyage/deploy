package com.archforce.deploy.controller;

import com.archforce.deploy.enums.TaskType;
import com.archforce.deploy.model.InstallInstance;
import com.archforce.deploy.model.SubTask;
import com.archforce.deploy.pojo.Result;
import com.archforce.deploy.pojo.UploadReply;
import com.archforce.deploy.service.DeployService;
import com.archforce.deploy.service.InstallInstanceService;
import com.archforce.deploy.service.MainTaskService;
import com.archforce.deploy.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lanyage on 2018/6/28.
 */
@RestController
@RequestMapping("/deploy")
public class DeployController {
    @Autowired
    private DeployService deployService;
    @Autowired
    private MainTaskService mainTaskService;
    @Autowired
    private InstallInstanceService instanceService;

    /*------------------------------安装模块-------------------------------*/
    @PostMapping("/uploadProduct")
    public Result uploadProduct(@RequestParam("product") MultipartFile product) {
        //上传文件
        List<UploadReply> replies = deployService.uploadProduct(product);
        //更新模块版本
        deployService.updateModules(replies);
        return ResultUtil.success(replies);
    }

    @PostMapping("/uploadModule")
    public Result uploadModule(@RequestParam("module") MultipartFile module, @RequestParam("productId") int productId) {
        //上传文件
        UploadReply reply = deployService.uploadModule(module, productId);
        //更新模块版本
        deployService.updateModuleVersion(reply);
        return ResultUtil.success();
    }

    @PostMapping("/saveInstances")
    public Result createInstances(@RequestBody List<InstallInstance> instances) {
        instances = deployService.saveInstances(instances);
        return ResultUtil.success(instances);
    }

    @PostMapping("/startInstall/{productId}/{targetVersion}")
    public Result startInstall(@PathVariable("productId") int productId,
                               @PathVariable("targetVersion") String targetVersion,
                               @RequestBody List<InstallInstance> instances) {
        //更新组件状态为正在进行时
        deployService.changeStatus(instances, TaskType.INSTALLING);
        //开启任务
        List<SubTask> subTasks = deployService.openTask(productId, targetVersion, instances, TaskType.INSTALLING);
        //开始安装组件
        Map<Integer, Integer> unfinished = new HashMap<>();
        unfinished.put(1, 1);
        for (int i = 0; i < instances.size(); i++) {
            SubTask subTask = subTasks.get(i);
            InstallInstance instance = instances.get(i);
            int result = deployService.installModule(instance);
            deployService.installModuleHelp(subTask, instance, result, TaskType.INSTALLING, unfinished);
        }
        return ResultUtil.success(unfinished);
    }

    @PutMapping("/reInstall/{subTaskId}")
    public Result reInstall(@PathVariable("subTaskId") int subTaskId) {
        Map<Integer, Integer> unfinished = new HashMap<>();
        unfinished.put(1, 1);
        deployService.reInstall(subTaskId, TaskType.INSTALLING, unfinished);
        return ResultUtil.success(unfinished);
    }

    @GetMapping("/listInstancesByProduct/{productId}")
    public Result getAllInstallInstanceOfProduct(@PathVariable("productId") int productId) {
        List<InstallInstance> instances = instanceService.getByProduct(productId);
        return ResultUtil.success(instances);
    }

    /*------------------------------升级模块-------------------------------*/
    @PutMapping("/updateInstances")
    public Result updateInstances(@RequestBody List<InstallInstance> instances) {
        instances = deployService.updateInstances(instances);
        return ResultUtil.success(instances);
    }

    @PostMapping("/startUpgrade/{productId}/{targetVersion}")
    public Result startUpgrade(@PathVariable("productId") int productId,
                               @PathVariable("targetVersion") String targetVersion,
                               @RequestBody List<InstallInstance> instances) {
        //更新组件状态为正在进行时
        deployService.changeStatus(instances, TaskType.UPGRADING);
        //开启任务
        List<SubTask> subTasks = deployService.openTask(productId, targetVersion, instances, TaskType.UPGRADING);
        //开始安装组件
        Map<Integer, Integer> unfinished = new HashMap<>();
        unfinished.put(1, 1);
        for (int i = 0; i < instances.size(); i++) {
            SubTask subTask = subTasks.get(i);
            InstallInstance instance = instances.get(i);
            int result = deployService.installModule(instance);
            deployService.installModuleHelp(subTask, instance, result, TaskType.UPGRADING, unfinished);
        }
        return ResultUtil.success(unfinished);
    }

    @PutMapping("/reUpgrade/{subTaskId}")
    public Result reUpgrade(@PathVariable("subTaskId") int subTaskId) {
        Map<Integer, Integer> unfinished = new HashMap<>();
        unfinished.put(1, 1);
        deployService.reInstall(subTaskId, TaskType.INSTALLING, unfinished);
        return ResultUtil.success(unfinished);
    }

    @PutMapping("/mainTaskSuccess/{mainTaskId}")
    public Result mainTaskSuccess(@PathVariable("mainTaskId") int mainTaskId) {
        deployService.mainTaskSuccess(mainTaskId);
        return ResultUtil.success();
    }

    /*------------------------------模块扩容模块-------------------------------*/
    @PutMapping("/updateInstance")
    public Result updateModule(@RequestBody InstallInstance instance) {
        instance = deployService.updateInstance(instance);
        return ResultUtil.success(instance);
    }

    @DeleteMapping("/deleteInstancesBatch")
    public Result deleteInstancesBatch(@RequestBody int[] instanceIds) {
        deployService.deleteInstancesBatch(instanceIds);
        return ResultUtil.success(instanceIds);
    }

    @PostMapping("/saveOrUpdateInstances")
    public Result saveOrUpdateInstances(@RequestBody List<InstallInstance> instances) {
        instances = deployService.saveOrUpdateInstances(instances);
        return ResultUtil.success(instances);
    }

    @PostMapping("/startExpand/{productId}")
    public Result startExpand(@PathVariable("productId") int productId,
                              @RequestBody List<InstallInstance> instances) {
        //更新组件状态为正在进行时
        deployService.changeStatus(instances, TaskType.EXPANDING);
        //开启任务
        List<SubTask> subTasks = deployService.openTask(productId, null, instances, TaskType.EXPANDING);
        //开始安装组件
        Map<Integer, Integer> unfinished = new HashMap<>();
        unfinished.put(1, 1);
        for (int i = 0; i < instances.size(); i++) {
            SubTask subTask = subTasks.get(i);
            InstallInstance instance = instances.get(i);
            int result = deployService.installModule(instance);
            deployService.installModuleHelp(subTask, instance, result, TaskType.EXPANDING, unfinished);
        }
        return ResultUtil.success(unfinished);
    }

    @PutMapping("/reExpand/{subTaskId}")
    public Result reExpand(@PathVariable("subTaskId") int subTaskId) {
        Map<Integer, Integer> unfinished = new HashMap<>();
        unfinished.put(1, 1);
        deployService.reInstall(subTaskId, TaskType.EXPANDING, unfinished);
        return ResultUtil.success(unfinished);
    }

    /*------------------------------产品回退-------------------------------*/
    @PostMapping("/startRegain/{productId}/{targetVersion}")
    public Result startRegain(@PathVariable("productId") int productId,
                              @PathVariable("targetVersion") String targetVersion,
                              @RequestBody List<InstallInstance> instances) {
        //更新组件状态为正在进行时
        deployService.changeStatus(instances, TaskType.REGAINING);
        //开启任务
        List<SubTask> subTasks = deployService.openTask(productId, targetVersion, instances, TaskType.REGAINING);
        //开始安装组件
        Map<Integer, Integer> unfinished = new HashMap<>();
        unfinished.put(1, 1);
        for (int i = 0; i < instances.size(); i++) {
            SubTask subTask = subTasks.get(i);
            InstallInstance instance = instances.get(i);
            int result = deployService.installModule(instance);
            deployService.installModuleHelp(subTask, instance, result, TaskType.REGAINING, unfinished);
        }
        return ResultUtil.success(unfinished);
    }

    @PutMapping("/reRegain/{subTaskId}")
    public Result reRegain(@PathVariable("subTaskId") int subTaskId) {
        Map<Integer, Integer> unfinished = new HashMap<>();
        unfinished.put(1, 1);
        deployService.reInstall(subTaskId, TaskType.REGAINING, unfinished);
        return ResultUtil.success(unfinished);
    }
}
