package com.jpay.testbank.controller;


import com.jpay.testbank.dto.OnboardingResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpay.testbank.dto.OnboardingRequestDto;
import com.jpay.testbank.service.onboarding.OnboardingService;
import com.jpay.testbank.util.JPayResponse;

@RestController
@RequestMapping("/api/account")
public class OnboardingController {

    OnboardingService onboardingService;

    public OnboardingController(@Autowired OnboardingService onboardingService){
        this.onboardingService = onboardingService;
    }
    @PostMapping("register")
    public JPayResponse<?> registerUser(@RequestBody OnboardingRequestDto onboardingRequestDto){
        OnboardingResponseDto response = onboardingService.saveUserAndMerchant(onboardingRequestDto);
        return JPayResponse.ok(response);
    }

}
