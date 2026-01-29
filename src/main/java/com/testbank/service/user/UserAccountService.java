package com.testbank.service.user;

import com.testbank.model.user.UserAccount;

public interface UserAccountService {
    public UserAccount findByUsername(String username);
    public UserAccount find(Long id);
    public UserAccount save(UserAccount userAccount);

}
