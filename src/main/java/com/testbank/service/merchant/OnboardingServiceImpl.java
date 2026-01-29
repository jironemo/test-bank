package com.testbank.service.merchant;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testbank.dto.OnboardingDto;
import com.testbank.model.merchant.MerchantInformation;
import com.testbank.model.user.UserAccount;
import com.testbank.repository.merchant.MerchantInformationDao;
import com.testbank.repository.merchant.UserAccountDao;

@Service
public class OnboardingServiceImpl implements OnboardingService {


    UserAccountDao userAccountDao;
    MerchantInformationDao merchantInformationDao;

    public OnboardingServiceImpl(@Autowired UserAccountDao userAccountDao,@Autowired MerchantInformationDao merchantInformationDao){
        this.userAccountDao = userAccountDao;
        this.merchantInformationDao = merchantInformationDao;
    }
    public OnboardingDto saveUserAndMerchant(OnboardingDto onboardingDto){
        
        Optional<UserAccount> user = userAccountDao.findByUsername(onboardingDto.getUserAccount().getUsername());
        if(user.isPresent()){
            return  null;
        }else{
            UserAccount created = userAccountDao.save(new UserAccount(onboardingDto.getUserAccount()));
            MerchantInformation merchantInformation = new MerchantInformation(onboardingDto.getMerchantInformation());
            merchantInformation.setUserAccount(created);
            merchantInformationDao.save(merchantInformation);

        }
        return onboardingDto;

        
    }
    
}
