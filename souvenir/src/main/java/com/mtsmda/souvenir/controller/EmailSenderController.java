package com.mtsmda.souvenir.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmailSenderController {

	@Autowired
	@Qualifier("mailSender")
	private JavaMailSender mailSender;

	@RequestMapping(value = "/sendemail", method = RequestMethod.POST)
	public String emailSend(HttpServletRequest request) {

		return "";
	}

}