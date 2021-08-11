package com.pluralsight.calcengine;

public class Adder extends CalculateBase {
    //no argument constructor
    public Adder() {}
    //constructor that accepts two arguments
    public Adder(double leftVal, double rightVal) {
        //super calls up to its base class (CalculateBase) to accept those base class values
        super(leftVal, rightVal);
    }


    @Override
    // Method "overides" base class (CalculateBase) method calculate()
    // has same signature (smae
    public void calculate() {
        double value = getLeftVal() + getRightVal();
        setResult(value);
    }

}
