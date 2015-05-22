package com.mtsmda.myBlog.email;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

/**
 * Created by c-DMITMINZ on 5/21/2015.
 */
public class MailService {

    private static final Logger logger = Logger.getLogger(MailService.class);

    private MailSender mailSender;


    public MailService() {
    }

    public MailService(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    private SimpleMailMessage getSimpleMailMessage(String from, String to, String subject, String text) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(text);
        logger.info(this.getClass().getCanonicalName() + ".getSimpleMailMessage(String from, String to, String subject, String text) - create success SimpleMailMessage object");
        return simpleMailMessage;
    }

    public void sendMail(String from, String to, String subject, String text) {
        logger.info(this.getClass().getCanonicalName() + ".sendMail(String from, String to, String subject, String text)");
        SimpleMailMessage simpleMailMessage = this.getSimpleMailMessage(from, to, subject, text);
        mailSender.send(simpleMailMessage);
    }

    public void sendMail(SimpleMailMessage simpleMailMessage) {
        logger.info(this.getClass().getCanonicalName() + ".sendMail(SimpleMailMessage simpleMailMessage)");
        mailSender.send(simpleMailMessage);
    }

    public void sendMail(SimpleMailMessage simpleMailMessage[]) {
        logger.info(this.getClass().getCanonicalName() + ".sendMail(SimpleMailMessage simpleMailMessage[])");
        mailSender.send(simpleMailMessage);
    }

    /*public void sendMailWithAttachment(String from, String to, String subject, String text, String filePath) throws Exception{
        this.getSimpleMailMessage(from, to, subject, text);
        MimeMessage mimeMessage = javaMailSenderImpl.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        FileSystemResource fileSystemResource = new FileSystemResource(filePath);
        mimeMessageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
        this.javaMailSenderImpl.send(mimeMessage);

    }*/
}