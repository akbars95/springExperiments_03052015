package com.mtsmda.web.service.impl;

import com.mtsmda.web.domain.Product;
import com.mtsmda.web.domain.repository.ProductRepository;
import com.mtsmda.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        return productRepository.getProductsByFilter(filterParams);
    }

    public Set<Product> getProductsByFilterAndPrice(List<Map<String, List<String>>> listFilters) {
        return productRepository.getProductsByFilterAndPrice(listFilters);
    }

    public List<Product> getProductsByManufacturer(String manufacturer) {
        return productRepository.getProductsByManufacturer(manufacturer);
    }

    public Set<Product> getProductBetweenPrice(Map<String, List<String>> filterParams) {
        return productRepository.getProductBetweenPrice(filterParams);
    }


}