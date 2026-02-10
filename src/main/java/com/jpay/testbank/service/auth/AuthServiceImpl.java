package com.jpay.testbank.service.auth;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpay.testbank.dto.ApiKeyResponseDto;
import com.jpay.testbank.model.auth.ApiKey;
import com.jpay.testbank.repository.apikey.ApiKeyDao;
import com.jpay.testbank.service.user.UserAccountService;
import com.jpay.testbank.util.enums.ApiKeyStatus;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserAccountService userService;
    private final ApiKeyDao apiKeyDao;
    public AuthServiceImpl(@Autowired UserAccountService userService, @Autowired ApiKeyDao apiKeyDao) {
        this.userService = userService;
        this.apiKeyDao = apiKeyDao;
        
    }
    @Override
    public ApiKeyResponseDto generateApiKey(Long userId) {
        ApiKey apiKey = new ApiKey();
        apiKey.setValue(UUID.randomUUID().toString() + "-" + userId);

        apiKey.setStatus(ApiKeyStatus.ACTIVE);
        apiKey.setUserAccount(userService.find(userId));

        ApiKey savedKey = apiKeyDao.save(apiKey);
        ApiKeyResponseDto response = new ApiKeyResponseDto();
        response.setApiKey(savedKey.getValue());
        response.setUserId(savedKey.getUserAccount().getId());
        return response;
    }
    
}
