package com.mtsmda.web.controller.mkyoung;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping(value = {"/", "/welcome**"}, method = RequestMethod.GET)
	public ModelAndView welcomePage(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("title", "Spring Security");
		modelAndView.addObject("message", "This is welcome page!");
		modelAndView.setViewName("hello");
		return modelAndView;
	}
	
	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("title", "Spring Security");
		modelAndView.addObject("message", "This is protected page");
		modelAndView.setViewName("admin");
		return modelAndView;
		
	}
	
}
