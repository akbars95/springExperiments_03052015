package com.mtsmda.souvenir.controller;

import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.InputStreamSource;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.web.bind.annotation.*;

import com.mtsmda.souvenir.model.Message;
import com.mtsmda.souvenir.service.MessageService;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class EmailSenderController {

    private Logger logger = Logger.getLogger(getClass());

    @Autowired
    @Qualifier("mailSender")
    private JavaMailSender mailSender;

    @Autowired
    @Qualifier("messageService")
    private MessageService messageService;

    @Autowired
    @Qualifier("velocityEngine")
    private VelocityEngine velocityEngine;

    @RequestMapping(value = "/sendemail", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean emailSend(@RequestBody Message message) {
        logger.info("new message - " + message.toString());
        System.out.println(message);
        boolean insertMessage = messageService.insertMessage(message);
        /*insertMessage = false;
        if (!insertMessage) {
            throw new RuntimeException("Error");
        }*/
        return insertMessage;
    }

    @RequestMapping(value = "/sendemailWithFile", method = RequestMethod.POST)
    public String sendEmail(@RequestParam(value = "messageName", required = false) String messageName,
                            @RequestParam(value = "messageEmail", required = false) String messageEmail,
                            @RequestParam(value = "messageText", required = false) String messageText,
                            @RequestParam(value = "messageCaptcha", required = false) String messageCaptcha/*,
                            final @RequestParam CommonsMultipartFile attachFile*/) {


        System.out.println(messageName + " - " + messageCaptcha);
        /*SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(mail.getMailFrom());
        message.setTo(mail.getMailTo());
        message.setSubject(mail.getMailSubject());

        Template template = velocityEngine.getTemplate("./templates/" + mail.getTemplateName());

        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("firstName", "Yashwant");
        velocityContext.put("lastName", "Chavan");
        velocityContext.put("location", "Pune");

        StringWriter stringWriter = new StringWriter();

        template.merge(velocityContext, stringWriter);

        message.setText(stringWriter.toString());

        mailSender.send(message);*/



        /*final String emailTo = request.getParameter("mailTo");
        final String subject = request.getParameter("subject");
        final String message = request.getParameter("message");

        // for logging
        System.out.println("emailTo: " + emailTo);
        System.out.println("subject: " + subject);
        System.out.println("message: " + message);
        System.out.println("attachFile: " + attachFile.getOriginalFilename());*/

        /*mailSender.send(new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper messageHelper = new MimeMessageHelper(
                        mimeMessage, true, "UTF-8");
                messageHelper.setTo(emailTo);
                messageHelper.setSubject(subject);
                messageHelper.setText(message);

                // determines if there is an upload file, attach it to the e-mail
                String attachName = attachFile.getOriginalFilename();
                if (!attachFile.equals("")) {

                    messageHelper.addAttachment(attachName, new InputStreamSource() {

                        @Override
                        public InputStream getInputStream() throws IOException {
                            return attachFile.getInputStream();
                        }
                    });
                }

            }

        });*/

        return "Result";
    }

}