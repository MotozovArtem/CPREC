package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.CurrencyExchangeShort;
import com.example.demo.repository.CurrencyExchangeShortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeShortController {

	@Autowired
	private CurrencyExchangeShortRepository repository;

	@GetMapping("/currencies")
	public List<CurrencyExchangeShort> getAllCurrencies() {
		return repository.findAll();
	}
}
