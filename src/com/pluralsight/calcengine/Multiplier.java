package com.pluralsight.calcengine;

public class Multiplier extends CalculateBase {
    //no argument constructor
    public Multiplier() {}
    //constructor that accepts two arguments
    public Multiplier(double leftVal, double rightVal) {
        //super calls up to its base class (CalculateBase) to accept those base class values
        super(leftVal, rightVal);
    }


    @Override
    // Method
    public void calculate() {
        double value = getLeftVal() + getRightVal();
        setResult(value);
    }

}
