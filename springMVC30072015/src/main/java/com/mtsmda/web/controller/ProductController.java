package com.mtsmda.web.controller;

import com.mtsmda.web.domain.Product;
import com.mtsmda.web.domain.repository.ProductRepository;
import com.mtsmda.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by MTSMDA on 03.08.2015.
 */
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/products")
    public String list(Model model) {
        model.addAttribute("products", productService.getAllProducts());

        return "products";
    }

    @RequestMapping(value = "/products/{category}")
    public String getProductsByCategory(Model model, @PathVariable(value = "category") String productCategory) {

        model.addAttribute("products", productService.getProductByCategory(productCategory));

        return "products";
    }

    @RequestMapping(value = "/filter/{ByCriteria}")
    public String getProductsByFIlter(@MatrixVariable(pathVar = "ByCriteria") Map<String, List<String>> filterParams, Model model) {
        model.addAttribute("products", productService.getProductsByFilter(filterParams));
        return "products";
    }

    @RequestMapping(value = "/filter/{ByCriteria}/{Price}")
    public String getProductsByFIlterAndPrice(@MatrixVariable(pathVar = "ByCriteria") Map<String, List<String>> filterParams, @MatrixVariable(pathVar = "Price") Map<String, List<String>> filterPrice, Model model) {
        List<Map<String, List<String>>> filtersList = new ArrayList<Map<String, List<String>>>();
        filtersList.add(filterParams);
        filtersList.add(filterPrice);
        model.addAttribute("products", productService.getProductsByFilterAndPrice(filtersList));
        return "products";
    }

    @RequestMapping(value = "/product")
    public String getProductById(@RequestParam("id") String productId, Model model) {
        model.addAttribute("product", productService.getProductByID(productId));
        return "product";
    }

    @RequestMapping(value = "/productByIdAndCategory")
    public String getProductById2Param(@RequestParam("id") String productId, @RequestParam("category") String category, Model model) {
        Set<Product> productSet = new HashSet<Product>();
        productSet.add(productService.getProductByID(productId));
        productSet.add(productService.getProductByCategory(category).get(0));

        model.addAttribute("product", productSet.iterator().next());
        return "product";
    }

}