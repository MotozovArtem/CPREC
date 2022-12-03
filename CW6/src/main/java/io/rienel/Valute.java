package io.rienel;

import java.util.Date;

/**
 * TODO ArMotozov
 *
 * @since 11/19/2022
 */
public class Valute {

	public enum Columns {
		ID,
		VALUE,
		NOMINAL,
		CURRENCY_NAME,
		CURRENCY_CODE,
		DATE
	}

	private String id;
	private double value; // никогда не могут быть null (примитивный тип)
	// private Double value; // null может быть (ссылочный)
	private int nominal;
	private String currencyName;
	private String currencyCode;
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

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		// %s - String
		// %d - integer
		// %f - float and double
		return String.format("%s %s Рублей = %s %s (%s)",
				id != null && !id.isEmpty() ? id : "NULL",
				value != 0.00 ? String.format("%.2f", value) : "NULL",
				nominal != 0 ? Integer.toString(nominal) : "NULL",
				currencyName != null && !currencyName.isEmpty() ? currencyName : "NULL",
				currencyCode != null && !currencyCode.isEmpty() ? currencyCode : "NULL");
	}
}
