package com.mtsmda.souvenir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mtsmda.souvenir.model.Captcha;
import com.mtsmda.souvenir.service.CaptchaService;

@RestController
public class CaptchaController {

	@Autowired
	@Qualifier("captchaService")
	private CaptchaService captchaService;

	@RequestMapping(value = "/update_captcha", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Captcha getRandomCaptcha(@RequestBody Captcha captchaFromClient) {
		if(captchaFromClient != null && captchaFromClient.getCaptchaId() == null){
			captchaFromClient.setCaptchaId(new Double(Math.random() * 20).intValue());
		}
		Captcha randomCaptcha = captchaService.getRandomCaptcha(captchaFromClient);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return randomCaptcha;
	}

}