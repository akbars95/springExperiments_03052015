package com.mtsmda.web.domain.repository;

import com.mtsmda.web.domain.Product;

import java.util.List;

/**
 * Created by MTSMDA on 03.08.2015.
 */
public interface ProductRepository {

    public List<Product> getProducts();

    public Product getProductById(String productID);

    public List<Product> getProductByCategory(String category);

}