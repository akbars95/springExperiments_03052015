package com.mtsmda.web.service;

import com.mtsmda.web.domain.Product;

import java.util.List;

/**
 * Created by c-DMITMINZ on 04.08.2015.
 */
public interface ProductService {

    public List<Product> getAllProducts();

    public Product getProductByID(String productID);

    public List<Product> getProductByCategory(String category);

}