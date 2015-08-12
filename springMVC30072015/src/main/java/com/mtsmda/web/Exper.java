package com.mtsmda.web;

import com.mtsmda.web.domain.Product;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by c-DMITMINZ on 12.08.2015.
 */
public class Exper {

    public static void main(String[] args) {
        Set<Product> products = new HashSet<Product>();
        Set<Product> products2 = new HashSet<Product>();

        Product product = new Product("1515", "Name1", new BigDecimal(153.15));
        Product product2 = new Product("2515", "Name2", new BigDecimal(253.15));
        Product product3 = new Product("3515", "Name3", new BigDecimal(353.15));
        Product product4 = new Product("4515", "Name4", new BigDecimal(453.15));
        Product product5 = new Product("5515", "Name5", new BigDecimal(553.15));

        products.add(product);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);

        products2.add(product4);
        products2.add(product5);
        products2.retainAll(products);

        for(Product product1 : products){
            System.out.println(product1);
        }

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

        Set<Product> productSet1 = new HashSet<Product>();
        productSet1.add(productIphone);

        Set<Product> productSet2 = new HashSet<Product>();
        productSet2.add(productIphone);
        productSet2.add(productLenovoK900);
        productSet2.add(productPCEverest);
//        productSet2.retainAll(productSet1);
        productSet2.removeAll(productSet1);
//        System.out.println(productSet1.addAll(productSet2));
        System.out.println("\n\n\n\n");
        for(Product product1 : productSet1){
            System.out.println(product1);
        }





    }


}