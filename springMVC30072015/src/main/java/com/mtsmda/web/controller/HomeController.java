package com.mtsmda.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/home")
public class HomeController {
	
	private static final String REDIRECT = "redirect:";
	private static final String FORWARD = "forward:";
	
	@RequestMapping(value = "/welcome/Fgreeting", method = RequestMethod.GET)
	public String forwardGreeting(Model model){
		model.addAttribute("say_hello", FORWARD + " Hello!");
		return FORWARD + "hello";
	}
	
	@RequestMapping(value = "/welcome/Rgreeting", method = RequestMethod.GET)
	public String redirectGreeting(Model model){
		model.addAttribute("say_hello", REDIRECT + " Hello!");
		return REDIRECT + "hello";
	}
	
	@RequestMapping(value = "/welcome/hello", method = RequestMethod.GET)
	public String hello(Model model){
		model.addAttribute("say_hello", "Hello!");
		return "hello";
	}
	
	@RequestMapping(value = "/welcome/google", method = RequestMethod.GET)
	public String redirectToGoogle(){
		return REDIRECT + "https://www.google.com/";
	}
	
	@RequestMapping(value = "/welcome/Fgoogle", method = RequestMethod.GET)
	public String forwardToGoogle(){
		return FORWARD + "https://www.google.com/";
	}
	
}