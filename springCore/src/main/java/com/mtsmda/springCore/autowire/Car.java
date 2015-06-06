package com.mtsmda.springCore.autowire;

/**
 * Created by MTSMDA on 02.06.2015.
 */
public class Car {

    private String model;
    private Color color;

    public Car() {

    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color=" + color +
                '}';
    }
}