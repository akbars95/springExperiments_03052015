package com.mtsmda.springCore;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by MTSMDA on 29.05.2015.
 */
public class SpringLivecycle {

    private String name;

    private Double price;

    public SpringLivecycle() {
        System.out.println("SpringLivecycle() constructor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "SpringLivecycle{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @PostConstruct
    public void init(){
        System.out.println("this is INIT method");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("this is DESTROY method");
    }
}