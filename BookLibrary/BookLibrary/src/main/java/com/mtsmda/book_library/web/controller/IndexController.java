package com.mtsmda.book_library.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mtsmda.book_library.web.model.BookLanguage;
import com.mtsmda.book_library.web.service.BookLanguageService;

/**
 * Created by MTSMDA on 20.10.2015.
 */
@Controller
public class IndexController {

	private BookLanguageService bookLanguageService;
	
	@Autowired(required = true)
	@Qualifier(value = "bookLanguageService")
    public void setBookLanguageService(BookLanguageService bookLanguageService) {
		this.bookLanguageService = bookLanguageService;
	}



	@RequestMapping(value = {"/, /index"}, method = RequestMethod.GET)
    public String indexPage(ModelAndView modelAndView){
		BookLanguage bookLanguage = new BookLanguage();
		bookLanguage.setBookLanguage("en");
		
		BookLanguage bookLanguageRU = new BookLanguage();
		bookLanguage.setBookLanguage("ru");
		
		boolean insertBookLanguage = bookLanguageService.insertBookLanguage(bookLanguage);
		boolean insertBookLanguage2 = bookLanguageService.insertBookLanguage(bookLanguageRU);
		
        modelAndView.addObject("pageName","Index");
        modelAndView.addObject("bookLangEN", insertBookLanguage);
        modelAndView.addObject("bookLangRU", insertBookLanguage2);
        return "index";
    }

}