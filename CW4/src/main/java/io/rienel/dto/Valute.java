package io.rienel.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import io.rienel.util.DoubleDeserializer;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("NotNullFieldNotInitialized")
public class Valute {

	@JacksonXmlProperty(localName = "ID")
	@NotNull
	private String id;

	@JacksonXmlProperty(localName = "NumCode")
	@NotNull
	private Integer numCode;

	@JacksonXmlProperty(localName = "CharCode")
	@NotNull
	private String charCode;

	@JacksonXmlProperty(localName = "Nominal")
	@NotNull
	private Integer nominal;

	@JacksonXmlProperty(localName = "Name")
	@NotNull
	private String name;

	@JacksonXmlProperty(localName = "Value")
	@JsonDeserialize(using = DoubleDeserializer.class)
	@NotNull
	private Double value;

	public Valute() {
	}

	public Valute(@NotNull String id,
	              @NotNull Integer numCode,
	              @NotNull String charCode,
	              @NotNull Integer nominal,
	              @NotNull String name,
	              @NotNull Double value) {
		this.id = id;
		this.numCode = numCode;
		this.charCode = charCode;
		this.nominal = nominal;
		this.name = name;
		this.value = value;
	}

	public @NotNull String getId() {
		return id;
	}

	public void setId(@NotNull String id) {
		this.id = id;
	}

	public @NotNull Integer getNumCode() {
		return numCode;
	}

	public void setNumCode(@NotNull Integer numCode) {
		this.numCode = numCode;
	}

	public @NotNull String getCharCode() {
		return charCode;
	}

	public void setCharCode(@NotNull String charCode) {
		this.charCode = charCode;
	}

	public @NotNull Integer getNominal() {
		return nominal;
	}

	public void setNominal(@NotNull Integer nominal) {
		this.nominal = nominal;
	}

	public @NotNull String getName() {
		return name;
	}

	public void setName(@NotNull String name) {
		this.name = name;
	}

	public @NotNull Double getValue() {
		return value;
	}

	public void setValue(@NotNull Double value) {
		this.value = value;
	}
}
