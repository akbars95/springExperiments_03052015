package com.mtsmda.myBlog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.mtsmda.myBlog.utils.PageNameUtil.*;

/**
 * Created by dmitriim on 5/13/2015.
 */
@Controller
public class MenuPagesController {

    @RequestMapping(value = INDEX_PAGE_REAL, method = RequestMethod.GET)
    public String indexPage(){
        return INDEX_PAGE;
    }

    @RequestMapping(value = TUTORIAL_PAGE_REAL, method = RequestMethod.GET)
    public String tutorialPage(){
        return TUTORIAL_PAGE;
    }

    @RequestMapping(value = ABOUT_SITE_PAGE_REAL, method = RequestMethod.GET)
    public String aboutSitePage(){
        return ABOUT_SITE_PAGE;
    }

    @RequestMapping(value = CONTACT_US_PAGE_REAL, method = RequestMethod.GET)
    public String contactUsPage(){
        return CONTACT_US_PAGE;
    }

}
