package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "currency_exchange_short")
public class CurrencyExchangeShort {
	@Id
	private Integer id;
	@Column(name = "_value")
	private Double value;
	@Column(name = "currency_code")
	private String currencyCode;

	public CurrencyExchangeShort() {
	}

	public CurrencyExchangeShort(Integer id, Double value, String currencyCode) {
		this.id = id;
		this.value = value;
		this.currencyCode = currencyCode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
}
