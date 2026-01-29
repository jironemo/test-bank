package com.testbank.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testbank.model.user.UserAccount;
import com.testbank.repository.merchant.UserAccountDao;


@Service
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountDao userAccountDao;


    public UserAccountServiceImpl(@Autowired UserAccountDao userAccountDao){
        this.userAccountDao = userAccountDao;

    }
    @Override
    public UserAccount findByUsername(String username) {
        return userAccountDao.findByUsername(username).orElse(null);
    }


    @Override
    public UserAccount find(Long id){
        return userAccountDao.findById(id).orElse(null);
    }

    @Override
    public UserAccount save(UserAccount userAccount) {
        return userAccountDao.save(userAccount);
    }
    
    
}
