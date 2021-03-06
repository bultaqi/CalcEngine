package com.pluralsight.myapp;

import com.pluralsight.calcengine.Adder;
import com.pluralsight.calcengine.CalculateBase;
import com.pluralsight.calcengine.CalculateHelper;
import com.pluralsight.calcengine.Divider;
import com.pluralsight.calcengine.DynamicHelper;
import com.pluralsight.calcengine.InvalidStatementException;
import com.pluralsight.calcengine.MathEquation;
import com.pluralsight.calcengine.MathProcessing;
import com.pluralsight.calcengine.Multiplier;
import com.pluralsight.calcengine.PowerOf;
import com.pluralsight.calcengine.Subtractor;

// DON'T FORGET after changing the imports and packages you MUST edit the configurations in the run tool

public class Main {

    public static void main(String[] args) {
        // useMathEquation();
        // useCalculatorBase();
        // useCalculateHelper();

        // the power of interfaces is the ability to take a problem, abstractly model it into its ind. pieces
        // model the contract to fulfill those pieces as an interface
        // and then very easily build implementations of the interface that focus on a very specific set of work
        String[] statements = {
                "add 25.0 92.0",
                "power 5.0 2.0"
        };

        DynamicHelper helper = new DynamicHelper(new MathProcessing[] {
                new Adder(),
                new PowerOf()
        });
        for(String statement:statements) {
            String output = helper.process(statement);
            System.out.println(output);
        }
    }

    static void useCalculateHelper() {
        String[] statements = {
            "add 1.0",              // incorrect number of values
            "add xx 25.0",          // non-numeric data
            "addx 0.0 0.0",         // invalid command
            "divide 100.0 50.0",
            "add 25.0 92.0",
            "subtract 225.0 17.0",
            "multiply 11.0 3.0"
        };

        CalculateHelper helper = new CalculateHelper();
        // notice we placed the try/catch inside the for because if it noticed any error, it would jump out
        for (String statement : statements) {
            // the method, process, declares that we throw the customer exception, so we wrap it in a try/catch
            try {
                helper.process(statement);
                System.out.println(helper);
            } catch (InvalidStatementException e) {
                System.out.println(e.getMessage());
                // in some cases, we'll have not only our custom exception, but another exception
                if (e.getCause() != null)
                    System.out.println(" Original exception: " + e.getCause().getMessage());
            }

        }

    }

    static void useMathEquation() {
        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation('d',100.0d,50.0d);
        equations[1] = new MathEquation('a', 25.0d, 92.0d);
        equations[2] = new MathEquation('s', 225.0d, 17.0d);
        equations[3] = new MathEquation('m', 11.0d, 3.0d);

        for (MathEquation equation: equations) {
            equation.execute();
            System.out.print("result = ");
            System.out.println(equation.getResult());
        }

        System.out.println();
        System.out.println("--- using overloads ---");
        System.out.println();

        double leftDouble = 9.0d;
        double rightDouble = 4.0d;
        int leftInt = 9;
        int rightInt = 4;

        MathEquation equationOverload = new MathEquation('d');

        equationOverload.execute(leftDouble, rightDouble);
        System.out.print("result = ");
        System.out.println(equationOverload.getResult());

        equationOverload.execute(leftInt, rightInt);
        System.out.print("result = ");
        System.out.println(equationOverload.getResult());

        equationOverload.execute((double)leftInt, rightInt);
        System.out.print("result = ");
        System.out.println(equationOverload.getResult());

        equationOverload.execute((double)leftInt, rightInt);
        System.out.println();
        System.out.print("--- Using Inheritance ---");
        System.out.println();
        System.out.println(equationOverload.getResult());

        CalculateBase[] calculators = {
                new Divider(100.0d, 50.0),
                new Adder(25.0d, 92.0d),
                new Subtractor(225.0d, 17.0d),
                new Multiplier(11.0d, 3.0d)
        };

        for(CalculateBase calculator:calculators) {
            calculator.calculate();
            System.out.print("result =");
            System.out.println(calculator.getResult());
        }

    }
}
