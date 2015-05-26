package com.mtsmda.myBlog.email;

import com.mtsmda.myBlog.model.MessageMail;
import com.mtsmda.myBlog.utils.BlogConstants;
import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by c-DMITMINZ on 5/21/2015.
 */
public class MailService {

    private static final Logger logger = Logger.getLogger(MailService.class);

    private MailSender mailSender;

    private JavaMailSender javaMailSender;

    private VelocityEngine velocityEngine;

    public MailService() {

    }

    public MailService(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public MailService(MailSender mailSender, VelocityEngine velocityEngine) {
        this.mailSender = mailSender;
        this.velocityEngine = velocityEngine;
        this.javaMailSender = mailSender;
    }

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void setVelocityEngine(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
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

    public boolean sendConfirmationEmail(final MessageMail messageMail){
        try{
        MimeMessagePreparator mimeMessagePreparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
                mimeMessageHelper.setTo(messageMail.getMailTo());
                mimeMessageHelper.setFrom(messageMail.getMailFrom());
                Map<String, Object> stringObjectMap = new HashMap<>();
                stringObjectMap.put("messageMail", messageMail);
                String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, BlogConstants.VELOCITY_MAIL_TEMPLATE_FILE_PATH, BlogConstants.ENCODING_UTF8, stringObjectMap);
                mimeMessageHelper.setText(text, true);
            }
        };
        this.javaMailSender.send(mimeMessagePreparator);
        }
        catch (Exception e){
            logger.info(this.getClass().getCanonicalName() + ".sendConfirmationEmail(final MessageMail messageMail)" + " - error - " + e.getMessage());
            return false;
        }
        return true;
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