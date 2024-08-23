package com.example.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHandler {

    private static final Properties webProperties;

    private static final Properties apiProperties;

    static {
        webProperties = getWebProperties();
        apiProperties = getApiProperties();
    }

    private static Properties getWebProperties() {
        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream("src/test/resources/web.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }

    private static Properties getApiProperties() {
        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream("src/test/resources/api.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }

    public static String getWebProperty(String key) {
        return webProperties.getProperty(key);
    }

    public static String getApiProperty(String key) {
        return apiProperties.getProperty(key);
    }
}
