package com.testbank.config;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.testbank.util.JPayResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(RuntimeException.class)
    public JPayResponse<String> handleRuntimeException(RuntimeException e) {
        return JPayResponse.error(e.getMessage());
    }
    
}
