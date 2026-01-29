package com.testbank.service.merchant;
import com.testbank.repository.merchant.MerchantInformationDao;
import org.springframework.stereotype.Service;

import com.testbank.model.merchant.MerchantInformation;

@Service
public class MerchantInformationServiceImpl implements MerchantInformationService {

    private final MerchantInformationDao merchantInformationDao;

    MerchantInformationServiceImpl(MerchantInformationDao merchantInformationDao) {
        this.merchantInformationDao = merchantInformationDao;
    }

    @Override
    public MerchantInformation save(MerchantInformation merchantInformation){
        return merchantInformationDao.save(merchantInformation);
    }
}
