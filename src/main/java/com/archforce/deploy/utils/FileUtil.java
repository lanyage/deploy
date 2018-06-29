package com.archforce.deploy.utils;

import com.archforce.deploy.pojo.UploadReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    private static Logger logger = LoggerFactory.getLogger(FileUtil.class);

    public static File moveTo(MultipartFile file, String dest) throws IOException {
        InputStream in = null;
        OutputStream out = null;
        String fileName = file.getOriginalFilename();
        byte[] bytes = file.getBytes();
        try {
            File targetFile = new File(dest);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            out = new FileOutputStream(dest + fileName);
            out.write(bytes);
            out.flush();
        } catch (IOException e) {
            throw e;
        } finally {
            if (in != null)
                in.close();
            if (out != null)
                out.close();
        }
        File destFile = new File(dest + fileName);
        return destFile;
    }

    public static File moveTo(File file, String dest) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;
        FileChannel infc = null, oufc = null;
        try {
            in = new FileInputStream(file);
            infc = in.getChannel();
            out = new FileOutputStream(dest + file.getName());
            oufc = out.getChannel();
            infc.transferTo(0, infc.size(), oufc);
        } catch (IOException e) {
            throw e;
        } finally {
            if (infc != null)
                infc.close();
            if (in != null)
                in.close();
            if (oufc != null)
                oufc.close();
            if (out != null)
                out.close();
        }
        return new File(dest + file.getName());
    }

    public static void main(String[] args) throws IOException {
        File from = new File("/Users/lanyage/IdeaProjects/deploy/src/main/resources/test.txt");
        String dest = "/Users/lanyage/software/";
        File file = moveTo(from, dest);
        System.out.println(file.getAbsolutePath());
        System.out.println(from.getName());
    }

    public static List<UploadReply> unzipProduct(File dest) {
        logger.info("解压:" + dest.getName());

        List<String> paths = new ArrayList<>();
        List<UploadReply> replies = new ArrayList<>();
        String mainVersion = "1.0.0";
        String web = "/Users/lanyage/software/ami/web/1.0.0/web-1.0.0.jar";
        String service = "/Users/lanyage/software/ami/service/1.0.0/service-1.0.0.jar";
//        String mainVersion = "2.0.0";
//        String web = "/Users/lanyage/software/ami/web/2.0.0/web-2.0.0.jar";
//        String service = "/Users/lanyage/software/ami/service/2.0.0/service-2.0.0.jar";
        paths.add(web);
        paths.add(service);

        for (String path : paths) {
            UploadReply reply = resolvePath(path);
            reply.setMainVersion(mainVersion);
            replies.add(reply);
        }
        return replies;
    }

    public static UploadReply unzipModule(File dest) {
        logger.info("解压:" + dest.getName());
//        String mainVersion = "1.0.0";
//        String web = "/Users/lanyage/software/ami/web/1.0.0/web-1.0.0.jar";
        String mainVersion = "2.0.0";
        String web = "/Users/lanyage/software/ami/web/2.0.0/web-2.0.0.jar";
        UploadReply reply = resolvePath(web);
        return reply;
    }

    public static UploadReply resolvePath(String path) {
        String[] seg = path.split("/");
        int len = seg.length;
        UploadReply reply = new UploadReply();
        reply.setFileName(seg[len - 1]).setTargetVersion(seg[len - 2]).setModuleName(seg[len - 3]).setInstallPath(path);
        return reply;
    }

    public static int moveToRemoteHost(File dest, String hostIp) {
        StringBuilder sb = new StringBuilder("move ");
        String absp = dest.getAbsolutePath();
        sb.append(absp).append(" to ").append(hostIp);
        System.out.println(sb.toString());
        return 0;
    }
}
