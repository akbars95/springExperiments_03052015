package com.mtsmda.web.service;

import com.mtsmda.web.domain.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by c-DMITMINZ on 04.08.2015.
 */
public interface ProductService {

    public List<Product> getAllProducts();

    public Product getProductByID(String productID);

    public List<Product> getProductByCategory(String category);

    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);

    public Set<Product> getProductsByFilterAndPrice(List<Map<String, List<String>>> listFilters);

}