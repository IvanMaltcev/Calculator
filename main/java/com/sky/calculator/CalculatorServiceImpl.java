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
    public String calculatedSum(String number1, String number2) {

        if (isValidParam(number1) && isValidParam(number2)) {
            int sum = parseInt(number1) + parseInt(number2);
            return String.format("%s + %s = %d", number1, number2, sum);
        }
        return "Укажите оба параметра в виде числа";
    }

    @Override
    public String calculatedDiff(String number1, String number2) {

        if (isValidParam(number1) && isValidParam(number2)) {
            int diff = parseInt(number1) - parseInt(number2);
            return String.format("%s - %s = %d", number1, number2, diff);
        }
        return "Укажите оба параметра в виде числа";
    }

    @Override
    public String calculatedOp(String number1, String number2) {

        if (isValidParam(number1) && isValidParam(number2)) {
            int op = parseInt(number1) * parseInt(number2);
            return String.format("%s * %s = %d", number1, number2, op);
        }
        return "Укажите оба параметра в виде числа";
    }

    @Override
    public String calculatedQuotient(String number1, String number2) {

        if (isValidParam(number1) && isValidParam(number2)) {
            if (parseInt(number2) == 0) {
                return "На ноль делить нельзя!";
            } else {
                double quotient = parseDouble(number1) / parseDouble(number2);
                return String.format("%s / %s = %.2f", number1, number2, quotient);
            }
        }
        return "Укажите оба параметра в виде числа";
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