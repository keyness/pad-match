package com.boot.demo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by zxy on 2018/6/12.
 */
public class PropertyUtil {

    public static class AuthorizePropertyUtil {
        private static Properties authorizeProperty = null;

        static {
            authorizeProperty = new Properties();
            InputStream in = PropertyUtil.class.getResourceAsStream("/config/pad.properties");
            try {
                authorizeProperty.load(in);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static String getProperty(String key) {
            return authorizeProperty.getProperty(key);
        }
    }

}
