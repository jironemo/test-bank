package com.testbank.service.auth;

import com.testbank.dto.ApiKeyResponseDto;

public interface AuthService {


    public ApiKeyResponseDto generateApiKey(Long merchantId);
    
}
