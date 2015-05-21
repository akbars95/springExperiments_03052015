package com.mtsmda.myBlog.controller;

import com.mtsmda.myBlog.email.MailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by c-DMITMINZ on 5/21/2015.
 */
@Controller
public class EmailSendController {

    @RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
    public String sendEmail(HttpServletRequest request) {
        StringBuilder messageTemplate = new StringBuilder();
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        if (StringUtils.isEmpty(request.getParameter("namePerson"))) {
            messageTemplate.append("Name - " + request.getParameter("namePerson"));
        }

        if (StringUtils.isEmpty(request.getParameter("emailPerson"))) {
            messageTemplate.append("Email is - " + request.getParameter("emailPerson"));
        }

        if (StringUtils.isEmpty(request.getParameter("phoneNumberPerson"))) {
            messageTemplate.append("Phone number is - " + request.getParameter("phoneNumberPerson"));
        }

        if (StringUtils.isEmpty(request.getParameter("subjectMessagePerson"))) {
            messageTemplate.append("Message subject is - " + request.getParameter("subjectMessagePerson"));
            simpleMailMessage.setSubject(request.getParameter("subjectMessagePerson"));
        }

        if (StringUtils.isEmpty(request.getParameter("textMessagePerson"))) {
            messageTemplate.append("Message  - " + request.getParameter("textMessagePerson"));
        }


        simpleMailMessage.setTo("mynzat.dmitrii.est.computer@gmail.com");
        simpleMailMessage.setText(messageTemplate.toString());

        MailService mailService = new MailService();
        boolean result = mailService.sendMail(simpleMailMessage);
        System.out.println(result);

        return "redirect:/contact_us";
    }

}
