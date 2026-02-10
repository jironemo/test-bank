package com.jpay.testbank.util;

import java.io.Serializable;

import lombok.Data;


@Data
public class JPayResponse<T extends JPayEntity> implements Serializable{
    private Long status;
    private T data;
    private JPayError error;


    public static <T extends JPayEntity> JPayResponse<T> ok(T entity){
        JPayResponse<T> response = new JPayResponse<>();
        response.status = 1L;
        response.data = entity;
        return response;
    }


    public static JPayResponse<JPayError>  error(String message){
        JPayResponse<JPayError> response = new JPayResponse<>();
        response.status = 0L;
        JPayError err = new JPayError();
        err.setErrorMessage(message);
        response.setError(err);
        return response;
    }
}
