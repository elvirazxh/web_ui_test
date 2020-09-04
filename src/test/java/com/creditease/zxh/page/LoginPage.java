package com.creditease.zxh.page;/**
 * Created by admin on 2020/8/20.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author
 * @createTime 2020/8/20 09:32
 * @description
 */
public class LoginPage extends BasePage{
    /**
     * 获取邮箱元素
     * 获取密码元素
     * 获取7天登录元素
     * 获取登录按钮元素
     */


//    LoginHandle
    /**
     * 输入邮箱
     * 输入密码
     * 点击7天登录
     * 点击登录按钮
     */

    //按照页面进行所有元素的封装
    //按照页面对所有元素的操作进行封装
    //按照页面对所有的case进行封装

    public LoginPage(WebDriver driver){
        super(driver);

    }

    public WebElement getEmailElement(){

        return getElement("username");
    }

    public WebElement getPasswordElement(){
        return getElement("password");
    }

    public WebElement getSevenElement(){
        return getElement("seven");
    }

    public WebElement getLoginBtnElement(){
        return getElement("loginbutton");

    }

    public WebElement getHeadpngElement(){
        return getElement("headpng");
    }

    public WebElement getUserinfoElement(){
        return getElement("userinfo");
    }






}
 
    