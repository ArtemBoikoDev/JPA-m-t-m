package com.quick.rest;

import com.quick.entity.Tariff;
import com.quick.service.TariffService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tariffs")
public class TariffController {
    private final TariffService tariffService;

    public TariffController(TariffService tariffService) {
        this.tariffService = tariffService;
    }

    @PostMapping(consumes = "application/json",
                 produces = "application/json")
    public Tariff create(@RequestBody Tariff tariff) {
        return tariffService.create(tariff);
    }

    @GetMapping(produces = "application/json")
    public List<Tariff> findAll() {
        return tariffService.findAll();
    }

    @GetMapping(value = "/account/{accountId}",
                produces = "application/json")
    public List<Tariff> findAllByAccountId(@PathVariable("accountId") int accountId) {
        List<Tariff> allByAccount = tariffService.findAllByAccount(accountId);
        allByAccount.forEach(tariff -> System.out.println("tariff result = " + tariff));
        return allByAccount;
    }
}
