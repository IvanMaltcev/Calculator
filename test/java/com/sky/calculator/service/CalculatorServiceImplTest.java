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

    private CalculatorService out;

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

        int actual = out.calculatedSum(number1, number2);
        assertEquals(10, actual);

    }

    @Test
    public void additionNegativeNumbersTesting() {

        int actual = out.calculatedSum(number3, number4);
        assertEquals(-5, actual);

    }

    @Test
    public void exceptionForValidParamWhenAddingNotNumberTesting() {

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> out.calculatedSum(number1, notNumber));

        assertEquals("Укажите оба параметра в виде числа!", exception.getMessage());

    }

    @Test
    public void exceptionForValidParamWhenAddingEmptySpaceTesting() {

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> out.calculatedSum(number1, emptySpace));

        assertEquals("Укажите оба параметра в виде числа!", exception.getMessage());
    }

    @Test
    public void subtractionPositiveNumbersTesting() {

        int actual = out.calculatedDiff(number1, number2);
        assertEquals(0, actual);
    }

    @Test
    public void subtractionNegativeNumbersTesting() {

        int actual = out.calculatedDiff(number3, number4);
        assertEquals(3, actual);
    }

    @Test
    public void exceptionForValidParamWhenSubtractingNotNumberTesting() {

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> out.calculatedDiff(number1, notNumber));

        assertEquals("Укажите оба параметра в виде числа!", exception.getMessage());

    }

    @Test
    public void exceptionForValidParamWhenSubtractingEmptySpaceTesting() {

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> out.calculatedDiff(number1, emptySpace));

        assertEquals("Укажите оба параметра в виде числа!", exception.getMessage());
    }

    @Test
    public void multiplicationPositiveNumbersTesting() {

        int actual = out.calculatedOp(number1, number2);
        assertEquals(25, actual);
    }

    @Test
    public void multiplicationNegativeNumbersTesting() {

        int actual = out.calculatedOp(number3, number4);
        assertEquals(4, actual);
    }

    @Test
    public void exceptionForValidParamWhenMultiplyingNotNumberTesting() {

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> out.calculatedOp(number1, notNumber));

        assertEquals("Укажите оба параметра в виде числа!", exception.getMessage());

    }

    @Test
    public void exceptionForValidParamWhenMultiplyingEmptySpaceTesting() {

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> out.calculatedOp(number1, emptySpace));

        assertEquals("Укажите оба параметра в виде числа!", exception.getMessage());
    }

    @Test
    public void divisionPositiveNumbersTesting() {

        double actual = out.calculatedQuotient(number1, number2);
        assertEquals(1, actual);
    }

    @Test
    public void divisionNegativeNumbersTesting() {

        double actual = out.calculatedQuotient(number3, number4);
        assertEquals(0.25, actual);
    }

    @Test
    public void exceptionForValidParamWhenDivisionNotNumbersTesting() {

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> out.calculatedQuotient(number1, notNumber));

        assertEquals("Укажите оба параметра в виде числа!", exception.getMessage());

    }

    @Test
    public void exceptionForValidParamWhenDivisionEmptySpaceTesting() {

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> out.calculatedQuotient(number1, emptySpace));

        assertEquals("Укажите оба параметра в виде числа!", exception.getMessage());
    }

    @Test
    public void exceptionDivisionByZeroTesting() {

        Exception exception = assertThrows(QuotientByZeroException.class,
                () -> out.calculatedQuotient(number1, number5));

        assertEquals("На ноль делить нельзя!", exception.getMessage());
    }
}
