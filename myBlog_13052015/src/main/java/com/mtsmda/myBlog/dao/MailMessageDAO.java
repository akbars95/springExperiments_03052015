package com.mtsmda.myBlog.dao;

import com.mtsmda.myBlog.model.Captcha;
import com.mtsmda.myBlog.model.MailMessage;

import java.util.List;

/**
 * Created by c-DMITMINZ on 6/16/2015.
 */
public interface MailMessageDAO {

    public void saveOrUpdateMailMessage(MailMessage mailMessage);

    public void deleteMailMessage(Integer mailMessageId);

    public MailMessage getMailMessage(Integer mailMessageId);

    public List<MailMessage> getAllMailMessage();

}