package com.mtsmda.springCore.SpEL;

/**
 * Created by MTSMDA on 05.06.2015.
 */
public class Operators {

    //Relational
    private boolean equalTest;
    private boolean notEqualTest;
    private boolean lessThanTest;
    private boolean lessThanOrEqualTest;
    private boolean greatThanTest;
    private boolean greatThanOrEqualTest;

    //Logical
    private boolean andTest;
    private boolean orTest;
    private boolean notTest;

    //Mathematical
    private double addTest;
    private String addStringTest;
    private double subtractionTest;
    private double multiplicationTest;
    private double divisionTest;
    private double modulusTest;
    private double exponetialPowerTest;

    public boolean isEqualTest() {
        return equalTest;
    }

    public void setEqualTest(boolean equalTest) {
        this.equalTest = equalTest;
    }

    public boolean isNotEqualTest() {
        return notEqualTest;
    }

    public void setNotEqualTest(boolean notEqualTest) {
        this.notEqualTest = notEqualTest;
    }

    public boolean isLessThanTest() {
        return lessThanTest;
    }

    public void setLessThanTest(boolean lessThanTest) {
        this.lessThanTest = lessThanTest;
    }

    public boolean isLessThanOrEqualTest() {
        return lessThanOrEqualTest;
    }

    public void setLessThanOrEqualTest(boolean lessThanOrEqualTest) {
        this.lessThanOrEqualTest = lessThanOrEqualTest;
    }

    public boolean isGreatThanTest() {
        return greatThanTest;
    }

    public void setGreatThanTest(boolean greatThanTest) {
        this.greatThanTest = greatThanTest;
    }

    public boolean isGreatThanOrEqualTest() {
        return greatThanOrEqualTest;
    }

    public void setGreatThanOrEqualTest(boolean greatThanOrEqualTest) {
        this.greatThanOrEqualTest = greatThanOrEqualTest;
    }

    public boolean isAndTest() {
        return andTest;
    }

    public void setAndTest(boolean andTest) {
        this.andTest = andTest;
    }

    public boolean isOrTest() {
        return orTest;
    }

    public void setOrTest(boolean orTest) {
        this.orTest = orTest;
    }

    public boolean isNotTest() {
        return notTest;
    }

    public void setNotTest(boolean notTest) {
        this.notTest = notTest;
    }

    public double getAddTest() {
        return addTest;
    }

    public void setAddTest(double addTest) {
        this.addTest = addTest;
    }

    public String getAddStringTest() {
        return addStringTest;
    }

    public void setAddStringTest(String addStringTest) {
        this.addStringTest = addStringTest;
    }

    public double getSubtractionTest() {
        return subtractionTest;
    }

    public void setSubtractionTest(double subtractionTest) {
        this.subtractionTest = subtractionTest;
    }

    public double getDivisionTest() {
        return divisionTest;
    }

    public void setDivisionTest(double divisionTest) {
        this.divisionTest = divisionTest;
    }

    public double getModulusTest() {
        return modulusTest;
    }

    public void setModulusTest(double modulusTest) {
        this.modulusTest = modulusTest;
    }

    public double getExponetialPowerTest() {
        return exponetialPowerTest;
    }

    public void setExponetialPowerTest(double exponetialPowerTest) {
        this.exponetialPowerTest = exponetialPowerTest;
    }

    public double getMultiplicationTest() {
        return multiplicationTest;
    }

    public void setMultiplicationTest(double multiplicationTest) {
        this.multiplicationTest = multiplicationTest;
    }

    @Override
    public String toString() {
        return "Operators{" +
                "equalTest=" + equalTest +
                ", notEqualTest=" + notEqualTest +
                ", lessThanTest=" + lessThanTest +
                ", lessThanOrEqualTest=" + lessThanOrEqualTest +
                ", greatThanTest=" + greatThanTest +
                ", greatThanOrEqualTest=" + greatThanOrEqualTest +
                ", multiplicationTest=" + multiplicationTest +
                ", andTest=" + andTest +
                ", orTest=" + orTest +
                ", notTest=" + notTest +
                ", addTest=" + addTest +
                ", addStringTest='" + addStringTest + '\'' +
                ", subtractionTest=" + subtractionTest +
                ", divisionTest=" + divisionTest +
                ", modulusTest=" + modulusTest +
                ", exponetialPowerTest=" + exponetialPowerTest +
                '}';
    }
}