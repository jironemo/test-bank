package com.jpay.testbank.service.user;

import com.jpay.testbank.model.user.UserAccount;

public interface UserAccountService {
    public UserAccount findByUsername(String username);
    public UserAccount find(Long id);
    public UserAccount save(UserAccount userAccount);

}
