package com.creditease.zxh;/**
 * Created by admin on 2020/8/14.
 */

import com.creditease.zxh.util.PropertiesUtil;
import com.google.common.io.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;


/**
 * @author
 * @createTime 2020/8/14 18:30
 * @description
 */
public class OneTestCase {
    public WebDriver driver;


    @Test
    public void f() {
        System.out.println("This is test case f");
    }

    @Test
    public void f1() {
        System.out.println("This is test case f1");
        PropertiesUtil property = new PropertiesUtil("user.properties");
        String user = null;
        String username;
        String password;
        int lines = property.getLines();
        for(int i=0;i<lines;i++){
//            InitDriver();
            user = property.getProperty("user"+i);
            username = user.split(">")[0];
            password = user.split(">")[1];

            WebElement emailElement = getElement("username");
            WebElement passwordElement = getElement("password");
            WebElement loginButtonElement = getElement("loginbutton");

            emailElement.sendKeys(username);
            passwordElement.sendKeys(password);
            loginButtonElement.click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {

                WebElement UserPng = getElement("headpng");
                Actions MoseActions = new Actions(driver);
                MoseActions.moveToElement(UserPng).perform();
                Thread.sleep(1000);
                //获取img标签上的alt信息
                String userNameShow = getElement("userinfo").getAttribute("alt");

                if (userNameShow.equals("慕慕804234")){
                    takeScreenShot();
                    System.out.println("登录成功");


                }else{
                    takeScreenShot();
                    System.out.println("用户信息不匹配");
                }

            }catch (Exception e){
                e.printStackTrace();
            }
//            driver.close();
//            emailElement.clear();
//            passwordElement.clear();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }


    public By getByLocal(String key){
        PropertiesUtil propertiesUtil = new PropertiesUtil("element.properties");
        String locator = propertiesUtil.getProperty(key);
        String locatorBy = locator.split(">")[0];
        String locatorValue = locator.split(">")[1];
        if (locatorBy.equals("id")){
            return By.id(locatorValue);
        }else if(locatorBy.equals("name")){
            return By.name(locatorValue);
        }else if(locatorBy.equals("className")){
            return By.className(locatorValue);
        }else{
            return By.xpath(locatorValue);
        }
    }

    public WebElement getElement(String key){
        WebElement element = driver.findElement(this.getByLocal(key));
        return element;
    }



    @BeforeMethod
    public void beforeMethod() {
        System.out.println("This is test beforeMethod");

    }


    @AfterMethod
    public void afterMethod() {
        System.out.println("This is test afterMethod");

    }


    @BeforeTest
    public void beforeTest() {
        System.out.println("This is test beforeTest");

    }

    @AfterTest
    public void afterTest() {
        System.out.println("This is test afterTest");

    }

    @BeforeClass
    public void beforeClass() {
        System.setProperty("Webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.imooc.com/user/newlogin/from_url/1005");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void afterClass() {
        driver.close();

    }

    public void takeScreenShot(){
        //图片名字
        //图片存的路径
        //获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        String curTime = sdf.format(new Date());
//        获取当前类名
        String curClassName = this.getClass().getName();
        String pngPath = curClassName+"_"+curTime+".png";
//        路径
        String curPath = System.getProperty("user.dir");
        File ScrFile = ((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(ScrFile, new File(curPath+"\\"+pngPath));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
 
    