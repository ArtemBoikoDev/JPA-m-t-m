package com.quick.service;

import com.quick.entity.Account;
import java.util.List;

public interface UserService {
    List<Account> findAll();

    Account create(Account account);

    Account addTariffToUser(int accountId, int tariffId);
}
