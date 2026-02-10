package com.jpay.testbank.service.onboarding;
import com.jpay.testbank.dto.OnboardingRequestDto;
import com.jpay.testbank.dto.OnboardingResponseDto;

public interface OnboardingService{
    OnboardingResponseDto saveUserAndMerchant(OnboardingRequestDto onboardingRequestDto);
    
}
