package com.testbank.dto;

import lombok.Data;

@Data
public class DynamicQRRequestDto {
    private Long merchantId;
    private Double amount;
    private String reference;
    private String description;
}
