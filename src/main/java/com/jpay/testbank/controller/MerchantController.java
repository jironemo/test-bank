package com.jpay.testbank.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpay.testbank.dto.DynamicQRRequestDto;
import com.jpay.testbank.service.merchant.MerchantInformationService;

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


    @PostMapping("generate-dynamic-qr")
    public ResponseEntity<byte[]> generateQRTest(@RequestBody DynamicQRRequestDto dynamicQRRequestDto ){
        System.out.println("Generating dynamic QR for merchant ID: " + dynamicQRRequestDto.getMerchantId() + ", Amount: " + dynamicQRRequestDto.getAmount());
        byte[] qrCodeImage = merchantAccountService.generateMerchantDynamicQRCode(dynamicQRRequestDto);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).cacheControl(CacheControl.noCache()).body(qrCodeImage);



    }

}
