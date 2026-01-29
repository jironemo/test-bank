package com.testbank.dto;


import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OnboardingDto implements Serializable{

    UserAccountDto userAccount;
    MerchantInformationDto merchantInformation;
    
}
