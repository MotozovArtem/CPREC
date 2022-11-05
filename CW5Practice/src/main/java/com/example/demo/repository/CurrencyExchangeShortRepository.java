package com.example.demo.repository;

import com.example.demo.model.CurrencyExchangeShort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeShortRepository
		extends JpaRepository<CurrencyExchangeShort, Integer> {
}
