package com.testbank.util;

import java.io.Serializable;

import lombok.Data;


@Data
public class JPayResponse<T> implements Serializable{
    private Long status;
    private String message;
    private T data;


    public static <T> JPayResponse<T> ok(T entity){
        JPayResponse<T> response = new JPayResponse<>();
        response.status = 1L;
        response.message = "User created successfully";
        response.data = entity;
        return response;
    }
}
