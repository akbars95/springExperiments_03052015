package com.mtsmda.myBlog.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

/**
 * Created by c-DMITMINZ on 5/21/2015.
 */
@Service(value = "mailService")
public class MailService {

    @Autowired
    private MailSender mailSender;

    private SimpleMailMessage getSimpleMailMessage(String from, String to, String subject, String text) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(text);

        return simpleMailMessage;
    }

    public boolean sendMail(String from, String to, String subject, String text) {
        try {
            SimpleMailMessage simpleMailMessage = this.getSimpleMailMessage(from, to, subject, text);
            mailSender.send(simpleMailMessage);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean sendMail(SimpleMailMessage simpleMailMessage) {
        try {
            mailSender.send(simpleMailMessage);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean sendMail(SimpleMailMessage simpleMailMessage[]) {
        try {
            mailSender.send(simpleMailMessage);
            return true;
        } catch (Exception e) {
            return false;
        }
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