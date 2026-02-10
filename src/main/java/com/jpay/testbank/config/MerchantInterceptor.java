package com.jpay.testbank.config;

import com.jpay.testbank.util.enums.ApiKeyStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.jpay.testbank.model.auth.ApiKey;
import com.jpay.testbank.repository.apikey.ApiKeyDao;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class MerchantInterceptor implements HandlerInterceptor{


    private final ApiKeyDao apiKeyDao;


    public MerchantInterceptor(@Autowired  ApiKeyDao apiKeyDao){
        this.apiKeyDao = apiKeyDao;
    }
    
    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response,
             Object handler) throws Exception {

                
                String apiKey = request.getHeader("X-API-KEY");
                ApiKey keyInDb = apiKeyDao.findByValue(apiKey);
                if(apiKey == null || apiKey.isBlank()){
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    return false; // Stop further processing
                }else if(keyInDb == null || !apiKey.equals(keyInDb.getValue()) || keyInDb.getStatus() != ApiKeyStatus.ACTIVE){
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                    return false; // Stop further processing
                }
        // Add your interception logic here
        return true; // Return true to continue the request processing
    }
}
