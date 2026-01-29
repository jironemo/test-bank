package com.testbank.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testbank.dto.OnboardingDto;
import com.testbank.service.onboarding.OnboardingService;
import com.testbank.util.JPayResponse;

@RestController
@RequestMapping("/api/account")
public class OnboardingController {

    OnboardingService onboardingService;

    public OnboardingController(@Autowired OnboardingService onboardingService){
        this.onboardingService = onboardingService;
    }
    @PostMapping("register")
    public JPayResponse<?> registerUser(@RequestBody OnboardingDto onboardingDto){
        OnboardingDto response = onboardingService.saveUserAndMerchant(onboardingDto);
        return JPayResponse.ok(response);
    }

}
