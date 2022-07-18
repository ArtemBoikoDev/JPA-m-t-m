package com.quick.service;

import com.quick.entity.Tariff;
import java.util.List;

public interface TariffService {
    List<Tariff> findAll();

    Tariff create(Tariff tariff);

    List<Tariff> findAllByAccount(int accountId);
}
