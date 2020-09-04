package com.creditease.zxh;

import java.util.Date;

//import org.apache.commons.mail.EmailAttachment;
//import org.apache.commons.mail.EmailException;
//import org.apache.commons.mail.HtmlEmail;
//import org.apache.commons.mail.SimpleEmail;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestNGListenerScreen.class})
public class TestngCase {

	private static Logger logger = Logger.getLogger(TestngCase.class);
	public WebDriver driver;
	
	
	 @BeforeClass
//	@BeforeGroups("sucess")
	public void beforeClass() {
		PropertyConfigurator.configure("log4j.properties");

		System.out.println("第一个beforeClass");
		System.setProperty("Webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.imooc.com/user/newlogin/from_url/1005");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	  public void afterClass() {
		  driver.close();
		  //SendMail();

	  }
//	@Test(groups="sucess")
	@Test
	public void test01() {
		logger.debug("邮箱信息");
		driver.findElement(By.name("email")).sendKeys("1111111@qq.com");
//		Assert.assertEquals(1, 2);
		System.out.println("第一个case");
	}
//	@Test(groups="sucess")
	@Test
	public void test02() {
		logger.error("错误的email");
		driver.findElement(By.id("email1")).sendKeys("1111111@qq.com");
		System.out.println("第2个case");
	}
//	@Test(groups="error")
	@Test
	public void test03() {
		driver.findElement(By.name("password")).sendKeys("1111111@qq.com");
		System.out.println("第3个case");
	}
//	@Test(groups="error")
	@Test
	public void test04() {
		//Assert.assertEquals(1, 2);
		driver.findElement(By.name("password1")).sendKeys("1111111@qq.com");
		System.out.println("第4个case");
	}
//	@Test(groups="error")
	@Test
	public void test05() {
		driver.findElement(By.className("moco-btn-red")).click();
		System.out.println("第5个case");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("第一个case before");
		
	}
//	public void SendToEmail() {
//		/**
//		 * 用什么邮箱发送
//		 * 登陆邮箱
//		 * 谁发给谁
//		 * 标题
//		 * 内容
//		 *
//		 * */
//
//		SimpleEmail email = new SimpleEmail();
//		email.setHostName("smtp.163.com");
//		email.setAuthentication("mushishi_xu@163.com", "TEST1234");
//		try {
//			email.setFrom("mushishi_xu@163.com");
//			email.addTo("609732836@qq.com");
//			email.setSubject("selenium subject");
//			email.setMsg("this is test");
//			email.send();
//			logger.debug("发送成功");
//		} catch (EmailException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//

	

	@AfterMethod
	public void afterMethod() {
		System.out.println("第一个case after");
	}
	
	
	
}
