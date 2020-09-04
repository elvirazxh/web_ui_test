package com.creditease.zxh.page;/**
 * Created by admin on 2020/9/2.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author zxh
 * @createTime 2020/9/2 17:47
 * @description
 */
public class PayOrderPage extends BasePage{



    public PayOrderPage(WebDriver driver) {
        super(driver);
    }

    //是否登录的状态
    public boolean isLogin(){
        return getCookie("aspid");
    }



    //点击结算button
    public WebElement getSubmitButtonElement(){
        return getElement("submitButton");
    }
}
 
    