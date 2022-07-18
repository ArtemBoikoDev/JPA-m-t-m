package com.quick.service.impl;

import com.quick.entity.Account;
import com.quick.entity.Tariff;
import com.quick.repository.TariffRepository;
import com.quick.repository.UserRepository;
import com.quick.service.UserService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final TariffRepository tariffRepository;

    public UserServiceImpl(UserRepository userRepository, TariffRepository tariffRepository) {
        this.userRepository = userRepository;
        this.tariffRepository = tariffRepository;
    }

    @Override
    public Account create(Account account) {
        return userRepository.save(account);
    }

    @Override
    public Account addTariffToUser(int accountId, int tariffID) {
        Account account = userRepository.findById(accountId)
                                        .orElseThrow(() -> new RuntimeException("No user with id:" +
                                                                                accountId));
        System.out.println("account = " + account);
        Tariff tariff = tariffRepository.findById(tariffID)
                                        .orElseThrow(() -> new RuntimeException("No tariff with id:" +
                                                                                tariffID));
        System.out.println("tariff = " + tariff);
        account.addTariff(tariff);
        return userRepository.save(account);
    }

    @Override
    public List<Account> findAll() {
        return userRepository.findAll();
    }
}
