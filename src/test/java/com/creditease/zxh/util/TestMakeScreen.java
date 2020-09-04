package com.creditease.zxh.util;/**
 * Created by admin on 2020/8/15.
 */


import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author
 * @createTime 2020/8/15 21:27
 * @description
 */
public class TestMakeScreen {

    public void takeScreenshot(TakesScreenshot screenShot, WebDriver driver) {
        Date now = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmss");
        String curTime = f.format(now);

        File tempFile = null;
        File destFile = null;


        //获取当前类名
        String curClassName = this.getClass().getName();
        String pngPath = curClassName+"_"+curTime+".png";
        //路径
        String curPath = System.getProperty("user.dir");
        tempFile = screenShot.getScreenshotAs(OutputType.FILE);
        destFile = new File(curPath+"/"+pngPath);

        try {
            Files.copy(tempFile, destFile);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        //驱动配置
        System.setProperty("Webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com");


        //声明截屏接口对象screenShot
        TakesScreenshot screenShot = (TakesScreenshot) driver;

        //调用上面的方法截屏
        TestMakeScreen demo = new TestMakeScreen();
        demo.takeScreenshot(screenShot,driver);

        driver.quit();
    }
}
 
    