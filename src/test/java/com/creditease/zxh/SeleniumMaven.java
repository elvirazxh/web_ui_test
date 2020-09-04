package com.creditease.zxh;/**
 * Created by admin on 2020/8/7.
 */

import com.creditease.zxh.util.PropertiesUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/**
 * @author zxh
 * @createTime 2020/8/7 10:38
 * @description
 */
public class SeleniumMaven {

    WebDriver driver;
    public void InitDriver(){
        System.setProperty("Webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.imooc.com/user/newlogin/from_url/1005");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        driver.close();
    }

    public By getByLocal(String key){
        PropertiesUtil propertiesUtil = new PropertiesUtil("element.properties");
        String locator = propertiesUtil.getProperty(key);
        String locatorBy = locator.split(">")[0];
        String locatorValue = locator.split(">")[1];
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

    public WebElement getElement(String key){
        WebElement element = driver.findElement(this.getByLocal(key));
        return element;
    }


    @Test
    public void userLogin() throws InterruptedException {

        PropertiesUtil property = new PropertiesUtil("user.properties");
        String user = null;
        String username;
        String password;
        int lines = property.getLines();
        for(int i=0;i<lines;i++){
            InitDriver();
            user = property.getProperty("user"+i);
            username = user.split(">")[0];
            password = user.split(">")[1];

            WebElement emailElement = getElement("username");
            WebElement passwordElement = getElement("password");
            WebElement loginButtonElement = getElement("loginbutton");

            emailElement.sendKeys(username);
            passwordElement.sendKeys(password);
            loginButtonElement.click();
            Thread.sleep(3000);

            try {
                WebElement UserPng = getElement("headpng");
                Actions MoseActions = new Actions(driver);
                MoseActions.moveToElement(UserPng).perform();
                Thread.sleep(1000);
                //获取img标签上的alt信息
                String userNameShow = getElement("userinfo").getAttribute("alt");

                if (userNameShow.equals("慕慕804234")){
                    System.out.println("登录成功");
                }else{
                    System.out.println("用户信息不匹配");
                }

            }catch (Exception e){
                e.printStackTrace();
            }
            driver.close();
        }



    }

    public static void main(String[] args) throws InterruptedException {
        SeleniumMaven seleniumMaven = new SeleniumMaven();
//        seleniumMaven.InitDriver();
        seleniumMaven.userLogin();
    }


}
 
    