package com.sky.calculator;

import org.springframework.stereotype.Service;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public String greeting() {
        return "Добро пожаловать в калькулятор!";
    }

    @Override
    public int calculatedSum(String number1, String number2) {

        if (isValidParam(number1) && isValidParam(number2)) {
            return parseInt(number1) + parseInt(number2);
        }
        throw new IllegalArgumentException("Укажите оба параметра в виде числа!");
    }

    @Override
    public int calculatedDiff(String number1, String number2) {

        if (isValidParam(number1) && isValidParam(number2)) {
            return parseInt(number1) - parseInt(number2);
        }
        throw new IllegalArgumentException("Укажите оба параметра в виде числа!");
    }

    @Override
    public int calculatedOp(String number1, String number2) {

        if (isValidParam(number1) && isValidParam(number2)) {
            return parseInt(number1) * parseInt(number2);
        }
        throw new IllegalArgumentException("Укажите оба параметра в виде числа!");
    }

    @Override
    public double calculatedQuotient(String number1, String number2) {

        if (isValidParam(number1) && isValidParam(number2)) {
            if (parseInt(number2) == 0) {
                throw new ArithmeticException("На ноль дельть нельзя!");
            } else {
                return parseDouble(number1) / parseDouble(number2);
            }
        }
        throw new IllegalArgumentException("Укажите оба параметра в виде числа!");
    }

    private boolean isValidParam(String number) {
        if (number == null || number.isEmpty()) {
            return false;
        }
        for (int i = (number.charAt(0) == '-') ? 1 : 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}