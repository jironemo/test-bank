package com.testbank.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.testbank.util.enums.MerchantStatus;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MerchantInformationDto {

    private String orgName;
    private String address;
    private MerchantStatus status;
    private String createdAt;
    private String merchantCode;
}