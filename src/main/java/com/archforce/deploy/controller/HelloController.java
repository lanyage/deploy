package com.archforce.deploy.controller;

import com.archforce.deploy.page.PageBean;
import com.archforce.deploy.utils.FileUtil;
import com.archforce.deploy.utils.PropertyUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lanyage on 2018/6/28.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping("/world")
    public PageBean<Integer> hello() {

        PageBean<Integer> pb = new PageBean();
        pb.setTotal(200);
        pb.setPageNumber(2);
        pb.setPageSize(5);
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        pb.setBeanList(nums);

//        Demo demo = new Demo();
//        demo.setName("demo");
        return pb;
    }

    @PostMapping("/transfer")
    public String upload(@RequestParam("file") MultipartFile product) {
        try {
            File dest = FileUtil.moveTo(product, PropertyUtil.get("base_path"));
            System.out.println(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }
}
