package com.creditease.zxh.cases;/**
 * Created by admin on 2020/8/20.
 */

import com.creditease.zxh.handle.LoginHandle;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.log4testng.Logger;
//import org.testng.annotations.Parameters;


/**
 * @author
 * @createTime 2020/8/20 16:39
 * @description
 */
public class LoginCase {

    static Logger logger = Logger.getLogger(LoginCase.class);

    public WebDriver driver;
    LoginHandle loginhandle;

//    @Parameters({"url"})
//    @BeforeClass
    @BeforeGroups(groups = "success")
    public void beforeClass() {
        PropertyConfigurator.configure("log4j.properties");
        logger.debug("初始化浏览器");
        logger.debug("打开浏览器");
        System.setProperty("Webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
//        driver = getDriver(browser);
        driver.get("https://www.imooc.com/user/newlogin/from_url/1005");
//        driver.get("https://coding.imooc.com");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loginhandle = new LoginHandle(driver);
    }

    @Test(dependsOnMethods = {"test01"})
    public void test02(){
        System.out.println("登录成功的依赖case");
    }

    @Test
    public void test01(){
        System.out.println("登录成功的依赖case");
    }



    //    @Test(groups = "success")
    //String username,String password
    @Parameters({"username","password"})
    @Test(groups = "success")
    public void testLoginSuccess(String username,String password){
        logger.debug("开始执行第一个case");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("tes01执行完成");
//        loginhandle.sendEmail("15210345751");
//        loginhandle.sendPassword("sz19870129zxh");
        loginhandle.sendEmail(username);
        loginhandle.sendPassword(password);
        loginhandle.clickLoginButton();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String userNameText = loginhandle.getUserName();
        Assert.assertEquals("慕慕804234",userNameText);
    }


    @Parameters({"username","password"})
    @Test(groups = "error")
    public void testLoginError(String username, String password){
        logger.debug("开始执行第二个case");
        loginhandle.sendEmail(username);
        loginhandle.sendPassword(password);
        loginhandle.clickLoginButton();
        String userNameText = loginhandle.getUserName();
        Assert.assertEquals("慕慕804234*",userNameText);
    }

    @AfterClass
    public void afterClass(){
        driver.close();
    }
}
 
    