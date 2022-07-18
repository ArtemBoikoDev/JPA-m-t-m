package com.quick.service.impl;

import com.quick.entity.Tariff;
import com.quick.repository.TariffRepository;
import com.quick.service.TariffService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TariffServiceImpl implements TariffService {
    private final TariffRepository tariffRepository;

    public TariffServiceImpl(TariffRepository tariffRepository) {
        this.tariffRepository = tariffRepository;
    }

    @Override
    public List<Tariff> findAll() {
        return tariffRepository.findAll();
    }

    @Override
    public Tariff create(Tariff tariff) {
        return tariffRepository.save(tariff);
    }

    @Override
    public List<Tariff> findAllByAccount(int accountId) {
        return tariffRepository.findAllByAccountId(accountId);
    }
}
