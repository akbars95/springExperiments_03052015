package com.mtsmda.myBlog.controller;

import com.mtsmda.myBlog.email.MailService;
import com.mtsmda.myBlog.model.MessageMail;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by c-DMITMINZ on 5/21/2015.
 */
@Controller
public class EmailSendController {

    private static final Logger logger = Logger.getLogger(EmailSendController.class);

    @Autowired
    private JavaMailSenderImpl mailSender;

    @Autowired
    private VelocityEngine velocityEngine;

    @RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
    public String sendEmail(HttpServletRequest request, ModelMap modelMap) {
        logger.info("input to sendEmail method");
        StringBuilder messageTemplate = new StringBuilder();
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        MessageMail messageMail = new MessageMail();

        if (StringUtils.isNotBlank(request.getParameter("namePerson"))) {
            messageTemplate.append("Name - " + request.getParameter("namePerson"));
            messageMail.setPersonName(request.getParameter("namePerson"));
        }

        if (StringUtils.isNotBlank(request.getParameter("emailPerson"))) {
            messageTemplate.append("Email is - " + request.getParameter("emailPerson"));
            messageMail.setMailFrom(request.getParameter("emailPerson"));
        }

        if (StringUtils.isNotBlank(request.getParameter("phoneNumberPerson"))) {
            messageTemplate.append("Phone number is - " + request.getParameter("phoneNumberPerson"));
            messageMail.setPhoneNumber(request.getParameter("phoneNumberPerson"));
        }

        if (StringUtils.isNotBlank(request.getParameter("subjectMessagePerson"))) {
            messageTemplate.append("Message subject is - " + request.getParameter("subjectMessagePerson"));
            simpleMailMessage.setSubject(request.getParameter("subjectMessagePerson"));
            messageMail.setMailSubject(simpleMailMessage.getSubject());
        }

        if (StringUtils.isNotBlank(request.getParameter("textMessagePerson"))) {
            messageTemplate.append("Message  - " + request.getParameter("textMessagePerson"));
            messageMail.setMailText(request.getParameter("textMessagePerson"));
        }

        logger.info("create message - " + messageTemplate.toString());
        simpleMailMessage.setTo("mynzat.dmitrii.est.computer@gmail.com");
        simpleMailMessage.setText(messageTemplate.toString());

        messageMail.setMailTo("mynzat.dmitrii.est.computer@gmail.com");
        MailService mailService = new MailService(this.mailSender, this.velocityEngine);

        boolean result = false;

        result = mailService.sendConfirmationEmail(messageMail);

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

       return "redirect:/contact_us";
    }

}
