package com.automation.config;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigManager {

    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream fis =
                    new FileInputStream("src/main/resources/config.properties");
            properties.load(fis);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
