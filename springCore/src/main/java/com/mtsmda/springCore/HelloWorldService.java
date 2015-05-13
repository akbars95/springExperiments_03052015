package com.mtsmda.springCore;

import org.springframework.stereotype.Service;

/**
 * Created by MTSMDA on 13.05.2015.
 */
@Service(value = "helloWorldService")
public class HelloWorldService {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String sayHello(){
        return "Hello, " + name;
    }
}
