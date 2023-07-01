package com.helpers;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    /*
    This method is used to load properties
    */
    public Properties init_prop(){

        Properties prop = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream("src/test/resources/config/config.properties");
            prop.load(inputStream);

        }catch (Exception exception){
            exception.printStackTrace();
        }
        return prop;
    }

}
