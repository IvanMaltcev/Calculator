package com.sky.calculator.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorServiceImplParamTest {

    CalculatorService out = new CalculatorServiceImpl();

    @ParameterizedTest
    @MethodSource("numbersParamForTests")
    public void additionTesting(String num1, String num2) {
        int actual1 = out.calculatedSum(num1, num2);
        int expected = Integer.parseInt(num1) + Integer.parseInt(num2);
        assertEquals(expected, actual1);
    }

    @ParameterizedTest
    @MethodSource("noNumbersParamForTests")
    public void ExceptionForValidParamWhenAddingTesting(String num1, String num2) {
        Exception exception1 = assertThrows(IllegalArgumentException.class,
                () -> out.calculatedSum(num1, num2));

        assertEquals("Укажите оба параметра в виде числа!", exception1.getMessage());
    }

    @ParameterizedTest
    @MethodSource("numbersParamForTests")
    public void subtractionTesting(String num1, String num2) {
        int actual1 = out.calculatedDiff(num1, num2);
        int expected = Integer.parseInt(num1) - Integer.parseInt(num2);
        assertEquals(expected, actual1);
    }

    @ParameterizedTest
    @MethodSource("noNumbersParamForTests")
    public void ExceptionForValidParamWhenSubtractingTesting(String num1, String num2) {
        Exception exception1 = assertThrows(IllegalArgumentException.class,
                () -> out.calculatedDiff(num1, num2));

        assertEquals("Укажите оба параметра в виде числа!", exception1.getMessage());
    }

    @ParameterizedTest
    @MethodSource("numbersParamForTests")
    public void multiplicationTesting(String num1, String num2) {
        int actual1 = out.calculatedOp(num1, num2);
        int expected = Integer.parseInt(num1) * Integer.parseInt(num2);
        assertEquals(expected, actual1);
    }

    @ParameterizedTest
    @MethodSource("noNumbersParamForTests")
    public void ExceptionForValidParamWhenMultiplyingTesting(String num1, String num2) {
        Exception exception1 = assertThrows(IllegalArgumentException.class,
                () -> out.calculatedOp(num1, num2));

        assertEquals("Укажите оба параметра в виде числа!", exception1.getMessage());
    }

    @ParameterizedTest
    @MethodSource("numbersParamForTests")
    public void divisionTesting(String num1, String num2) {
        double actual1 = out.calculatedQuotient(num1, num2);
        double expected = Double.parseDouble(num1) / Double.parseDouble(num2);
        assertEquals(expected, actual1);
    }

    @ParameterizedTest
    @MethodSource("noNumbersParamForTests")
    public void ExceptionForValidParamWhenDivisionTesting(String num1, String num2) {
        Exception exception1 = assertThrows(IllegalArgumentException.class,
                () -> out.calculatedQuotient(num1, num2));

        assertEquals("Укажите оба параметра в виде числа!", exception1.getMessage());
    }

    public static Stream<Arguments> numbersParamForTests() {
        return Stream.of(
                Arguments.of("5", "5"),
                Arguments.of("-1", "-4"),
                Arguments.of("-100", "20"),
                Arguments.of("50", "-4")
        );
    }

    public static Stream<Arguments> noNumbersParamForTests() {
        return Stream.of(
                Arguments.of("5", ""),
                Arguments.of("", "5"),
                Arguments.of("", ""),
                Arguments.of("1", "a"),
                Arguments.of("a", "1"),
                Arguments.of("a", "a")
        );
    }


}
