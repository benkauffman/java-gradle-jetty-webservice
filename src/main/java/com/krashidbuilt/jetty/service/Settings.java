package com.krashidbuilt.jetty.service;

import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicPropertyFactory;

import java.io.IOException;

//import org.apache.log4j.Logger;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


/**
 * Created by Ben Kauffman on 2/21/2016.
 */
public class Settings {
//    private static Logger LOGGER = Logger.getLogger(Settings.class.getName());
    private static Logger LOGGER = LogManager.getLogger();

    private static DynamicPropertyFactory dynamicPropertyFactory;

    static {
        String env = System.getProperty("archaius.deployment.environment");
        LOGGER.debug("validating environment");
        if(env.isEmpty() || env.equalsIgnoreCase("Undefined")){
            LOGGER.debug("environment is not defined");
            env = "local";
        }
        try {
            ConfigurationManager.loadCascadedPropertiesFromResources(env);
        } catch (IOException e) {
            LOGGER.error("UNABLE TO SET DEFAULT CONFIG FILE", e);
        }
        dynamicPropertyFactory = DynamicPropertyFactory.getInstance();
    }



    public static String getStringSetting(String settingName){
        return dynamicPropertyFactory.getStringProperty(settingName, "").get();
    }

    public static int getIntSetting(String settingName){
        return dynamicPropertyFactory.getIntProperty(settingName, -1).get();
    }

    public static boolean getBooleanSetting(String settingName){
        return dynamicPropertyFactory.getBooleanProperty(settingName, false).get();
    }

    public static String[] getArraySetting(String settingName){
        return getStringSetting(settingName).split(",");
    }

}
