package com.jpay.testbank.dto;

import java.io.Serializable;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.jpay.testbank.util.JPayEntity;
import com.jpay.testbank.util.enums.UserRole;
import com.jpay.testbank.util.enums.UserStatus;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserAccountRequestDto extends JPayEntity implements Serializable{
    private String fullName;
    private String password;
    private String username;
    private UserRole role;
    private String createdAt;
}


