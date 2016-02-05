package com.mtsmda.souvenir.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mtsmda.souvenir.model.Message;
import com.mtsmda.souvenir.service.MessageService;

@RestController
public class EmailSenderController {

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	@Qualifier("mailSender")
	private JavaMailSender mailSender;

	@Autowired
	@Qualifier("messageService")
	private MessageService messageService;

	@RequestMapping(value = "/sendemail", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean emailSend(@RequestBody Message message) {
		logger.info("new message - " + message.toString());
		System.out.println(message);
		boolean insertMessage = messageService.insertMessage(message);
		insertMessage = false;
		if(!insertMessage){
			throw new RuntimeException("Error");	
		}
		return insertMessage;
	}

}