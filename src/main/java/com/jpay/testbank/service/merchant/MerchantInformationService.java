package com.jpay.testbank.service.merchant;

import com.jpay.testbank.dto.DynamicQRRequestDto;
import com.jpay.testbank.model.merchant.MerchantInformation;

public interface MerchantInformationService {
    public MerchantInformation save(MerchantInformation merchantInformation);
    public byte[] generateMerchantDynamicQRCode(DynamicQRRequestDto dynamicQRRequestDto);
}
