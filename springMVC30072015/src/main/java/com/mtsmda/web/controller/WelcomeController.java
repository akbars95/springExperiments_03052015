package com.mtsmda.web.controller;

import com.mtsmda.web.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by c-DMITMINZ on 31.07.2015.
 */
@Controller
public class WelcomeController {

    @RequestMapping(value = "/")
    public String welcome(Model model) {
        model.addAttribute("greeting", "Welcome to Web Store!");
        model.addAttribute("tagline", "This is tag line...");
        model.addAttribute("user", new User("Ivanov", "Ivan"));
        return "welcome";
    }

}