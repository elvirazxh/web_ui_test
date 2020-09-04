package com.creditease.zxh;/**
 * Created by admin on 2020/8/26.
 */

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

/**
 * @author
 * @createTime 2020/8/26 17:41
 * @description
 */
public class BuyShop {

    public WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        PropertyConfigurator.configure("log4j.properties");
        System.setProperty("Webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
    }


    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://coding.imooc.com/class/303.html");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Test
    public void testBuyShop(){
        int beforeNum = 0;
        int afterNum = 0;
        String courseTitle = driver.getTitle();
        System.out.println(courseTitle);
        if (courseTitle.contains("剑指Java面试-Offer直通车")){
            System.out.println("获取title正确");
            try {
                beforeNum = Integer.parseInt(driver.findElement(By.className("js-cart-num")).getText());
            } catch (Exception e) {
                System.out.println("购物车数量为空");
            }
            driver.findElement(By.className("js-addcart")).click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            afterNum = Integer.parseInt(driver.findElement(By.className("js-cart-num")).getText());
            int a = afterNum - beforeNum;
            if (a == 1){
                System.out.println("添加购物车成功!");
            }
        }

    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("afterMethod执行完毕");
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }


}
 
    