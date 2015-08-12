package com.mtsmda.web.domain.repository;

import com.mtsmda.web.domain.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by MTSMDA on 03.08.2015.
 */
public interface ProductRepository {

    public List<Product> getProducts();

    public Product getProductById(String productID);

    public List<Product> getProductByCategory(String category);

    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);

    public Set<Product> getProductsByFilterAndPrice(List<Map<String, List<String>>> listFilters);

    public List<Product> getProductsByManufacturer(String manufacturer);

    public Set<Product> getProductBetweenPrice(Map<String, List<String>> filterParams);

}