package com.testbank.service.onboarding;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testbank.dto.OnboardingDto;
import com.testbank.model.merchant.MerchantInformation;
import com.testbank.model.user.UserAccount;
import com.testbank.service.merchant.MerchantInformationService;
import com.testbank.service.user.UserAccountService;
import com.testbank.util.exceptions.MerchantAlreadyExistsException;

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


    public OnboardingDto saveUserAndMerchant(OnboardingDto onboardingDto){
        
        UserAccount user = userAccountService.findByUsername(onboardingDto.getUserAccount().getUsername());
        if(user != null){
            throw new MerchantAlreadyExistsException("User with username " + onboardingDto.getUserAccount().getUsername() + " already exists");
        }else{
            UserAccount created = userAccountService.save(new UserAccount(onboardingDto.getUserAccount()));
            MerchantInformation merchantInformation = new MerchantInformation(onboardingDto.getMerchantInformation());
            merchantInformation.setUserAccount(created);
            merchantInformationService.save(merchantInformation);

        }
        return onboardingDto;

        
    }
    
}
