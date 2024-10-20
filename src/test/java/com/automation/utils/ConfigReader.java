package com.automation.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    static Properties properties;
    public static  void initConfig(){
        properties = new Properties();
        try{
            properties.load(new FileInputStream("src/test/resources/config/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static String getConfigValue(String key){
        return properties.getProperty(key);
    }
    public static void setConfigValue(String key, String value) {
        try {
            // Set the new property value
            properties.setProperty(key, value);

            // Save the properties to the file
            properties.store(new FileOutputStream("src/test/resources/config/config.properties"), null);
        } catch (IOException e) {
            throw new RuntimeException("Unable to save config to file", e);
        }
    }
}
