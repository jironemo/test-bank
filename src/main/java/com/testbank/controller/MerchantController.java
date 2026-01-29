package com.testbank.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testbank.dto.OnboardingDto;
import com.testbank.service.merchant.OnboardingService;
import com.testbank.util.JPayResponse;

@RestController
@RequestMapping("/api/merchant")
public class MerchantController {

    OnboardingService merchantAccountService;

    public MerchantController(@Autowired OnboardingService merchantAccountService){
        this.merchantAccountService = merchantAccountService;
    }
    @PostMapping("register")
    public JPayResponse<?> registerMerchant(@RequestBody OnboardingDto onboardingDto){
        OnboardingDto response = merchantAccountService.saveUserAndMerchant(onboardingDto);
        if(response != null){
            return JPayResponse.ok(response);
        }else{
            return JPayResponse.ok("Merchant with the username already exists");
        }
    }

}
