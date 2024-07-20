package com.sky.calculator.service;

import com.sky.calculator.exception.QuotientByZeroException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceImplTest {

    private String number1;
    private String number2;
    private String number3;
    private String number4;
    private String number5;
    private String notNumber;
    private String emptySpace;

    CalculatorService out;

    @BeforeEach
    public void setUp() {
        number1 = "5";
        number2 = "5";
        number3 = "-1";
        number4 = "-4";
        number5 = "0";
        notNumber = "a";
        emptySpace = "";


        out = new CalculatorServiceImpl();
    }

    @Test
    public void additionPositiveNumbersTesting() {

        int actual1 = out.calculatedSum(number1, number2);
        assertEquals(10, actual1);

    }

    @Test
    public void additionNegativeNumbersTesting() {

        int actual2 = out.calculatedSum(number3, number4);
        assertEquals(-5, actual2);

    }

    @Test
    public void exceptionForValidParamWhenAddingNotNumberTesting() {

        Exception exception1 = assertThrows(IllegalArgumentException.class,
                () -> out.calculatedSum(number1, notNumber));

        assertEquals("Укажите оба параметра в виде числа!", exception1.getMessage());

    }

    @Test
    public void exceptionForValidParamWhenAddingEmptySpaceTesting() {

        Exception exception2 = assertThrows(IllegalArgumentException.class,
                () -> out.calculatedSum(number1, emptySpace));

        assertEquals("Укажите оба параметра в виде числа!", exception2.getMessage());
    }

    @Test
    public void subtractionPositiveNumbersTesting() {

        int actual1 = out.calculatedDiff(number1, number2);
        assertEquals(0, actual1);
    }

    @Test
    public void subtractionNegativeNumbersTesting() {

        int actual2 = out.calculatedDiff(number3, number4);
        assertEquals(3, actual2);
    }

    @Test
    public void exceptionForValidParamWhenSubtractingNotNumberTesting() {

        Exception exception1 = assertThrows(IllegalArgumentException.class,
                () -> out.calculatedDiff(number1, notNumber));

        assertEquals("Укажите оба параметра в виде числа!", exception1.getMessage());

    }

    @Test
    public void exceptionForValidParamWhenSubtractingEmptySpaceTesting() {

        Exception exception2 = assertThrows(IllegalArgumentException.class,
                () -> out.calculatedDiff(number1, emptySpace));

        assertEquals("Укажите оба параметра в виде числа!", exception2.getMessage());
    }

    @Test
    public void multiplicationPositiveNumbersTesting() {

        int actual1 = out.calculatedOp(number1, number2);
        assertEquals(25, actual1);
    }

    @Test
    public void multiplicationNegativeNumbersTesting() {

        int actual2 = out.calculatedOp(number3, number4);
        assertEquals(4, actual2);
    }

    @Test
    public void exceptionForValidParamWhenMultiplyingNotNumberTesting() {

        Exception exception1 = assertThrows(IllegalArgumentException.class,
                () -> out.calculatedOp(number1, notNumber));

        assertEquals("Укажите оба параметра в виде числа!", exception1.getMessage());

    }

    @Test
    public void exceptionForValidParamWhenMultiplyingEmptySpaceTesting() {

        Exception exception2 = assertThrows(IllegalArgumentException.class,
                () -> out.calculatedOp(number1, emptySpace));

        assertEquals("Укажите оба параметра в виде числа!", exception2.getMessage());
    }

    @Test
    public void divisionPositiveNumbersTesting() {

        double actual1 = out.calculatedQuotient(number1, number2);
        assertEquals(1, actual1);
    }

    @Test
    public void divisionNegativeNumbersTesting() {

        double actual2 = out.calculatedQuotient(number3, number4);
        assertEquals(0.25, actual2);
    }

    @Test
    public void exceptionForValidParamWhenDivisionNotNumbersTesting() {

        Exception exception1 = assertThrows(IllegalArgumentException.class,
                () -> out.calculatedQuotient(number1, notNumber));

        assertEquals("Укажите оба параметра в виде числа!", exception1.getMessage());

    }

    @Test
    public void exceptionForValidParamWhenDivisionEmptySpaceTesting() {

        Exception exception2 = assertThrows(IllegalArgumentException.class,
                () -> out.calculatedQuotient(number1, emptySpace));

        assertEquals("Укажите оба параметра в виде числа!", exception2.getMessage());
    }

    @Test
    public void exceptionDivisionByZeroTesting() {

        Exception exception = assertThrows(QuotientByZeroException.class,
                () -> out.calculatedQuotient(number1, number5));

        assertEquals("На ноль делить нельзя!", exception.getMessage());
    }
}
