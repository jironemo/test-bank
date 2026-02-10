package com.jpay.testbank.repository.merchant;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jpay.testbank.model.merchant.MerchantInformation;

public interface MerchantInformationDao extends JpaRepository<MerchantInformation, Long> {


}
