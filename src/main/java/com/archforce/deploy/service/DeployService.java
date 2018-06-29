package com.archforce.deploy.service;

import com.archforce.deploy.dao.*;
import com.archforce.deploy.enums.StatusType;
import com.archforce.deploy.enums.TaskType;
import com.archforce.deploy.model.*;
import com.archforce.deploy.pojo.UploadReply;
import com.archforce.deploy.utils.FileUtil;
import com.archforce.deploy.utils.PropertyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by lanyage on 2018/6/29.
 */
@Service
public class DeployService {

    @Autowired
    private ModuleMapper moduleDao;
    @Autowired
    private InstallInstanceMapper instanceDao;
    @Autowired
    private ProductMapper productDao;
    @Autowired
    private MainTaskMapper mainTaskDao;
    @Autowired
    private SubTaskMapper subTaskDao;
    @Autowired
    private HostMapper hostDao;
    private Logger logger = LoggerFactory.getLogger(DeployService.class);

    public List<UploadReply> uploadProduct(MultipartFile product) {
        try {
            //移动文件到根目录
            File dest = FileUtil.moveTo(product, PropertyUtil.get("base_path"));
            //解压文件
            List<UploadReply> replies = FileUtil.unzipProduct(dest);
            return replies;
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    public UploadReply uploadModule(MultipartFile module, int productId) {
        try {
            //移动文件到根目录下的产品下
            Product product = productDao.selectByPrimaryKey(productId);
            String productName = product.getProductName();
            String path = PropertyUtil.get("base_path") + productName + "/";
            File dest = FileUtil.moveTo(module, path);
            UploadReply reply = FileUtil.unzipModule(dest);
            return reply;
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    public void updateModules(List<UploadReply> replies) {
        for (UploadReply reply : replies) {
            updateModuleVersion(reply);
        }
    }

    public void updateModuleVersion(UploadReply reply) {
        String moduleName = reply.getModuleName();
        Module module = moduleDao.selectByName(moduleName);
        String currentVersion = module.getCurrentVersion();
        module.setLastVersion(currentVersion)
                .setCurrentVersion(reply.getTargetVersion())
                .setUpdateTime(new Date())
                .setUpdateUser("nobody");
        moduleDao.updateByPrimaryKeySelective(module);
    }

    public List<InstallInstance> saveInstances(List<InstallInstance> instances) {
        instanceDao.saveBatch(instances);
        for (InstallInstance instance : instances) {
            System.out.println(instance.getModuleInstId());
        }
        return instances;
    }

    @Transactional
    public void changeStatus(List<InstallInstance> instances, TaskType taskType) {
        for (InstallInstance instance : instances) {
            switch (taskType) {
                case INSTALLING:
                    instance.setState(StatusType.INSTALLING.getI()).setUpdateTime(new Date()).setUpdateUser("nobody");
                    break;
                case UPGRADING:
                    instance.setState(StatusType.UPGRADING.getI()).setUpdateTime(new Date()).setUpdateUser("nobody");
                    break;
                case EXPANDING:
                    instance.setState(StatusType.EXPANDING.getI()).setUpdateTime(new Date()).setUpdateUser("nobody");
                    break;
                case REGAINING:
                    instance.setState(StatusType.REGAINING.getI()).setUpdateTime(new Date()).setUpdateUser("nobody");
                    break;
                default:
                    break;
            }
            int i = instanceDao.updateByPrimaryKeySelective(instance);
            logger.info("update instance count = " + i);
        }
    }

    @Transactional
    public List<SubTask> openTask(int productId, String targetVersion, List<InstallInstance> instances, TaskType taskType) {
        MainTask mainTask = new MainTask();
        mainTask.setProductId(productId).setTargetVersion(targetVersion).setCreateTime(new Date()).setCreateUser("nobody");
        switch (taskType) {
            case INSTALLING:
                mainTask.setTaskType(TaskType.INSTALLING.getV()).setTaskDesc(TaskType.INSTALLING.getV()).setTaskState(StatusType.NOT_INSTALLED.getI());
                break;
            case UPGRADING:
                mainTask.setTaskType(TaskType.UPGRADING.getV()).setTaskDesc(TaskType.UPGRADING.getV()).setTaskState(StatusType.NOT_UPGRADED.getI());
                break;
            case EXPANDING:
                mainTask.setTaskType(TaskType.EXPANDING.getV()).setTaskDesc(TaskType.EXPANDING.getV()).setTaskState(StatusType.NOT_EXPANDED.getI());
                break;
            case REGAINING:
                mainTask.setTaskDesc(TaskType.REGAINING.getV()).setTaskDesc(TaskType.EXPANDING.getV()).setTaskState(StatusType.NOT_REGAINED.getI());
                break;
            default:
                break;
        }
        mainTaskDao.insertSelective(mainTask);
        logger.info("insert main task:" + mainTask.getTaskType());
        int mainTaskId = mainTask.getTaskId();
        int mainTaskState = mainTask.getTaskState();
        List<SubTask> subTasks = new ArrayList<>();
        for (InstallInstance instance : instances) {
            SubTask subTask = new SubTask();
            int instanceId = instance.getModuleInstId();
            String previousVersion = instance.getCurrentVersion();
            String subTargetVersion = mainTask.getTargetVersion();
            subTask.setTaskId(mainTaskId)
                    .setSubTaskOrder(-1)
                    .setModuleInstId(instanceId)
                    .setSubTaskState(mainTaskState)
                    .setCreateTime(new Date()).setCreateUser("nobody")
                    .setPreviousVersion(previousVersion)
                    .setTargetVersion(subTargetVersion);
            subTaskDao.insertSelective(subTask);
            logger.info("insert sub task:" + subTask.getSubTaskId());
            subTasks.add(subTask);
        }
        return subTasks;
    }

    public int installModule(InstallInstance instance) {
        File dest = new File(instance.getInitialPath());
        int hostId = instance.getHostId();
        Host host = hostDao.selectByPrimaryKey(hostId);
        String hostIp = host.getHostIp();
        int result = FileUtil.moveToRemoteHost(dest, hostIp);
        return result;
    }

    @Transactional
    public void installModuleHelp(SubTask subTask, InstallInstance instance, int result, TaskType taskType, Map<Integer, Integer> unfinished) {
        if (result == 0) {
            subTaskSuccess(subTask, instance, taskType);
        } else
            subTaskFails(subTask, instance, taskType);
        if (subTask.getSubTaskState() != StatusType.SUCCEED.getI())
            unfinished.put(subTask.getSubTaskId(), instance.getModuleInstId());
    }

    private void subTaskFails(SubTask subTask, InstallInstance instance, TaskType taskType) {
        subTask.setSubTaskState(StatusType.FAILED.getI()).setUpdateTime(new Date()).setUpdateUser("nobody");
        instance.setState(subTask.getSubTaskState());
        subTaskDao.updateByPrimaryKeySelective(subTask);
        instanceDao.updateByPrimaryKeySelective(instance);
    }

    private void subTaskSuccess(SubTask subTask, InstallInstance instance, TaskType taskType) {
        subTask.setSubTaskState(StatusType.SUCCEED.getI())
                .setPreviousVersion(instance.getCurrentVersion())
                .setUpdateTime(new Date())
                .setUpdateUser("nobody");
        instance.setPreviousVersion(subTask.getPreviousVersion())
                .setCurrentVersion(subTask.getTargetVersion())
                .setState(subTask.getSubTaskState());
        subTaskDao.updateByPrimaryKeySelective(subTask);
        instanceDao.updateByPrimaryKeySelective(instance);
    }

    @Transactional
    public void reInstall(int subTaskId, TaskType taskType, Map<Integer, Integer> unfinished) {
        SubTask subTask = subTaskDao.selectByPrimaryKey(subTaskId);
        int instanceId = subTask.getModuleInstId();
        InstallInstance instance = instanceDao.selectByPrimaryKey(instanceId);
        int result = installModule(instance);
        installModuleHelp(subTask, instance, result, taskType, unfinished);
    }

    @Transactional
    public List<InstallInstance> updateInstances(List<InstallInstance> instances) {
        for (int i = 0; i < instances.size(); i++) {
            InstallInstance instance = instances.get(i);
            instance.setUpdateTime(new Date()).setUpdateUser("nobody");
            instanceDao.updateByPrimaryKeySelective(instances.get(i));
            instance = instanceDao.selectByPrimaryKey(instance.getModuleInstId());
            instances.set(i, instance);
        }
        return instances;
    }

    public void mainTaskSuccess(int mainTaskId) {
        MainTask mainTask = new MainTask();
        mainTask.setTaskId(mainTaskId).setTaskState(StatusType.SUCCEED.getI()).setUpdateTime(new Date()).setUpdateUser("nobody");
        mainTaskDao.updateByPrimaryKeySelective(mainTask);
    }

    public InstallInstance updateInstance(InstallInstance instance) {
        instance.setUpdateTime(new Date()).setUpdateUser("nobody");
        instanceDao.updateByPrimaryKeySelective(instance);
        instance = instanceDao.selectByPrimaryKey(instance.getModuleInstId());
        return instance;
    }
}
