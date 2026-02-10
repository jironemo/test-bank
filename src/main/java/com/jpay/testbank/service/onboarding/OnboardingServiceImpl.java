package com.jpay.testbank.service.onboarding;


import com.jpay.testbank.dto.OnboardingResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpay.testbank.dto.OnboardingRequestDto;
import com.jpay.testbank.model.merchant.MerchantInformation;
import com.jpay.testbank.model.user.UserAccount;
import com.jpay.testbank.service.merchant.MerchantInformationService;
import com.jpay.testbank.service.user.UserAccountService;
import com.jpay.testbank.util.exceptions.MerchantAlreadyExistsException;

@Service
public class OnboardingServiceImpl implements OnboardingService {


    UserAccountService userAccountService;
    MerchantInformationService merchantInformationService;

    public OnboardingServiceImpl(
        @Autowired UserAccountService userAccountService,
        @Autowired MerchantInformationService merchantInformationService
    ){
        this.userAccountService = userAccountService;
        this.merchantInformationService = merchantInformationService;
    }


    public OnboardingResponseDto saveUserAndMerchant(OnboardingRequestDto onboardingRequestDto){
        
        UserAccount user = userAccountService.findByUsername(onboardingRequestDto.getUserAccount().getUsername());
        if(user != null){
            throw new MerchantAlreadyExistsException("User with username " + onboardingRequestDto.getUserAccount().getUsername() + " already exists");
        }else {
            UserAccount created = userAccountService.save(new UserAccount(onboardingRequestDto.getUserAccount()));


            MerchantInformation merchantInformation = new MerchantInformation(onboardingRequestDto.getMerchantInformation());
            String curTime = System.currentTimeMillis() + "";
            String merCodeSeq = (System.currentTimeMillis() + "").substring(4, 10) + curTime.charAt(curTime.length() - 1);
            merchantInformation.setMerchantCode("MER" + merCodeSeq);
            merchantInformation.setUserAccount(created);
            merchantInformation.setQrString(merchantInformation.toQrString());
            merchantInformationService.save(merchantInformation);

            OnboardingResponseDto response = new OnboardingResponseDto();
            response.setMerchantInformation(merchantInformation.toResponseDto());
            response.getMerchantInformation().setMerchantCode(merchantInformation.getMerchantCode());
            return response;
        }
        
    }
    
}
