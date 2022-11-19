package io.rienel;

import java.util.Date;

/**
 * TODO ArMotozov
 *
 * @since 11/19/2022
 */
public class Valute {
	private String id;
	private double value;
	private int nominal;
	private String currencyCode;
	private String currencyName;
	private Date date;

	public Valute() {
	}

	public Valute(String id, double value, int nominal, String currencyName, String currencyCode, Date date) {
		this.id = id;
		this.value = value;
		this.nominal = nominal;
		this.currencyName = currencyName;
		this.currencyCode = currencyCode;
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getNominal() {
		return nominal;
	}

	public void setNominal(int nominal) {
		this.nominal = nominal;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
