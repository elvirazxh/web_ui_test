package com.creditease.zxh;/**
 * Created by admin on 2020/8/17.
 */

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author
 * @createTime 2020/8/17 15:16
 * @description
 */

public class CourseList {

    public WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        System.out.println("第一个beforeClass");
        System.setProperty("Webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
//        driver.get("https://www.imooc.com/user/newlogin/from_url/1005");
        driver.get("https://coding.imooc.com");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


//    @Test
//    public void test01() {
//        List<String> listString = ListCourseTitle();
//        for(int i=0;i<listString.size();i++) {
//            //String courseTitle = courseName.getText();
//            //courseName.click();
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//
//            System.out.println(listString.get(i));
////            driver.findElement(By.xpath("*//p[@title='"+listString.get(i)+"']")).click();
////            driver.findElement(By.xpath("*//p[contains(@title, '"+listString.get(i)+"')]")).click();
//            // Actions 解决 The element is not visible to click.问题
//            Actions actions = new Actions(driver);//
//            actions.moveToElement(driver.findElement(By.xpath("*//p[contains(@title, '"+listString.get(i)+"')]"))).click().perform();
//            driver.navigate().back();
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//        System.out.println("第一个case");
//    }

    @Test
    public void test02(){
        List<Integer> numList = pageNumList();
        for (int j=0; j<numList.size(); j++){
            List<WebElement> courseList = driver.findElements(By.className("shizan-name"));
            System.out.println(courseList.size());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Actions actions = new Actions(driver);//
            for (int i=0;i<courseList.size();i++){
                actions.moveToElement(courseList.get(i)).click().perform();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                driver.navigate().back();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                System.out.println(courseList.get(i).getText());
                courseList = driver.findElements(By.className("shizan-name"));
            }
        }
        driver.findElement(By.linkText("下一页")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

//    @Test
//    public void test03(){
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        List<WebElement> courseList = driver.findElements(By.className("shizan-name"));
//        Actions actions = new Actions(driver);//
//
//        for(WebElement courseName:courseList){
//            System.out.println(courseName.getText());
//            actions.moveToElement(courseName).click().perform();
//            driver.navigate().back();
//        }
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        courseList = driver.findElements(By.className("shizan-name"));
//
//    }
//


    @AfterClass
    public void afterClass() {
        driver.close();
    }


    public List<Integer> pageNumList(){
        List<Integer> pageNumList = new ArrayList<>();
        List<WebElement> aElementList = driver.findElement(By.className("page")).findElements(By.tagName("a"));
        for (WebElement aElement:aElementList) {
            String pageNum = aElement.getText();
            if (isNumber(pageNum) == true){
                pageNumList.add(Integer.valueOf(pageNum).intValue());
            }
        }
        System.out.println(pageNumList.size());
        return pageNumList;
    }


    public boolean isNumber(String pageNum){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(pageNum);
        if (isNum.matches()){
            return true;
        }
        return false;
    }

    public List<String> ListCourseTitle(){
        List<String> listCourseTitle = new ArrayList<String>();
        List<WebElement> courseList = driver.findElements(By.className("shizan-name"));
        for(WebElement courseName : courseList) {
            String courseTitle = courseName.getText();
            listCourseTitle.add(courseTitle);
        }
        return listCourseTitle;
    }


}
 
    