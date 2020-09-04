package com.creditease.zxh.handle;/**
 * Created by admin on 2020/8/21.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author
 * @createTime 2020/8/21 14:55
 * @description
 */
public class BaseHandle {
    public WebDriver driver;
    public BaseHandle(WebDriver driver){
        this.driver = driver;
    }


    public void clickElement(WebElement element) {
        element.click();
    }

    /**
     *  清空输入框
     * @param element
     */
    public void clearText(WebElement element){
        element.clear();
    }
}
 
    