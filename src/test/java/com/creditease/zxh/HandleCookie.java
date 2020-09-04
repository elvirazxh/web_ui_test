package com.creditease.zxh;
/**
 * Created by admin on 2020/8/27.
 */

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.Set;

/**
 * @author
 * @createTime 2020/8/27 14:15
 * @description
 */
public class HandleCookie {

    public WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        PropertyConfigurator.configure("log4j.properties");
        System.setProperty("Webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://coding.imooc.com/class/303.html");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

//    @Test
//    public void test01(){
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Set<Cookie> cookies = driver.manage().getCookies();
//        for (Cookie cookie:cookies) {
//            if (cookie.equals("aspid")) {
//                System.out.println("登录成功,获取到cookie");
//            }
//        }
//    }



    public void test01(){

    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("afterMethod执行完毕");
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }

}
 
    