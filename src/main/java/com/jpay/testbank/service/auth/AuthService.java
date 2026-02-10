package com.jpay.testbank.service.auth;

import com.jpay.testbank.dto.ApiKeyResponseDto;

public interface AuthService {


    public ApiKeyResponseDto generateApiKey(Long merchantId);
    
}
