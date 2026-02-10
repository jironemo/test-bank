package com.jpay.testbank.dto;

import com.jpay.testbank.util.JPayEntity;
import lombok.Data;

@Data
public class DynamicQRRequestDto extends JPayEntity {
    private Long merchantId;
    private Double amount;
    private String reference;
    private String description;
}
