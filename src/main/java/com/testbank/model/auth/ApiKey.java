package com.testbank.model.auth;


import com.testbank.model.user.UserAccount;
import com.testbank.util.enums.ApiKeyStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table
@Entity
public class ApiKey {

    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long id;


    @Column(name="value")
    private String value;
    
    
    @ManyToOne(fetch = jakarta.persistence.FetchType.LAZY,optional = false)
    @JoinColumn(name = "user_account_id", nullable = false)
    private UserAccount userAccount;


    @Column
    private ApiKeyStatus status;


    @Column
    private String callbackUrl;
}