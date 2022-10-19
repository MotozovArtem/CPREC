package io.rienel.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Valute {
	@JacksonXmlProperty(localName = "ID")
	private String id;
	@JacksonXmlProperty(localName = "NumCode")
	private Integer numCode;
	@JacksonXmlProperty(localName = "CharCode")
	private String charCode;
	@JacksonXmlProperty(localName = "Nominal")
	private String nominal;
	@JacksonXmlProperty(localName = "Name")
	private String name;
	@JacksonXmlProperty(localName = "Value")
	private String value;

	public Valute() {
	}

	public Valute(String id, Integer numCode, String charCode, String nominal, String name, String value) {
		this.id = id;
		this.numCode = numCode;
		this.charCode = charCode;
		this.nominal = nominal;
		this.name = name;
		this.value = value;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getNumCode() {
		return numCode;
	}

	public void setNumCode(Integer numCode) {
		this.numCode = numCode;
	}

	public String getCharCode() {
		return charCode;
	}

	public void setCharCode(String charCode) {
		this.charCode = charCode;
	}

	public String getNominal() {
		return nominal;
	}

	public void setNominal(String nominal) {
		this.nominal = nominal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
