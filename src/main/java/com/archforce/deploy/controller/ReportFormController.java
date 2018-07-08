package com.archforce.deploy.controller;

import com.archforce.deploy.model.Host;
import com.archforce.deploy.service.HostService;
import com.archforce.deploy.utils.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by lanyage on 2018/7/2.
 */
@RestController
@RequestMapping("/export")
public class ReportFormController {
    @Autowired
    private HostService hostService;

    @GetMapping("/do")
    public void export(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取数据
        List<Host> list = hostService.getAll();

        //excel标题
        String[] title = {"主机id", "主机名", "主机ip", "SSH端口", "登录用户", "登录密码", "登录密码盐值", "创建时间", "创建用户", "更新时间", "更新用户"};

        //excel文件名
        String fileName = "学生信息表" + System.currentTimeMillis() + ".xls";

        //sheet名
        String sheetName = "学生信息表";

        String[][] content = new String[list.size()][];
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        for (int i = 0; i < list.size(); i++) {
            content[i] = new String[title.length];
            Host host = list.get(i);
            content[i][0] = host.getHostIp();
            content[i][1] = host.getHostName();
            content[i][2] = host.getHostIp();
            content[i][3] = host.getSshPort();
            content[i][4] = host.getLoginUser();
            content[i][5] = host.getLoginPwd();
            content[i][6] = host.getLoginPwdSalt();
            content[i][7] = host.getCreateTime() != null ? format.format(host.getCreateTime()) : "";
            content[i][8] = host.getCreateUser();
            content[i][9] = host.getUpdateTime() != null ? format.format(host.getUpdateTime()) : "";
            content[i][10] = host.getUpdateUser();
        }

        //创建HSSFWorkbook
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);

        //响应到客户端
        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //发送响应流方法
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(), "ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Param", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
