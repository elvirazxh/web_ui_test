package com.creditease.zxh.handle;/**
 * Created by admin on 2020/8/28.
 */

import com.creditease.zxh.page.CoursePage;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

/**
 * @author
 * @createTime 2020/8/28 14:51
 * @description
 */
public class CourseHandle extends BaseHandle{

    public CoursePage coursePage;


    public CourseHandle(WebDriver driver) {
        super(driver);
        coursePage = new CoursePage(driver);

    }

    //得到购物车数量
    public int getCartNum(){
        int cartNum;
        try {
            cartNum = Integer.parseInt(coursePage.getCartNumElement().getText());
        }catch(Exception e){
            cartNum = 0;
        }
        return cartNum;
    }

    //点击添加购物车操作
    public void clickAddCartButton(){
        clickElement(coursePage.getAddCartElement());
    }

    // 用户是否登录
    public boolean getUserIsLogin(String key){
        return getUserIsLogin(key);
    }

    //植入cookie
    public void setUserCookie(){
        String value = "M0OWNiNDA4NTRlNmYxYzVkZjkzZjI4OTE2M2E0NDMAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAODI2OTgwNgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA4NDYzMTYxNDhAcXEuY29tAAAAAAAAAAAAAAAAAAAAADI5ZDY4ODBlYWUxMjc3MzBhNmVjYTk0MmRmYWIzZGY19chIX5nELV8";
        driver.manage().deleteAllCookies();
        Cookie cookie = new Cookie("apsid", value, ".imooc.com", "/", null);
        driver.manage().addCookie(cookie);
    }

    //点击立即购买
    public void clickBuyNow(){
        clickElement(coursePage.getBuyNowElement());
    }


}
 
    