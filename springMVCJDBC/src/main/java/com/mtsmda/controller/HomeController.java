package com.mtsmda.controller;

import com.mtsmda.dao.ContactDAO;
import com.mtsmda.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by c-DMITMINZ on 6/3/2015.
 */

public class HomeController {

    @Autowired
    private ContactDAO contactDAO;

    @RequestMapping(value = "/")
    public ModelAndView listContact(ModelAndView modelAndView){
        List<Contact> contacts = contactDAO.getContacts();
        modelAndView.addObject("listContact", contacts);
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @RequestMapping(value = "/newContact", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView modelAndView){
        Contact contact = new Contact();
        modelAndView.addObject("contact", contact);
        modelAndView.setViewName("contactForm");
        return modelAndView;
    }

    @RequestMapping(value = "/saveContact", method = RequestMethod.POST)
    public ModelAndView saveContact(@ModelAttribute Contact contact){
        contactDAO.saveOrUpdate(contact);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
    public ModelAndView deleteContact(HttpServletRequest request){
        int contactId = Integer.parseInt(request.getParameter("id"));
        contactDAO.delete(contactId);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/editContact", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request){
        int contactId = Integer.parseInt(request.getParameter("id"));
        Contact contact = contactDAO.getContact(contactId);

        ModelAndView modelAndView = new ModelAndView("contactForm");
        modelAndView.addObject("contact", contact);
        return modelAndView;
    }
}