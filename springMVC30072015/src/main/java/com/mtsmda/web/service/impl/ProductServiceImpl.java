package com.mtsmda.web.service.impl;

import com.mtsmda.web.domain.Product;
import com.mtsmda.web.domain.repository.ProductRepository;
import com.mtsmda.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by c-DMITMINZ on 04.08.2015.
 */
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.getProducts();
    }

    public Product getProductByID(String productID) {
        return productRepository.getProductById(productID);
    }

    public List<Product> getProductByCategory(String category) {
        return productRepository.getProductByCategory(category);
    }
}