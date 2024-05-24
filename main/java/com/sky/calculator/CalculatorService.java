package com.sky.calculator;

public interface CalculatorService {

    String greeting();

    int calculatedSum(String number1, String number2);

    int calculatedDiff(String number1, String number2);

    int calculatedOp(String number1, String number2);

    double calculatedQuotient(String number1, String number2);

}
