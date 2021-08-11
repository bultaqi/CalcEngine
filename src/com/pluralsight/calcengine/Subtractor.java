package com.pluralsight.calcengine;

public class Subtractor extends CalculateBase {
    //no argument constructor
    public Subtractor() {}
    //constructor that accepts two arguments
    public Subtractor(double leftVal, double rightVal) {
        //super calls up to its base class (CalculateBase) to accept those base class values
        super(leftVal, rightVal);
    }


    @Override
    // Method
    public void calculate() {
        double value = getLeftVal() - getRightVal();
        setResult(value);
    }

}
