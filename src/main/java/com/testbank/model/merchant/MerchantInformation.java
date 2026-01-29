package com.testbank.model.merchant;

import com.testbank.dto.MerchantInformationDto;
import com.testbank.model.user.UserAccount;
import com.testbank.util.enums.MerchantStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;



@Entity
@Table(name = "merchant_information",uniqueConstraints = {
        @UniqueConstraint(columnNames = "user_account_id"),
        @UniqueConstraint(columnNames = "merchant_code")
    })
    @Data
public class MerchantInformation {
    
    public MerchantInformation() {
    }
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "merchant_name")
    private String merchantName;

    @Column(name = "merchant_address")
    private String merchantAddress;
    
    @Column(name = "org_name")
    private String orgName;


    @Column(name = "merchant_code")
    private String merchantCode;

    @Column(name = "status")
    private MerchantStatus status;


    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "qr_string", length = 2000)
    private String qrString;
    
    @OneToOne(fetch = jakarta.persistence.FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_account_id", nullable = false, unique = true)
    private UserAccount userAccount;



    public MerchantInformation(MerchantInformationDto merchantInformationDto) {
        this.orgName = merchantInformationDto.getOrgName();
        this.merchantCode = merchantInformationDto.getMerchantCode();
        this.createdAt = merchantInformationDto.getCreatedAt();
        this.status = merchantInformationDto.getStatus();
        this.merchantAddress = merchantInformationDto.getAddress();
        this.merchantName = merchantInformationDto.getOrgName();
    }


    public String toQrString(){
        return "MERCHANT|" +
                "NAME:" + this.merchantName + "|" +
                "CODE:" + this.merchantCode + "|" +
                "ADDRESS:" + this.merchantAddress + "|" +
                "ORG:" + this.orgName;
    }
}
