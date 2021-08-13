package com.pluralsight.calcengine;

public class Adder extends CalculateBase implements MathProcessing {
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

    @Override
    public String getKeyword() {
        return "add";
    }

    @Override
    public char getSymbol() {
        return '+';
    }

    @Override
    public double doCalculation(double leftVal, double rightVal) {
        setLeftVal(leftVal);
        setRightVal(rightVal);
        calculate();

        return getResult();
    }
}
