package com.archforce.deploy.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {
    private static Logger logger = LoggerFactory.getLogger(PropertyUtil.class);
    private static Properties props;

    static {
        try {
            InputStream in = new FileInputStream("src/main/resources/common.properties");
            props = new Properties();
            props.load(in);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }

    public static void main(String[] args) {
        System.out.println(PropertyUtil.get("base_path"));
    }
}
