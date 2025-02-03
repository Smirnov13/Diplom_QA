package ru.iteco.fmhandroid.ui.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {

    private static final Properties properties;

    static {
        properties = new Properties();
        try (FileInputStream input = new FileInputStream(".env")) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static final String getPassword() {return properties.getProperty("PASSWORD");}
    public static final String getLogin() {return properties.getProperty("LOGIN");}

}
