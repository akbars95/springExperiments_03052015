package com.mtsmda.myBlog.controller;

import com.mtsmda.myBlog.dao.CaptchaDAO;
import com.mtsmda.myBlog.dao.MailMessageDAO;
import com.mtsmda.myBlog.email.MailService;
import com.mtsmda.myBlog.model.Captcha;
import com.mtsmda.myBlog.model.MailMessage;
import com.mtsmda.myBlog.utils.ErrorExceptionUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import static com.mtsmda.myBlog.utils.constants.PageNameUtil.*;

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
    private CaptchaDAO captchaDAO;

    @Autowired
    private MailMessageDAO mailMessageDAO;

    @RequestMapping(value = SEND_EMAIL_PAGE_REAL, method = RequestMethod.POST, produces = {"application/json"})
    public ErrorExceptionUtil sendEmail(HttpServletRequest request, ModelMap modelMap) {
        logger.info("input to sendEmail method");

        ErrorExceptionUtil errorExceptionUtil = new ErrorExceptionUtil();

        StringBuilder messageTemplate = new StringBuilder();
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        MailMessage mailMessage = new MailMessage();

        if (StringUtils.isNotBlank(request.getParameter("captcha")) && StringUtils.isNotBlank(request.getParameter("imageID"))) {
            String captcha = request.getParameter("captcha");
            Integer imageID = Integer.parseInt(request.getParameter("imageID"));
            Captcha captchaFromDB = captchaDAO.getCaptcha(imageID);
            if (captcha.length() == 11) {
                if (!captchaFromDB.getValueCaptcha().equals(captcha)) {
                    errorExceptionUtil.setErrorOrExceptionAndDescription(true, "captchaNotEquals");
                    return errorExceptionUtil;
                }
            }else{
                errorExceptionUtil.setErrorOrExceptionAndDescription(true, "captchaNotLength11");
                return errorExceptionUtil;
            }
        }



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

        if (StringUtils.isNotBlank(request.getParameter("currentTimeByUser"))) {
            String currentTimeByUser = request.getParameter("currentTimeByUser");
            messageTemplate.append("Message  - " + currentTimeByUser);/*  */
            GregorianCalendar gregorianCalendar = new GregorianCalendar(Integer.parseInt(currentTimeByUser.substring(6, 10)), Integer.parseInt(currentTimeByUser.substring(3, 5)), Integer.parseInt(currentTimeByUser.substring(0, 2)),
                    Integer.parseInt(currentTimeByUser.substring(11, 13)), Integer.parseInt(currentTimeByUser.substring(14, 16)), Integer.parseInt(currentTimeByUser.substring(17, 19)));
            mailMessage.setSendDatePerson(gregorianCalendar);
        }

        logger.info("create message - " + messageTemplate.toString());

        simpleMailMessage.setTo("mynzat.dmitrii.est.computer@gmail.com");
        simpleMailMessage.setText(messageTemplate.toString());

        mailMessage.setMailTo("mynzat.dmitrii.est.computer@gmail.com");
        MailService mailService = new MailService(this.mailSender, this.velocityEngine);

        boolean result = false;

        try {
            result = mailService.sendConfirmationEmail(mailMessage);
            logger.info("send email successful");
        } catch (Exception e) {
            mailMessage.setErrorOrException(e.getMessage());
            logger.error("send email error - " + e.getMessage());
        }

        mailMessageDAO.saveOrUpdateMailMessage(mailMessage);
        logger.info("insert mail in database");

        logger.info(result ? "Message successfully send" : "Message error!");
        errorExceptionUtil.setErrorOrExceptionAndDescription(result, (mailMessage.getErrorOrException() == null ? "" : mailMessage.getErrorOrException()));
        return errorExceptionUtil;
    }

    @RequestMapping(value = UPDATE_CAPTCHA_PAGE_REAL, method = RequestMethod.GET, produces = {"application/json"})
    public Captcha getRandomCaptcha() {
        logger.info("get " + UPDATE_CAPTCHA_PAGE_REAL + " ws page");
        Captcha captcha = this.captchaDAO.getRandomCaptcha();
        logger.info("get captcha object " + captcha);
        captcha.setValueCaptcha("");
        logger.info("removed value captcha");
        return captcha;
    }

}
