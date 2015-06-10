package com.mtsmda.controller;

import com.mtsmda.dao.ContactDAO;
import com.mtsmda.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
/*import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;*/
import java.util.List;

/**
 * Created by c-DMITMINZ on 6/3/2015.
 */
/*
@Controller
@Path("/rf")
*/
@RestController
public class HomeController {

    @Autowired(required = false)
    @Qualifier(value = "contactDAOImplSP")
    private ContactDAO contactDAO;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView listContact(ModelAndView modelAndView){

        /*get by id*/
        /*Contact contact = contactDAO.getContact(2);
        modelAndView.addObject("listContact", contact);*/

        List<Contact> contacts = contactDAO.getContacts();
        modelAndView.addObject("listContact", contacts);

        /*insert*/
        /*Contact contact = new Contact();
        contact.setTelephone("079 389 982");
        contact.setAddress("Kiev drugoi rayon");
        contact.setEmail("petrov.petr@microsoft.com");
        contact.setName("Petrov Petr Petrovic");*/
        /*update*/
        /*contact.setId(4);*/

        /*contactDAO.saveOrUpdate(contact);*/


        /*delete*/
      /*  Contact contact = new Contact();
        contact.setId(8);
        contactDAO.delete(contact.getId());*/

        modelAndView.addObject("hi", "hello my friend");
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @RequestMapping(value = "/home3/{name}", method = RequestMethod.GET, produces={"application/json"})
    public List<Contact> listContactRF2(@PathVariable String name){

       List<Contact> contacts = contactDAO.getContacts();
        Contact contact = new Contact();
        contact.setName(name);
        contacts.add(0, contact);
        return contacts;
    }

    @RequestMapping(value = "/home4/{name}", method = RequestMethod.GET, produces={"application/json"} )
    public String listContactRF23(@PathVariable String name){
        return "Name - " + name;
    }

    /*@GET
    @Path("json/contacts")
    @Produces("application/json")*/
    @RequestMapping(value = "/home9", method = RequestMethod.GET, produces={"application/json"} )
    public List<Contact> listContactRF(){
        List<Contact> contacts = contactDAO.getContacts();
        return contacts;
    }

    /*@RequestMapping(value = "/newContact", method = RequestMethod.GET)
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
    }*/
}