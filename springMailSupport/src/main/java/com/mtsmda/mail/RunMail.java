package com.mtsmda.mail;

import com.mtsmda.mail.service.MailService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by MTSMDA on 18.05.2015.
 */
public class RunMail {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("mailConfig.xml");
        MailService mailService = (MailService) applicationContext.getBean("mailService");
        mailService.sendAlertMail("Test");

    }
}