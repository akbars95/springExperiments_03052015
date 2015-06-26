package com.mtsmda.myBlog.dao;

import com.mtsmda.myBlog.model.Captcha;

import java.util.List;

/**
 * Created by c-DMITMINZ on 6/11/2015.
 */
public interface CaptchaDAO {

    public void saveOrUpdateCaptcha(Captcha captcha);

    public void deleteCaptcha(Integer captchaId);

    public Captcha getCaptcha(Integer captchaId);

    public List<Captcha> getAllCaptcha();


    public Captcha getRandomCaptcha();

    public boolean checkCaptcha(String captcha);

}
