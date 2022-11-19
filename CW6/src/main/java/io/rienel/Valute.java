package io.rienel;

import java.util.Date;
import java.util.Objects;

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

	public Valute(String id, double value, int nominal, String currencyCode, String currencyName, Date date) {
		this.id = id;
		this.value = value;
		this.nominal = nominal;
		this.currencyCode = currencyCode;
		this.currencyName = currencyName;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Valute valute = (Valute)o;

		if (Double.compare(valute.value, value) != 0) return false;
		if (nominal != valute.nominal) return false;
		if (!Objects.equals(id, valute.id)) return false;
		if (!Objects.equals(currencyCode, valute.currencyCode))
			return false;
		if (!Objects.equals(currencyName, valute.currencyName))
			return false;
		return Objects.equals(date, valute.date);
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = id != null ? id.hashCode() : 0;
		temp = Double.doubleToLongBits(value);
		result = 31 * result + (int)(temp ^ (temp >>> 32));
		result = 31 * result + nominal;
		result = 31 * result + (currencyCode != null ? currencyCode.hashCode() : 0);
		result = 31 * result + (currencyName != null ? currencyName.hashCode() : 0);
		result = 31 * result + (date != null ? date.hashCode() : 0);
		return result;
	}
}
