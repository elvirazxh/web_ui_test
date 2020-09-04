package com.creditease.zxh;
/**
 * Created by admin on 2020/8/2.
 */

//import org.apache.xalan.templates.ElemElement;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author
 * @createTime 2020/8/2 20:29
 * @description
 */
public class SeleniumAction {

    WebDriver driver;

    public void InitDriver(){
        System.setProperty("Webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.imooc.com/user/newlogin/from_url/1005");
            try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    //输入框
    public void InputElement(){
        WebElement EmailElement = driver.findElement(By.name("email"));
        String UserInfo = EmailElement.getAttribute("placeholder");
        EmailElement.sendKeys("15210345751");
        driver.findElement(By.xpath("//*[@id=\"signup-form\"]/div[2]/input")).sendKeys("sz19870129zxh");
        driver.findElement(By.xpath("//*[@id=\"signup-form\"]/div[5]/input")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.getMessage();
            e.printStackTrace();
        }
//        System.out.println(UserInfo);
//        String Mobile = EmailElement.getAttribute("value");
//        System.out.println(Mobile);
//        boolean info = EmailElement.isEnabled();
//        System.out.println(info);

//        driver.close();


    }

    //单选框
    public void Radio() throws InterruptedException {
        driver.get("https://www.imooc.com/user/setprofile");
        Thread.sleep(1000);
        driver.findElement(By.className("js-edit-info")).click();
        Thread.sleep(2000);
        WebElement userForm = driver.findElement(By.id("profile"));//找到编辑个人信息对应的form
        List<WebElement> sexList = userForm.findElements(By.name("sex"));
        for (WebElement sex:sexList){
            if(sex.isSelected()){
                break;
            }else {
                Thread.sleep(1000);
                sex.click();
            }
        }
        driver.findElement(By.id("profile-submit")).click();

        driver.close();

    }


    //多选框
    public void CheckBox(){
        WebElement box = driver.findElement(By.id("auto-signin"));
        box.isEnabled();
        System.out.println(box.isSelected());
        driver.close();
    }

    //按钮操作
    public void Button() throws InterruptedException {
        System.out.println("--------------->");
        WebElement ButtonElement = driver.findElement(By.className("moco-btn-red"));
        System.out.println(ButtonElement.isDisplayed());
        System.out.println(ButtonElement.isEnabled());
        System.out.println("--------------->");
        String JsString = "document.getElementsByClassName(\'moco-btn-red\')[0].style.display=\'None\';";//登录button置灰
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(JsString);
        Thread.sleep(3000);
        WebElement ButtonElement1 = driver.findElement(By.className("moco-btn-red"));
        System.out.println(ButtonElement1.isDisplayed());
        System.out.println(ButtonElement1.isEnabled());

        driver.close();

    }

    //定位form  执行form的动作
    public void WebForm(){
        WebElement EmailElement = driver.findElement(By.name("email"));
        String UserInfo = EmailElement.getAttribute("placeholder");
        EmailElement.sendKeys("15210345751");
        driver.findElement(By.name("password")).sendKeys("sz19870129zxh");
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.getMessage();
            e.printStackTrace();
        }
        driver.findElement(By.id("signup-form")).submit();
        System.out.println(UserInfo);
        driver.close();
    }


    public void upload_file() throws InterruptedException {
        driver.get("https://www.imooc.com/user/setbindsns");
        WebElement HeadPng = driver.findElement(By.className("avator-mode"));
        Actions actions = new Actions(driver);
        actions.moveToElement(HeadPng).perform();
        driver.findElement(By.className("update-avator")).click();//update-avator   js-avator-link
        Thread.sleep(1000);
        driver.findElement(By.id("upload")).sendKeys("/Users/admin/Desktop/11596858240_.pic.jpg");
        Thread.sleep(2000);
        driver.findElement(By.className("js-avator-save")).click();

        driver.close();

    }

