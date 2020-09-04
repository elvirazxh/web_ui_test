package com.creditease.zxh;/**
 * Created by admin on 2020/9/3.
 */

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.testng.IExecutionListener;

/**
 * @author
 * @createTime 2020/9/3 17:56
 * @description
 */
public class TestNGListennerSendEmail implements IExecutionListener{


    @Override
    public void onExecutionStart() {
        System.out.println("所有case开始执行");

    }

    @Override
    public void onExecutionFinish() {
        System.out.println("this is test----------------->");
    HtmlEmail mail = new HtmlEmail();
    mail.setHostName("smtp.163.com");
    mail.setAuthentication("elvirazxh@163.com", "sz870129zxh");
    try {
        mail.setFrom("elvirazxh@163.com");
        mail.addTo("xuhuazhao@creditease.cn");
        mail.setSubject("selenium subject");
        mail.setCharset("UTF-8");
        mail.setHtmlMsg("<a href=\"\"> 测试报告");
        EmailAttachment emailattachment = new EmailAttachment();
        emailattachment.setPath("/Users/admin/Documents/zhaoxuhua/autotest/ui_web_test/report.html");
        emailattachment.setName("report.html");
        emailattachment.setDescription(EmailAttachment.ATTACHMENT);
        mail.attach(emailattachment);
        mail.send();
    } catch (EmailException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}
}
 
    