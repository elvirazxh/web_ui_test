package com.creditease.zxh.handle;/**
 * Created by admin on 2020/8/20.
 */

import com.creditease.zxh.page.LoginPage;
import org.openqa.selenium.WebDriver;

/**
 * @author
 * @createTime 2020/8/20 15:09
 * @description
 */
public class LoginHandle extends BaseHandle{
    public LoginPage loginPage;

    public LoginHandle(WebDriver driver) {
        super(driver);
        loginPage = new LoginPage(driver);
    }

    public void sendEmail(String email){
        loginPage.getEmailElement().sendKeys(email);
    }

    public void sendPassword(String password){
        loginPage.getPasswordElement().sendKeys(password);
    }

    public void clickSevenBox(){
        loginPage.getSevenElement().click();
    }

    public void clickLoginButton(){
        loginPage.getLoginBtnElement().click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getUserName(){
        loginPage.moveToElement(loginPage.getHeadpngElement());
        String username = loginPage.getUserinfoElement().getAttribute("alt");
        return username;
    }
}
 
    