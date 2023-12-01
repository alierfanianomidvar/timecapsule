package com.today.timecapsule.business.mapper;

import com.unipd.semicolon.core.domain.AccountResponse;
import com.unipd.semicolon.core.entity.Login;

public class AccountMapper {

    public static AccountResponse loginMapper(Login login) {
        return new AccountResponse(
                login.getUsername(),
                login.getToken(),
                login.getLastLoginDate(),
                login.getUser());
    }
}
