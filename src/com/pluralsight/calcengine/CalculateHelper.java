package com.pluralsight.calcengine;

public class CalculateHelper {
    private static final char ADD_SYMBOL = '+';
    private static final char SUBTRACT_SYMBOL = '-';
    private static final char MULTIPLY_SYMBOL = '*';
    private static final char DIVIDE_SYMBOL = '/';
    //fields for the values being passed in as strings in main
    MathCommand command;
    double leftValue;
    double rightValue;
    double result;

    public void process(String statement) {
        //process is taking those strings and separating them mores specifically
        String[] parts = statement.split(" ");
        // are math operation, commandString, is a string and we still have to convert it to the Enumeration(MathCommand)
        String commandString = parts[0]; // like "add"
        // capital Double.parseDouble is converting the string, parts, into the primitive type double
        leftValue = Double.parseDouble(parts[1]); // like "1.0"
        rightValue = Double.parseDouble(parts[2]); // like "2.0"

        //translate the string command into our math enumeration
        setCommandFromString(commandString);

        // command is looked at and creates a calculate based derived class to do the work
        CalculateBase calculator = null;
        switch (command) {
            case Add:
                    calculator= new Adder(leftValue, rightValue);
                    break;
            case Subtract:
                    calculator = new Subtractor(leftValue, rightValue);
                    break;
            case Multiply:
                    calculator = new Multiplier(leftValue, rightValue);
                    break;
            case Divide:
                    calculator = new Divider(leftValue, rightValue);
                    break;
        }

        calculator.calculate();
        result = calculator.getResult();

    }

    private void setCommandFromString (String commandString) {
        // this calling the Enumeration MathCommand, converting the command to a string
        // then comparing the Enumeration string to the string from commandString
        if(commandString.equalsIgnoreCase(MathCommand.Add.toString()))
            command = MathCommand.Add;
        else if(commandString.equalsIgnoreCase(MathCommand.Subtract.toString()))
        command = MathCommand.Subtract;
        else if(commandString.equalsIgnoreCase(MathCommand.Multiply.toString()))
            command = MathCommand.Multiply;
        else if(commandString.equalsIgnoreCase(MathCommand.Divide.toString()))
            command = MathCommand.Divide;
    }

    // this builds the output string
    @Override
    public String toString() {
        char symbol = ' ';
        switch (command) {
            case Add:
                symbol = ADD_SYMBOL;
                break;
            case Subtract:
                symbol = SUBTRACT_SYMBOL;
                break;
            case Multiply:
                symbol = MULTIPLY_SYMBOL;
                break;
            case Divide:
                symbol = DIVIDE_SYMBOL;
                break;

        }

        StringBuilder sb = new StringBuilder(20);
        sb.append(leftValue);
        sb.append(' ');
        sb.append(symbol);
        sb.append(' ');
        sb.append(rightValue);
        sb.append(" = ");
        sb.append(result);

        return sb.toString();
    }

}
