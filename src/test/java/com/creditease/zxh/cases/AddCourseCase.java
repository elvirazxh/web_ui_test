package com.creditease.zxh.cases;/**
 * Created by admin on 2020/8/28.
 */

import com.creditease.zxh.handle.CourseHandle;
import com.creditease.zxh.handle.LoginHandle;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

/**
 * @author
 * @createTime 2020/8/28 15:00
 * @description
 */
public class AddCourseCase extends BaseCase{
    static Logger logger = Logger.getLogger(LoginCase.class);
    CourseHandle courseHandle;


    @Parameters({"url","browser"})
    @BeforeClass
    public void beforeClass(String url,String browser) {
        PropertyConfigurator.configure("log4j.properties");
        driver = getDriver(browser);
        driver.get(url);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        courseHandle = new CourseHandle(driver);
    }

    /**
     * 未登录添加购物车
     * @param coursename
     */
    @Parameters({"coursename"})
    @Test
    public void testAddCourseSuccess(String coursename){
        String courseTitle = driver.getTitle();
        boolean flag = courseTitle.contains(coursename);
        Assert.assertEquals(flag, true);//判断是否获取到课程名称
        int beforeNum = courseHandle.getCartNum();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        courseHandle.clickAddCartButton();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //未登录,跳转到登录页面
        LoginHandle loginHandle = new LoginHandle(driver);
        loginHandle.sendEmail("15210345751");
        loginHandle.sendPassword("sz19870129zxh");
        loginHandle.clickLoginButton();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //登录成功后跳回购物车页面,再次点击添加购物车button
        courseHandle.clickAddCartButton();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int afterNum = courseHandle.getCartNum();
        int a = afterNum-beforeNum;
        Assert.assertEquals(a,1);
    }

    @Test
    public void testAlreadyLogin(){
        courseHandle.setUserCookie();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.navigate().refresh();
        courseHandle.clickBuyNow();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }






    @AfterClass
    public void afterClass(){
        driver.close();
    }

}
 
    