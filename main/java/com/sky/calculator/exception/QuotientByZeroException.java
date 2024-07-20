package com.sky.calculator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuotientByZeroException extends IllegalArgumentException{
    public QuotientByZeroException(String s) {
        super(s);
    }
}
