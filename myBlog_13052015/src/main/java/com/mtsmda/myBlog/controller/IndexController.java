package com.mtsmda.myBlog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by dmitriim on 5/14/2015.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/header.jsp", method = RequestMethod.GET)
    public String header(){
        return "piece/header";
    }

    @RequestMapping(value = "/jsCss.jsp", method = RequestMethod.GET)
    public String jsCss(){
        return "piece/jsCss";
    }

    @RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
    public String index(){
        return "index";
    }

}
