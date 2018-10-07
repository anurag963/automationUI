package com.app.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileUtil {

    InputStream inputstream;
    Properties properties;
    String value;

    public String propertyFileReader(String key, String filePath){
        try {
            inputstream = getClass().getResourceAsStream(filePath);
            properties = new Properties();
            properties.load(inputstream);
            value=properties.getProperty(key);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    return value;
    }

}
