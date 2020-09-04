package com.creditease.zxh.page;/**
 * Created by admin on 2020/8/28.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author zxh
 * @createTime 2020/8/28 14:36
 * @description
 */
public class CoursePage extends BasePage{


    public CoursePage(WebDriver driver) {
        super(driver);
    }

    //添加购物车button
    public WebElement getAddCartElement(){
        return getElement("addCart");
    }

    //得到购物车课程数量
    public WebElement getCartNumElement(){
        return getElement("cartNum");
    }

    //立即购买button
    public WebElement getBuyNowElement(){
        return getElement("buyNow");
    }

    //右上角购物车
    public WebElement getCartElement(){
        return getElement("cart");
    }

    //
    public WebElement getCartAlreadyElement(){
        return getElement("cartAlready");
    }

    //是否登录的状态
    public boolean getUserIsLogin(){
        return getCookie("aspid");
    }

}
 
    