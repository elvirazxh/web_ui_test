package com.creditease.zxh.util;/**
 * Created by admin on 2020/8/14.
 */



import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author zxh
 * @createTime 2020/8/14 10:43
 * @description
 */
public class PropertiesUtil {
    public Properties property;
    public PropertiesUtil(String filePath){
        property = RedProperties(filePath);
    }

    private Properties RedProperties(String filePath) {
        Properties properties = new Properties();
        FileInputStream fileInputStream;
        try{
            fileInputStream = new FileInputStream(filePath);
            BufferedInputStream bufferIn = new BufferedInputStream(fileInputStream);
            properties.load(bufferIn);
        }catch (Exception e){
            e.printStackTrace();
        }
        return properties;
    }

    public String getProperty(String key){
        String value;
        if (property.containsKey(key)){
            value = property.getProperty(key);
            return value;
        }else{
            return "";
        }
    }

    public int getLines(){
        return property.size();
    }


    public static void main(String[] args) {
        PropertiesUtil propertiesUtil = new PropertiesUtil("element.properties");
        System.out.println(propertiesUtil.getProperty("username"));
    }

}
 
    