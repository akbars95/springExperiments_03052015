package com.mtsmda.web.service;

import com.mtsmda.web.domain.Product;

/**
 * Created by c-DMITMINZ on 03.08.2015.
 */
public interface OrderService {

    public Product processOrder(String productID, long count);

}
