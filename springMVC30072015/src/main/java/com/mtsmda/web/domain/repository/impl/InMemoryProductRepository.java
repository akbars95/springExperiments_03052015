package com.mtsmda.web.domain.repository.impl;

import com.mtsmda.web.domain.Product;
import com.mtsmda.web.domain.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MTSMDA on 03.08.2015.
 */
@Repository
public class InMemoryProductRepository implements ProductRepository{

    private List<Product> products = new ArrayList<Product>();

    public InMemoryProductRepository() {
        Product productIphone = new Product("15023", "Iphone 5s", new BigDecimal(550));
        productIphone.setDescription("Apple	iPhone	5s	smartphone	with	4.00-inch 640x1136	display	and	8-megapixel	rear camera");
        productIphone.setCategory("Smart	Phone");
        productIphone.setManufacturer("Apple");
        productIphone.setUnitsInStock(1000);

        Product productLenovoK900 = new Product("15025", "Lenovo K900", new BigDecimal(350));
        productLenovoK900.setDescription("Lenovo K900 smartphone with 5.00-inch 960x1280 display and 8-megapixel rear camera");
        productLenovoK900.setCategory("Smart Phone");
        productLenovoK900.setManufacturer("Lenovo");
        productLenovoK900.setUnitsInStock(500);

        products.add(productIphone);
        products.add(productLenovoK900);
    }

    public List<Product> getProducts() {
        return products;
    }
}