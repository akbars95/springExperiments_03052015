package com.mtsmda.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 * Created by MTSMDA on 18.05.2015.
 */
@Service(value = "mailService")
public class MailService {

    @Autowired
    private MailSender mailSender;

    @Autowired
    private SimpleMailMessage simpleMailMessage;

    public void sendMail(String from, String to, String subject, String text){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(text);

        mailSender.send(simpleMailMessage);
    }

    public void sendAlertMail(String alert){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage(this.simpleMailMessage);
        simpleMailMessage.setText(alert);
        mailSender.send(simpleMailMessage);
    }
}
