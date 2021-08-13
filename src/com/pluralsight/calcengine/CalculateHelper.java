package com.pluralsight.calcengine;

public class CalculateHelper {
    private static final char ADD_SYMBOL = '+';
    private static final char SUBTRACT_SYMBOL = '-';
    private static final char MULTIPLY_SYMBOL = '*';
    private static final char DIVIDE_SYMBOL = '/';
    //fields for the values being passed in as strings in main
    private MathCommand command;
    private double leftValue;
    private double rightValue;
    private double result;

    // remember custom exceptions are checked exceptions
    // there are two ways for a method to handle a checked exception
    // either try a try/catch block to handle it or throw it to the caller of the method(which we did)
    public void process(String statement) throws InvalidStatementException {
        //process is taking those strings and separating them mores specifically
        String[] parts = statement.split(" ");
        if(parts.length != 3)
            throw new InvalidStatementException("Incorrect number of fields", statement);
        // are math operation, commandString, is a string and we still have to convert it to the Enumeration(MathCommand)
        String commandString = parts[0]; // like "add"
        // capital Double.parseDouble is converting the string, parts, into the primitive type double

        try {
            leftValue = Double.parseDouble(parts[1]); // like "1.0"
            rightValue = Double.parseDouble(parts[2]); // like "2.0"
        } catch (NumberFormatException e) {
            throw new InvalidStatementException("Non-numeric data", statement, e);
        }
        //translate the string command into our math enumeration
        setCommandFromString(commandString);
        if(command == null)
            throw new InvalidStatementException("Invalid command", statement);
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
