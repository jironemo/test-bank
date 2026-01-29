package com.testbank.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testbank.service.merchant.MerchantInformationService;

@RestController
@RequestMapping("/api/merchant")
public class MerchantController {

    MerchantInformationService merchantAccountService;

    public MerchantController(@Autowired MerchantInformationService merchantAccountService){
        this.merchantAccountService = merchantAccountService;
    }

    @GetMapping("health-check")
    public String merchantHealthCheck(){
        return "Merchant endpoint is working!";
    }

}
