package com.testbank.dto;

import java.io.Serializable;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.testbank.util.enums.UserRole;
import com.testbank.util.enums.UserStatus;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserAccountDto implements Serializable{
    private String fullName;
    private String password;
    private String username;
    private UserRole role;
    private UserStatus status;
    private String createdAt;
}


