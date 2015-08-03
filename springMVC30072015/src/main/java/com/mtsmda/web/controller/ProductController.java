package com.mtsmda.web.controller;

import com.mtsmda.web.domain.Product;
import com.mtsmda.web.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

/**
 * Created by MTSMDA on 03.08.2015.
 */
@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/products")
    public String getAllProducts(Model model) {
        model.addAttribute("products", productRepository.getProducts());

        return "products";
    }

}