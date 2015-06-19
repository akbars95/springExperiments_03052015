package com.mtsmda.myBlog.email;

import com.mtsmda.myBlog.model.MailMessage;
import com.mtsmda.myBlog.utils.constants.BlogConstants;
import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by c-DMITMINZ on 5/21/2015.
 */
public class MailService {

    private static final Logger logger = Logger.getLogger(MailService.class);

    private JavaMailSender javaMailSender;

    private VelocityEngine velocityEngine;

    public MailService() {

    }

    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public MailService(JavaMailSender javaMailSender, VelocityEngine velocityEngine) {
        this.javaMailSender = javaMailSender;
        this.velocityEngine = velocityEngine;
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
        javaMailSender.send(simpleMailMessage);
    }

    public void sendMail(SimpleMailMessage simpleMailMessage) {
        logger.info(this.getClass().getCanonicalName() + ".sendMail(SimpleMailMessage simpleMailMessage)");
        javaMailSender.send(simpleMailMessage);
    }

    public void sendMail(SimpleMailMessage simpleMailMessage[]) {
        logger.info(this.getClass().getCanonicalName() + ".sendMail(SimpleMailMessage simpleMailMessage[])");
        javaMailSender.send(simpleMailMessage);
    }

    public boolean sendConfirmationEmail(final MailMessage mailMessage){
        try{
        MimeMessagePreparator mimeMessagePreparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, BlogConstants.ENCODING_UTF8);
                mimeMessageHelper.setTo(mailMessage.getMailTo());
                mimeMessageHelper.setFrom(mailMessage.getMailFrom());
                mimeMessageHelper.setSubject(mailMessage.getMailSubject());
                mimeMessage.setHeader("Content-Type", "text/html; charset=UTF-8");
                Map<String, Object> stringObjectMap = new HashMap<>();
                stringObjectMap.put("mailMessage", mailMessage);
                String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, BlogConstants.VELOCITY_MAIL_TEMPLATE_FILE_PATH, BlogConstants.ENCODING_UTF8, stringObjectMap);
                mimeMessageHelper.setText(text, true);
            }
        };
        this.javaMailSender.send(mimeMessagePreparator);
        }
        catch (Exception e){
            logger.info(this.getClass().getCanonicalName() + ".sendConfirmationEmail(final MailMessage mailMessage)" + " - error - " + e.getMessage());
            throw e;
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