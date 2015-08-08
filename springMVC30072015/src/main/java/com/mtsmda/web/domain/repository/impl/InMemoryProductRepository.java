package com.mtsmda.web.domain.repository.impl;

import com.mtsmda.web.domain.Product;
import com.mtsmda.web.domain.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by MTSMDA on 03.08.2015.
 */
@Repository
class InMemoryProductRepository implements ProductRepository {

    private List<Product> products = new ArrayList<Product>();

    public InMemoryProductRepository() {
        Product productIphone = new Product("15023", "Iphone 5s", new BigDecimal(550));
        productIphone.setDescription("Apple	iPhone	5s	smartphone	with	4.00-inch 640x1136	display	and	8-megapixel	rear camera");
        productIphone.setCategory("Smart Phone");
        productIphone.setManufacturer("Apple");
        productIphone.setUnitsInStock(1000);

        Product productLenovoK900 = new Product("15025", "Lenovo K900", new BigDecimal(350));
        productLenovoK900.setDescription("Lenovo K900 smartphone with 5.00-inch 960x1280 display and 8-megapixel rear camera");
        productLenovoK900.setCategory("Smart Phone");
        productLenovoK900.setManufacturer("Lenovo");
        productLenovoK900.setUnitsInStock(500);

        Product productPCEverest = new Product("15035", "Everest 2000", new BigDecimal(950));
        productPCEverest.setDescription("PC Everest 2000");
        productPCEverest.setCategory("PC");
        productPCEverest.setManufacturer("Everest");
        productPCEverest.setUnitsInStock(10);

        products.add(productIphone);
        products.add(productLenovoK900);
        products.add(productPCEverest);
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductById(String productID) {
        Product productResult = null;

        for (Product product : products) {
            if (product != null && product.getProductId() != null && product.getProductId().equals(productID)) {
                productResult = product;
            }
        }

        if (productResult == null) {
            throw new IllegalArgumentException("No product found with the product id: " + productID);
        }

        return productResult;
    }

    public List<Product> getProductByCategory(String category) {
        List<Product> products = new ArrayList<Product>();

        for (Product product : getProducts()) {
            if (category.equals(product.getCategory())) {
                products.add(product);
            }
        }

        return products;
    }

    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        Set<Product> productsToReturn = new HashSet<Product>();

        filterProcess(filterParams, productsToReturn);

        return productsToReturn;
    }

    public Set<Product> getProductsByFilterAndPrice(List<Map<String, List<String>>> listFilters) {
        Set<Product> productsToReturn = new HashSet<Product>();

        if (listFilters.isEmpty()) {
            return null;
        }

        for (Map<String, List<String>> current : listFilters) {
            filterProcess(current, productsToReturn);
        }


        return productsToReturn;
    }

    private void filterProcess(Map<String, List<String>> filterParams, Set<Product> productsToReturn) {
        Set<String> criterias = filterParams.keySet();

        if (criterias.contains("brand")) {
            for (String brandname : filterParams.get("brand")) {
                for (Product product : getProducts()) {
                    if (brandname.equals(product.getManufacturer())) {
                        productsToReturn.add(product);
                    }
                }
            }
        }

        if (criterias.contains("category")) {
            for (String category : filterParams.get("category")) {
                productsToReturn.addAll(this.getProductByCategory(category));
            }
        }

        if (criterias.contains("price")) {
            for (String price : filterParams.get("price")) {
                for (Product product : getProducts()) {
                    BigDecimal bigDecimalPrice = new BigDecimal(price);
                    if (bigDecimalPrice.doubleValue() < product.getUnitPrice().doubleValue()) {
                        productsToReturn.add(product);
                    }
                }
            }
        }
    }


}