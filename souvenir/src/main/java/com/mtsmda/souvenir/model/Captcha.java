package com.mtsmda.souvenir.model;

import java.io.Serializable;

/**
 * Created by c-DMITMINZ on 04.02.2016.
 */
public class Captcha implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer captchaId;
	private String captchaValue;
	private String captchaUrlFile;

	public Captcha() {

	}

	public Captcha(String captchaValue, String captchaUrlFile) {
		this.setCaptchaUrlFile(captchaUrlFile);
		this.setCaptchaValue(captchaValue);
	}

	public Integer getCaptchaId() {
		return captchaId;
	}

	public void setCaptchaId(Integer captchaId) {
		this.captchaId = captchaId;
	}

	public String getCaptchaValue() {
		return captchaValue;
	}

	public void setCaptchaValue(String captchaValue) {
		this.captchaValue = captchaValue;
	}

	public String getCaptchaUrlFile() {
		return captchaUrlFile;
	}

	public void setCaptchaUrlFile(String captchaUrlFile) {
		this.captchaUrlFile = captchaUrlFile;
	}

}