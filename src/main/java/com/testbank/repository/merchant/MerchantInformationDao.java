package com.testbank.repository.merchant;

import org.springframework.data.jpa.repository.JpaRepository;
import com.testbank.model.merchant.MerchantInformation;

public interface MerchantInformationDao extends JpaRepository<MerchantInformation, Long> {


}
