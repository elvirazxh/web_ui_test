package com.creditease.zxh.handle;/**
 * Created by admin on 2020/9/2.
 */

import com.creditease.zxh.page.PayOrderPage;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

/**
 * @author
 * @createTime 2020/9/2 17:58
 * @description
 */
public class PayOrderHandle extends BaseHandle{

    PayOrderPage payOrderPage;


    public PayOrderHandle(WebDriver driver) {
        super(driver);
        payOrderPage = new PayOrderPage(driver);
    }

    //点击提交订单按钮
    public void clickSubmitOrderButton(){
        payOrderPage.getSubmitButtonElement().click();
    }

    //是否登录
    public boolean getUserIsLogin(){
        return payOrderPage.isLogin();
    }

    //植入cookie
    public void setUserCookie(){

//        String value = "M0OWNiNDA4NTRlNmYxYzVkZjkzZjI4OTE2M2E0NDMAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAODI2OTgwNgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA4NDYzMTYxNDhAcXEuY29tAAAAAAAAAAAAAAAAAAAAADkxNGVlMTZlM2RiMjNiYmE5Nzk5NmRhMmQ0ZmQ5MzBh62BQX5nELV8";
//        driver.manage().deleteAllCookies();
//        Cookie cookie = new Cookie("apsid", value, ".imooc.com", "/", null);
//        driver.manage().addCookie(cookie);


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

        //清除cookie后再赋值
        String value = driver.manage().getCookieNamed("apsid").getValue();
        System.out.println(value);
        driver.manage().deleteAllCookies();
        Cookie cookie = new Cookie("apsid", value, ".imooc.com", "/", null);
        driver.manage().addCookie(cookie);
        System.out.println(driver.manage().getCookies());
    }






}
 
    