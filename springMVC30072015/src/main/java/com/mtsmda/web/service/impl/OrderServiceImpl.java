package com.mtsmda.web.service.impl;

import com.mtsmda.web.domain.Product;
import com.mtsmda.web.domain.repository.ProductRepository;
import com.mtsmda.web.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by c-DMITMINZ on 03.08.2015.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductRepository productRepository;

    public Product processOrder(String productID, long count) {
        Product product = productRepository.getProductById(productID);

        if (product.getUnitsInStock() < count) {
            throw new IllegalArgumentException("Out of Stock. Available Units is stock " + product.getUnitsInOrder());
        }
        product.setUnitsInOrder(product.getUnitsInStock() - count);
        return product;
    }
}