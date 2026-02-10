package com.jpay.testbank.repository.merchant;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpay.testbank.model.user.UserAccount;

public interface UserAccountDao  extends JpaRepository<UserAccount, Long>{
    public Optional<UserAccount> findByUsername(String username);
}
