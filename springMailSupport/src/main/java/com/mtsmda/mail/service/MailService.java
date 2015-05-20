package com.mtsmda.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

/**
 * Created by MTSMDA on 18.05.2015.
 */
@Service(value = "mailService")
public class MailService {

    @Autowired
    private MailSender mailSender;

    @Autowired
    private SimpleMailMessage simpleMailMessage;

    @Autowired
    private JavaMailSenderImpl javaMailSenderImpl;

    private SimpleMailMessage getSimpleMailMessage(String from, String to, String subject, String text){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(text);

        return simpleMailMessage;
    }

    public void sendMail(String from, String to, String subject, String text){
        this.getSimpleMailMessage(from, to, subject, text);
        mailSender.send(simpleMailMessage);
    }

    public void sendAlertMail(String alert){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage(this.simpleMailMessage);
        simpleMailMessage.setText(alert);
        mailSender.send(simpleMailMessage);
    }

    public void sendMailWithAttachment(String from, String to, String subject, String text, String filePath) throws Exception{
        this.getSimpleMailMessage(from, to, subject, text);
        MimeMessage mimeMessage = javaMailSenderImpl.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        FileSystemResource fileSystemResource = new FileSystemResource(filePath);
        mimeMessageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
        this.javaMailSenderImpl.send(mimeMessage);

    }
}
