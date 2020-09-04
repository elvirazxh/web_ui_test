package com.creditease.zxh.cases;/**
 * Created by admin on 2020/9/3.
 */

import com.creditease.zxh.handle.LoginHandle;
import com.creditease.zxh.handle.PayOrderHandle;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

/**
 * @author
 * @createTime 2020/9/3 09:48
 * @description
 */
public class PayOrderCase extends BaseCase{

    static Logger logger = Logger.getLogger(LoginCase.class);
    PayOrderHandle payOrderHandle;


    @Parameters({"url","browser"})
    @BeforeClass
    public void beforeClass(String url,String browser) {
        PropertyConfigurator.configure("log4j.properties");
        driver = getDriver(browser);
        System.out.println(url);
        driver.get(url);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        payOrderHandle = new PayOrderHandle(driver);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void afterClass(){
        driver.close();
    }



    @Parameters({"url"})
    @Test
    public void payOrder(String url){//未登录确认订单
        System.out.println(url);
        String buttonTitle;
        driver.get(url);
        try {
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        buttonTitle = driver.getTitle();
        boolean flag = buttonTitle.contains("慕课网-登录");
        Assert.assertEquals(flag, true);
    }


    @Parameters({"url"})
    @Test
    public void loginPayOrder(String url){//登录后确认订单

//        payOrderHandle.setUserCookie();
//        System.out.println(driver.manage().getCookies());
//        try {
//            Thread.sleep(2000);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        //刷新页面
//        driver.navigate().refresh();
        //跳转到确认订单页面
        driver.get(url);

        //未登录,跳转到登录页面后获取到cookie后植入cookie.
        payOrderHandle.setUserCookie();

        //植入cookie成功后跳转到确认订单页面
        driver.get(url);

        String submitTitle;
        submitTitle = driver.getTitle();
        boolean flag = submitTitle.contains("确认订单_慕课网");
        Assert.assertEquals(flag, true);
        payOrderHandle.clickSubmitOrderButton();
    }



}
 
    