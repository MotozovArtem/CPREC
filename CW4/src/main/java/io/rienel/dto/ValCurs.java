package io.rienel.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import org.jetbrains.annotations.NotNull;

public class ValCurs {
	@JacksonXmlProperty(isAttribute = true, localName = "Date")
	@JsonFormat
			(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
	private Date date;

	@JacksonXmlProperty(isAttribute = true)
	private String name;

	@JacksonXmlProperty(localName = "Valute")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<Valute> valutes;

	public ValCurs() {
	}

	public ValCurs(@NotNull Date date, @NotNull String name, @NotNull List<Valute> valutes) {
		this.date = date;
		this.name = name;
		this.valutes = valutes;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Valute> getValutes() {
		return valutes;
	}

	public void setValutes(List<Valute> valutes) {
		this.valutes = valutes;
	}
}
