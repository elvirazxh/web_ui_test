package com.creditease.zxh;
/**
 * Created by admin on 2020/8/2.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * @author
 * @createTime 2020/8/2 15:01
 * @description
 */
public class SeleniumOne {
    WebDriver driver;

    public void InitDriver(){
        System.setProperty("Webdriver.chrome.driver", "/Users/admin/Documents/tools/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://www.baidu.com");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }

    public void getElement(){

        System.out.println("定位元素开始------");
        driver.findElement(By.id("js-signin-btn")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.name("email")).sendKeys("13269395194");
        driver.findElement(By.className("js-loginPassword")).sendKeys("sz19870129zxh");
        WebElement NodeElement = driver.findElement(By.className("rlf-autoin"));
        NodeElement.findElement(By.tagName("input")).click();
        List<WebElement> ButtonElement = driver.findElements(By.className("rlf-group"));
        ButtonElement.get(4).click();//登录button
        driver.findElement(By.linkText("找回密码")).click();
        driver.findElement(By.partialLinkText("无法")).click();
        driver.findElement(By.xpath("//*[@id=\"signin\"]/div[3]/div[1]/span")).click();//手机短信的登录
        driver.findElement(By.cssSelector("#signup-form > div.rlf-group.pr.phoneVerityBox > p.reSend.pa.active.js-phonecode-box > span")).click();

    }


    public static void main(String[] args) {
        SeleniumOne seleniumOne = new SeleniumOne();
        seleniumOne.InitDriver();
//        seleniumOne.getElement();

    }

}
 
    