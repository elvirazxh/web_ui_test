package com.creditease.zxh;

import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;

//import org.apache.commons.mail.EmailAttachment;
//import org.apache.commons.mail.EmailException;
//import org.apache.commons.mail.HtmlEmail;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.google.common.io.Files;


public class TestNGListenerScreen  extends TestListenerAdapter{
	  @Override
	  public void onTestFailure(ITestResult tr) {
		  System.out.println(tr.getInstance());
//		  BaseCase tc = (BaseCase)tr.getInstance();
		  TestngCase tc = (TestngCase) tr.getInstance();
		  WebDriver driver = tc.driver;
		  System.out.println("第一个case失败执行的");
		  this.TakeScreenShot(driver);
		  super.onTestFailure(tr);
	  }

		public void TakeScreenShot(WebDriver driver) {
			//图片名字
			//图片存的路径
			//获取当前时间
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
			String curTime = sdf.format(new Date());
			//获取当前类名
			String curClassName = this.getClass().getName();
			String pngPath = curClassName+"_"+curTime+".png";
			//路径
			String curPath = System.getProperty("user.dir");
			
			File ScrFile = ((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
			try {
				Files.copy(ScrFile, new File(curPath+"/"+pngPath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	  
}
