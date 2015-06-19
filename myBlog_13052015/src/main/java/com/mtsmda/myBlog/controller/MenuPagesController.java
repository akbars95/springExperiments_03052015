package com.mtsmda.myBlog.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.mtsmda.myBlog.utils.constants.PageNameUtil.*;

/**
 * Created by dmitriim on 5/13/2015.
 */
@Controller
public class MenuPagesController {

    private static final Logger logger = Logger.getLogger(MenuPagesController.class);

    @RequestMapping(value = INDEX_PAGE_REAL, method = RequestMethod.GET)
    public String indexPage(){
        logger.info("get " + INDEX_PAGE_REAL + " page");
        return INDEX_PAGE;
    }

    @RequestMapping(value = TUTORIAL_PAGE_REAL, method = RequestMethod.GET)
    public String tutorialPage(){
        logger.info("get " + TUTORIAL_PAGE_REAL + " page");
        return TUTORIAL_PAGE;
    }

    @RequestMapping(value = ABOUT_SITE_PAGE_REAL, method = RequestMethod.GET)
    public String aboutSitePage(){
        logger.info("get " + ABOUT_SITE_PAGE_REAL + " page");
        return ABOUT_SITE_PAGE;
    }

    @RequestMapping(value = CONTACT_US_PAGE_REAL, method = RequestMethod.GET)
    public String contactUsPage(){
        logger.info("get " + CONTACT_US_PAGE_REAL + " page");
        return CONTACT_US_PAGE;
    }

}
