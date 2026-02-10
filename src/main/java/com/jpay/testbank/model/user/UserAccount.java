package com.jpay.testbank.model.user;


import com.jpay.testbank.dto.UserAccountRequestDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table
@Entity
@Data
public class UserAccount {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "password")
    private String password;
    @Column(name = "username")
    private String username;

    public UserAccount() {
    }


    public UserAccount(UserAccountRequestDto dto){
        this.fullName = dto.getFullName();
        this.password = dto.getPassword();
        this.username = dto.getUsername();
    }
}
