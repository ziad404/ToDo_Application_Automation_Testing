package com.qacart.todo.utils;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import net.bytebuddy.implementation.bytecode.Throw;

import java.util.Properties;

public class ConfigUtils {
     private Properties properties;
     private static ConfigUtils configUtils;
     public ConfigUtils(){
         String env=System.getProperty("env","production");
         switch (env){
             case ("PRODUCTION"):
                 properties=PropertiesUtils.LoadProperties("src/test/java/com/qacart/todo/config/Production.properties");
                 break;
             case ("LOCAL"):
                 properties=PropertiesUtils.LoadProperties("src/test/java/com/qacart/todo/config/local.properties");
                 break;
             default:
                 throw new RuntimeException("Environment is not supported");
         }
     }
     public static ConfigUtils GetInstance(){
         if(configUtils==null){
             configUtils=new ConfigUtils();
         }return configUtils;
     }
     public String GetBaseUrl(){
          String prop= properties.getProperty("baseUrl");
          if(prop!=null)return prop;
          throw new RuntimeException("Cannot get Url");
     }
    public String GetEmail(){
        String prop= properties.getProperty("email");
        if(prop!=null)return prop;
        throw new RuntimeException("Cannot get email");
    }
    public String GetPassword(){
        String prop= properties.getProperty("password");
        if(prop!=null)return prop;
        throw new RuntimeException("Cannot get password");
    }
}
