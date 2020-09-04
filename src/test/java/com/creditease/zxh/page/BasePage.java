package com.creditease.zxh.page;/**
 * Created by admin on 2020/8/20.
 */

import com.creditease.zxh.util.PropertiesUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

/**
 * @author
 * @createTime 2020/8/20 09:49
 * @description
 */
public class BasePage {
    public WebDriver driver;
    static Logger logger = Logger.getLogger(BasePage.class);

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getElement(String key){
        boolean flag = true;
        int i = 0;
        WebElement element = null;
        while (flag){
            try {
                element = driver.findElement(this.getByLocal(key));
                flag = false;
            }catch (Exception e){
                i=i+1;
                if (i==10){
                    flag=false;
                }
            }
        }
        return element;
    }

    public By getByLocal(String key){
        PropertiesUtil propertiesUtil = new PropertiesUtil("element.properties");
        logger.debug("你得定位信息得key为："+key);
        String locator = propertiesUtil.getProperty(key);
        String locatorBy = locator.split(">")[0];
        String locatorValue = locator.split(">")[1];
        logger.debug("你得定位方式为："+locatorBy);
        logger.debug("你得定位值为："+locatorValue);

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


    public void moveToElement(WebElement toElement){
        Actions mouseActions = new Actions(driver);
        mouseActions.moveToElement(toElement).perform();
    }


    public boolean getCookie(String key){
        Boolean flag = false;
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie cookie:cookies) {
            if (cookie.getName().equals(key)) {
                flag = true;
            }
        }
        return flag;
    }
}
 
    