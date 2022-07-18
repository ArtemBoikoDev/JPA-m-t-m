package com.quick.repository;

import com.quick.entity.Tariff;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TariffRepository extends JpaRepository<Tariff, Integer> {
    @Query("FROM Tariff tar JOIN FETCH tar.accounts acc WHERE acc.id = ?1")
    List<Tariff> findAllByAccountId(int t);
}
