package com.mtsmda.myBlog.utils.constants;

/**
 * Created by c-DMITMINZ on 6/10/2015.
 */
public interface PageNameUtil {

    public static final String SITE_SEPARATOR = "/";
    public static final String REDIRECT = "redirect:";


    /*main menu static pages*/
    public static final String INDEX_PAGE = "index";
    public static final String TUTORIAL_PAGE = "tutorial";
    public static final String ABOUT_SITE_PAGE = "about_site";
    public static final String CONTACT_US_PAGE = "contact_us";

    public static final String INDEX_PAGE_REAL = SITE_SEPARATOR + INDEX_PAGE;
    public static final String TUTORIAL_PAGE_REAL = SITE_SEPARATOR + TUTORIAL_PAGE;
    public static final String ABOUT_SITE_PAGE_REAL = SITE_SEPARATOR + ABOUT_SITE_PAGE;
    public static final String CONTACT_US_PAGE_REAL = SITE_SEPARATOR + CONTACT_US_PAGE;

    /*captcha*/
    public static final String UPDATE_CAPTCHA_PAGE = "updateCaptcha";
    public static final String UPDATE_CAPTCHA_PAGE_REAL = SITE_SEPARATOR + UPDATE_CAPTCHA_PAGE;

    /*send email*/
    public static final String SEND_EMAIL_PAGE = "sendEmail";
    public static final String SEND_EMAIL_PAGE_REAL = SITE_SEPARATOR + SEND_EMAIL_PAGE;
}