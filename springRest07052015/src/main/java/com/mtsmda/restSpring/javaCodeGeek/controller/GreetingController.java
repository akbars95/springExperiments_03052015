package com.mtsmda.restSpring.javaCodeGeek.controller;

import com.mtsmda.restSpring.javaCodeGeek.domain.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by dmitriim on 5/8/2015.
 */
@Controller
public class GreetingController {
    private static final String template = "Hello, %s";
    private final AtomicLong atomicLong = new AtomicLong();

    @RequestMapping(value = "/greeting/{name}", method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(atomicLong.incrementAndGet(), String.format(template, name));
    }

}
