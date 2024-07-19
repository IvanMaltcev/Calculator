package com.sky.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping()
    public String greeting() {
        return calculatorService.greeting();
    }

    @GetMapping("/plus")
    public String calculatedSum(@RequestParam("num1") String number1,
                                @RequestParam("num2") String number2) {
        try {
            return String.format("%s + %s = %d", number1, number2,
                    calculatorService.calculatedSum(number1, number2));
        } catch (IllegalArgumentException exception) {
            return exception.getMessage();
        }
    }

    @GetMapping("/minus")
    public String calculatedDiff(@RequestParam("num1") String number1,
                                 @RequestParam("num2") String number2) {
        try {
            return String.format("%s - %s = %d", number1, number2,
                    calculatorService.calculatedDiff(number1, number2));
        } catch (IllegalArgumentException exception) {
            return exception.getMessage();
        }
    }

    @GetMapping("/multiply")
    public String calculatedOp(@RequestParam("num1") String number1,
                               @RequestParam("num2") String number2) {
        try {
            return String.format("%s * %s = %d", number1, number2,
                    calculatorService.calculatedOp(number1, number2));
        } catch (IllegalArgumentException exception) {
            return exception.getMessage();
        }
    }

    @GetMapping("/divide")
    public String calculatedQuotient(@RequestParam("num1") String number1,
                                     @RequestParam("num2") String number2) {
        try {
            return String.format("%s / %s = %.2f", number1, number2,
                    calculatorService.calculatedQuotient(number1, number2));
        } catch (ArithmeticException | IllegalArgumentException exception) {
            return exception.getMessage();
        }
    }
}
