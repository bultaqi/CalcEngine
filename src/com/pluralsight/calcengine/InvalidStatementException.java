package com.pluralsight.calcengine;

//creating a custom exception
public class InvalidStatementException extends Exception {
    // a public constructor that extends the Exception class from java
    public InvalidStatementException(String reason, String statement) {
        //super class constructor calls up to its base class and accepts a string
        super(reason + ": " + statement);
    }
    public InvalidStatementException(String reason, String statement, Throwable cause)  {
        super(reason + ": " + statement, cause);
    }
}
