package com.jpay.testbank.util;

import lombok.Data;

@Data
public class JPayError extends JPayEntity {
    private String errorCode;
    private String errorMessage;

}