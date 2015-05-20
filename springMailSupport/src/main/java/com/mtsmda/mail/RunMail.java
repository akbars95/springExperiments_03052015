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
//        mailService.sendAlertMail("Test");

        try {
            mailService.sendMailWithAttachment("web.artem.artemov@gmail.com", "mynzat.dmitrii.crmd290@gmail.com", "Mail with attachment", "Simple Text", "T:\\development\\real\\springExperiments_03052015\\springMailSupport\\simpleTextFile.txt");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("OK");
    }
}