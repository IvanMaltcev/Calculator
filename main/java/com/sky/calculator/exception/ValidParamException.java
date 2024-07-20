package com.sky.calculator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidParamException extends IllegalArgumentException {
    public ValidParamException(String s) {
        super(s);
    }
}