    //模拟动作上传
    public void upload_file1() throws InterruptedException, AWTException {
        driver.get("https://www.imooc.com/user/setbindsns");
        WebElement HeadPng = driver.findElement(By.className("avator-mode"));
        Actions actions = new Actions(driver);
        actions.moveToElement(HeadPng).perform();
        driver.findElement(By.className("update-avator")).click();//update-avator   js-avator-link
        Thread.sleep(1000);
        StringSelection SelectJpg = new StringSelection("/Users/admin/Desktop/11596858240_.pic.jpg");
        Clipboard sysc = Toolkit.getDefaultToolkit().getSystemClipboard();
        sysc.setContents(SelectJpg, null);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(2000);
        driver.close();

    }

    //下拉框定位选择操作
    public void SelectOption() throws InterruptedException {
        driver.get("http://www.imooc.com/user/setprofile");
        Thread.sleep(1000);
        driver.findElement(By.className("js-edit-info")).click();// 弹出编辑页面
        Thread.sleep(2000);
        WebElement UserForm = driver.findElement(By.id("profile"));//定位到个人信息编辑页面上form
        UserForm.findElement(By.id("job")).click();
        //查找定位元素的方式
        List<WebElement> JobList = UserForm.findElements(By.tagName("option"));
        System.out.println(JobList.size());
        JobList.get(6).click();
        Thread.sleep(2000);
        driver.close();
    }

    //下拉框选择  selenium 的select标签
    public void SeleOptionSelenium() throws InterruptedException {
        driver.get("http://www.imooc.com/user/setprofile");
        Thread.sleep(2000);
        driver.findElement(By.className("js-edit-info")).click();// 弹出编辑页面
        Thread.sleep(3000);
        WebElement UserForm = driver.findElement(By.id("profile"));//定位到个人信息编辑页面form
        WebElement job = UserForm.findElement(By.id("job"));
        //selenium的select标签形式
        Select DownList = new Select(job);//select 标签
//        DownList.selectByValue("8");
//        Thread.sleep(2000);
//        DownList.selectByVisibleText("交互设计师");
        Thread.sleep(2000);
//        DownList.deselectByVisibleText("交互设计师");
        List<WebElement> SelectOptions = DownList.getAllSelectedOptions();
        System.out.println(SelectOptions);
        for (WebElement option:SelectOptions){
            System.out.println(option.getText());
        }

        driver.close();
    }

    //验证登录操作
    public void UserLogin() throws InterruptedException {
//        https://www.imooc.com/user/setprofile
        WebElement EmailElement = driver.findElement(By.name("email"));
        WebElement PassWordElement = driver.findElement(By.name("password"));
        WebElement LoginButtonElement = driver.findElement(By.className("moco-btn-red"));
        EmailElement.sendKeys("15210345751");
        PassWordElement.sendKeys("sz19870129zxh");
        LoginButtonElement.click();
        Thread.sleep(3000);

        WebElement UserPng = driver.findElement(By.id("header-avator"));
        Actions MoseActions = new Actions(driver);
        MoseActions.moveToElement(UserPng).perform();
        Thread.sleep(1000);
//        String UserName = driver.findElement(By.name("text-ellipsis")).getText();
//        获取img标签上的alt信息
        String UserName = driver.findElement(By.xpath("//*[@id=\"header-user-card\"]/div/div/div[1]/a/img")).getAttribute("alt");

        if (UserName.equals("慕慕804234")){
            System.out.println("登录成功");
        }else{
            System.out.println("用户信息不匹配");
        }
        driver.close();
    }



