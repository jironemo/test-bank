package com.jpay.testbank.config;
import com.jpay.testbank.util.JPayError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jpay.testbank.util.JPayResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(RuntimeException.class)
    public JPayResponse<JPayError> handleRuntimeException(RuntimeException e) {
        return JPayResponse.error(e.getMessage());
    }
    
}
