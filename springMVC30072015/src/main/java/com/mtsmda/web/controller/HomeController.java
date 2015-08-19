package com.mtsmda.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/home")
public class HomeController {
	
	@RequestMapping(name = "/welcome/greeting", method = RequestMethod.GET)
	public String greeting(Model model){
		model.addAttribute("greeting", "Welcome to Web Store!");
        model.addAttribute("tagline", "This is tag line...");
		return "welcome";
	}
	
}