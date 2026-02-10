package com.jpay.testbank.dto;


import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import com.jpay.testbank.util.JPayEntity;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OnboardingRequestDto extends JPayEntity implements Serializable {

    UserAccountRequestDto userAccount;
    MerchantInformationRequestDto merchantInformation;
    
}
