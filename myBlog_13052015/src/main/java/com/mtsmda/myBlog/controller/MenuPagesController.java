package com.mtsmda.myBlog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by dmitriim on 5/13/2015.
 */
@Controller
public class MenuPagesController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String indexPage(){
        return "index";
    }

    @RequestMapping(value = "/tutorial", method = RequestMethod.GET)
    public String tutorialPage(){
        return "tutorial";
    }

    @RequestMapping(value = "/about_site", method = RequestMethod.GET)
    public String aboutSitePage(){
        return "about_site";
    }

    @RequestMapping(value = "/contact_us", method = RequestMethod.GET)
    public String contactUsPage(){
        return "contact_us";
    }

}
