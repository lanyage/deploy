package com.archforce.deploy.controller;

import com.archforce.deploy.enums.StatusType;
import com.archforce.deploy.enums.TaskType;
import com.archforce.deploy.model.InstallInstance;
import com.archforce.deploy.model.SubTask;
import com.archforce.deploy.pojo.Result;
import com.archforce.deploy.pojo.UploadReply;
import com.archforce.deploy.service.DeployService;
import com.archforce.deploy.service.InstallInstanceService;
import com.archforce.deploy.service.ModuleService;
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
    private ModuleService moduleService;
    @Autowired
    private InstallInstanceService instanceService;

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
        deployService.updateModule(reply);
        return null;
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
        Map<Integer,Integer> unfinished = new HashMap<>();
        unfinished.put(1,1);
        for (int i = 0; i < instances.size(); i++) {
            SubTask subTask = subTasks.get(i);
            InstallInstance instance = instances.get(i);
            int result = deployService.installModule(subTask, instance);
            deployService.installModuleHelp(subTask, instance, result, TaskType.INSTALLING);
            if(subTask.getSubTaskState() != StatusType.SUCCEED.getI())
                unfinished.put(subTask.getSubTaskId(), instance.getModuleInstId());
        }
        return ResultUtil.success(unfinished);
    }

    public Result reInstall() {
        return null;
    }

    @GetMapping("/instance/getAllByProduct/{productId}")
    public Result getAllInstallInstanceOfProduct(@PathVariable("productId") int productId) {
        List<InstallInstance> instances = instanceService.getByProduct(productId);
        return ResultUtil.success(instances);
    }
}
