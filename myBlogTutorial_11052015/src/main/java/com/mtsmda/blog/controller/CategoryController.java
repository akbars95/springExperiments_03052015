package com.mtsmda.blog.controller;

import com.mtsmda.blog.bd.model.Category;
import com.mtsmda.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by dmitriim on 5/12/2015.
 */
@Controller
public class CategoryController {

    /*@Autowired
    private CategoryService categoryService;*/

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String addCategory(){
       /* boolean result = categoryService.save(category);*/

        return "index";
    }

}