    //鼠标移动操作
    public void MouseAction() throws InterruptedException {
        driver.get("http://www.imooc.com");
        Thread.sleep(2000);
//        WebElement LoginElement = driver.findElement(By.id("js-signin-btn"));
        Actions MouseActions = new Actions(driver);
//        MouseActions.click(LoginElement).perform();
        List<WebElement> MenuElementList = driver.findElements(By.className("item"));
        WebElement MobileElement = MenuElementList.get(1);//  定位到前端/小程序/JS
        MouseActions.moveToElement(MobileElement).perform();//鼠标移动上去
        driver.findElement(By.linkText("小程序")).click();//点击小程序
        Thread.sleep(5000);
//        driver.close();

    }

//    切换iframe
    public void SwitchIframe() throws InterruptedException {
        driver.get("https://www.imooc.com/article/publish#");
        try{
            driver.findElement(By.id("ueditor_0")).sendKeys("adfjggf");
        }catch (Exception e){
            System.out.println("定位直接输入错误");
        }
        WebElement IframeElement = driver.findElement(By.id("ueditor_0"));
        driver.switchTo().frame(IframeElement);
        Thread.sleep(5000);
//        WebElement Ueditor = driver.findElement(By.tagName("p"));
        List<WebElement> UeditorList = driver.findElements(By.className("view"));

        Actions MouseActions = new Actions(driver);
        MouseActions.moveToElement(UeditorList.get(1)).perform();
//        Thread.sleep(2000);
//        MouseActions.sendKeys("test this is ").perform();
        Thread.sleep(2000);
        UeditorList.get(1).sendKeys("this is test");
        Thread.sleep(2000);
        driver.close();
    }


    //切换窗体
    public void WindowsHandle() throws InterruptedException {
        //得到当前浏览器中的所有窗体
        Set<String> Handles = driver.getWindowHandles();
        String CurlHandle = driver.getWindowHandle();
        for (String s: Handles){
            if (s.equals(CurlHandle)){
                continue;
            }else {
                driver.switchTo().window(s);
            }

        }
        //shizhan-course-box course-card-name
        List<WebElement> courseList = driver.findElements(By.className("shizhan-course-box"));
        courseList.get(0).click();
        Thread.sleep(2000);

        driver.close();
    }


    public void AlertWWindow() throws InterruptedException {
//        driver.get("/Users/admin/Desktop/test_tc.html");

        driver.get("file:///Users/admin/Desktop/test_tc.html");
        driver.findElement(By.id("alert")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        driver.findElement(By.id("confirm")).click();
        Alert confirm = driver.switchTo().alert();
        String textConfirm = confirm.getText();
        System.out.println(textConfirm);
        Thread.sleep(2000);
        confirm.accept();
        Thread.sleep(2000);

        driver.findElement(By.id("prompt")).click();
        Alert prompt = driver.switchTo().alert();
        String textPrompt = prompt.getText();
        System.out.printf(textPrompt);
        Thread.sleep(2000);
        prompt.sendKeys("hello");
        prompt.accept();
        Thread.sleep(2000);
        driver.close();

    }

    public void Wait(){
//        隐式等待
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        显示等待
        driver.get("http://www.imooc.com");
        WebDriverWait wait = new WebDriverWait(driver, 1);
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("js-signin-btn")));
        }catch (Exception e){
            e.printStackTrace();
        }
        driver.close();

    }







    public static void main(String[] args) throws InterruptedException, AWTException {
        SeleniumAction seleniumAction = new SeleniumAction();
        seleniumAction.InitDriver();
//        seleniumAction.InputElement();
//        seleniumAction.Radio();
//        seleniumAction.CheckBox();
//        seleniumAction.Button();
//        seleniumAction.WebForm();
//        seleniumAction.upload_file();
//        seleniumAction.upload_file1();
//        seleniumAction.SelectOption();
//        seleniumAction.SeleOptionSelenium();
        seleniumAction.UserLogin();//只和InitDriver一起运行
//        seleniumAction.MouseAction();
//        seleniumAction.AlertWWindow();
//        seleniumAction.WindowsHandle();//切换窗体时和鼠标移动事件MouseAction一块执行.

//        seleniumAction.SwitchIframe();
    }




}
 
    