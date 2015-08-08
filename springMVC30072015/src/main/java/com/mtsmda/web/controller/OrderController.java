package com.mtsmda.web.controller;

import com.mtsmda.web.domain.Product;
import com.mtsmda.web.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by c-DMITMINZ on 03.08.2015.
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/order/P15025/5")
    public String process(Model model){
        List<Product> products = new ArrayList<Product>();
        products.add(orderService.processOrder("15025", 5));
        model.addAttribute("products", products);
        return "products";/*redirect:*/
    }

}