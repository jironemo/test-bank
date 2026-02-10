package com.jpay.testbank.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.jpay.testbank.util.JPayEntity;
import com.jpay.testbank.util.enums.MerchantStatus;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MerchantInformationResponseDto extends JPayEntity {
    private String orgName;
    private String address;
    private MerchantStatus status;
    private String createdAt;
    private String merchantCode;
}
