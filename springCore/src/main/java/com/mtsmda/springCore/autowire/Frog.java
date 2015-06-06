package com.mtsmda.springCore.autowire;

/**
 * Created by MTSMDA on 02.06.2015.
 */
public class Frog {

    private String name;
    private Color color;

    public Frog() {

    }

    public Frog(String name, Color color) {
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

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Frog{" +
                "name='" + name + '\'' +
                ", color=" + color +
                '}';
    }
}