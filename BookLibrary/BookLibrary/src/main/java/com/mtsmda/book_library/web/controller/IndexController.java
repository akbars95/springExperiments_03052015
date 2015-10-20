package com.mtsmda.book_library.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by MTSMDA on 20.10.2015.
 */
@Controller
public class IndexController {

    @RequestMapping(value = {"/, /index"}, method = RequestMethod.GET)
    public String indexPage(ModelAndView modelAndView){
        modelAndView.addObject("pageName","Index");
        return "index";
    }

}