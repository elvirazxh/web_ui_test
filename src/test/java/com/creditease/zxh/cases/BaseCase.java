package com.creditease.zxh.cases;/**
 * Created by admin on 2020/8/21.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author
 * @createTime 2020/8/21 16:36
 * @description
 */
public class BaseCase {
    public WebDriver driver;
    public WebDriver getDriver(String browser){
        if (browser.equals("chrome")){
            System.setProperty("Webdriver.chrome.driver", "/usr/local/bin/chromedriver");
            driver = new ChromeDriver();
        }
//        else {
//            System.setProperty("webdriver.gecko.driver", "");
//            driver = new FirefoxDriver();
//        }
        return driver;
    }


}

    