package com.qacart.todo.utils;

import java.io.*;
import java.util.Properties;

public  class PropertiesUtils {
    public static Properties LoadProperties(String FilePath){
        File file=new File(FilePath);
        try {
            InputStream inputStream=new FileInputStream(file);
            Properties properties=new Properties();
            try {
                properties.load(inputStream);
                inputStream.close();
                return properties;
            } catch (IOException e) {
                throw new RuntimeException("Error While loading properties");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Cannot Find file");
        }

    }
}
