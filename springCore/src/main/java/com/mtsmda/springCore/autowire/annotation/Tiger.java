package com.mtsmda.springCore.autowire.annotation;

import com.mtsmda.springCore.autowire.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by MTSMDA on 03.06.2015.
 */
public class Tiger {

    private String name;

    /*@Autowired*/
    private Color color;

    public Tiger() {

    }

    /*@Autowired*/
    public Tiger(Color color) {
        this.color = color;
    }

    public Tiger(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    @Autowired(required = false)
    @Qualifier(value = "color2")
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Tiger{" +
                "name='" + name + '\'' +
                ", color=" + color +
                '}';
    }
}