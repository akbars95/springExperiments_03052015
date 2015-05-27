package com.mtsmda.springCore;

/**
 * Created by MTSMDA on 26.05.2015.
 */
public /*abstract*/ class SpringInheritanceAnimalAbstract {
    private String animalType;
    private String animalColor;
    private String animalName;

    public SpringInheritanceAnimalAbstract() {

    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getAnimalColor() {
        return animalColor;
    }

    public void setAnimalColor(String animalColor) {
        this.animalColor = animalColor;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }
}