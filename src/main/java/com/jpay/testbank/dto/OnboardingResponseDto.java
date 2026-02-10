package com.jpay.testbank.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.jpay.testbank.util.JPayEntity;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OnboardingResponseDto extends JPayEntity {
    MerchantInformationResponseDto merchantInformation;
}
