package com.jpay.testbank.dto;

import com.jpay.testbank.util.JPayEntity;
import lombok.Data;

@Data
public class ApiKeyResponseDto extends JPayEntity {
    String apiKey;
    Long userId;
}
