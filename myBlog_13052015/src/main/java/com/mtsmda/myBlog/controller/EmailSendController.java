package com.mtsmda.myBlog.controller;

import com.mtsmda.myBlog.dao.CaptchaDAO;
import com.mtsmda.myBlog.email.MailService;
import com.mtsmda.myBlog.model.Captcha;
import com.mtsmda.myBlog.model.MailMessage;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static com.mtsmda.myBlog.utils.PageNameUtil.*;

/**
 * Created by c-DMITMINZ on 5/21/2015.
 */
@RestController
public class EmailSendController {

    private static final Logger logger = Logger.getLogger(EmailSendController.class);

    @Autowired
    private JavaMailSenderImpl mailSender;

    @Autowired
    private VelocityEngine velocityEngine;

    @Autowired
    private CaptchaDAO contactDAO;

    @RequestMapping(value = SEND_EMAIL_PAGE_REAL, method = RequestMethod.POST, produces={"application/json"} )
    public Boolean sendEmail(HttpServletRequest request, ModelMap modelMap) {
        logger.info("input to sendEmail method");
        StringBuilder messageTemplate = new StringBuilder();
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        MailMessage mailMessage = new MailMessage();

        if (StringUtils.isNotBlank(request.getParameter("namePerson"))) {
            messageTemplate.append("Name - " + request.getParameter("namePerson"));
            mailMessage.setPersonName(request.getParameter("namePerson"));
        }

        if (StringUtils.isNotBlank(request.getParameter("emailPerson"))) {
            messageTemplate.append("Email is - " + request.getParameter("emailPerson"));
            mailMessage.setMailFrom(request.getParameter("emailPerson"));
        }

        if (StringUtils.isNotBlank(request.getParameter("phoneNumberPerson"))) {
            messageTemplate.append("Phone number is - " + request.getParameter("phoneNumberPerson"));
            mailMessage.setPhoneNumber(request.getParameter("phoneNumberPerson"));
        }

        if (StringUtils.isNotBlank(request.getParameter("subjectMessagePerson"))) {
            messageTemplate.append("Message subject is - " + request.getParameter("subjectMessagePerson"));
            simpleMailMessage.setSubject(request.getParameter("subjectMessagePerson"));
            mailMessage.setMailSubject(simpleMailMessage.getSubject());
        }

        if (StringUtils.isNotBlank(request.getParameter("textMessagePerson"))) {
            messageTemplate.append("Message  - " + request.getParameter("textMessagePerson"));
            mailMessage.setMailText(request.getParameter("textMessagePerson"));
        }

        logger.info("create message - " + messageTemplate.toString());
        simpleMailMessage.setTo("mynzat.dmitrii.est.computer@gmail.com");
        simpleMailMessage.setText(messageTemplate.toString());

        mailMessage.setMailTo("mynzat.dmitrii.est.computer@gmail.com");
        MailService mailService = new MailService(this.mailSender, this.velocityEngine);

        boolean result = false;

        result = mailService.sendConfirmationEmail(mailMessage);


       /*
        try {
            MailService mailService = new MailService(mailSender);
            mailService.sendMail(simpleMailMessage);
            result = true;
            logger.info(result ? "send message successful": "error");
        }
        catch (Exception e){
            logger.error("error sending mail");
        }*/
        logger.info(result ? "Message successfully send" : "Message error!");
       return result;
    }

    @RequestMapping(value = UPDATE_CAPTCHA_PAGE_REAL, method = RequestMethod.GET, produces={"application/json"} )
    public Captcha getRandomCaptcha(){
        logger.info("get " + UPDATE_CAPTCHA_PAGE_REAL + " ws page");
        Captcha captcha = this.contactDAO.getRandomCaptcha();
        logger.info("get captcha object " + captcha);
        captcha.setValueCaptcha("");
        logger.info("removed value captcha");
        return captcha;
    }

}
