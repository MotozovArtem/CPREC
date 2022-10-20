package io.rienel.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("NotNullFieldNotInitialized")
public class ValCurs {
	@JacksonXmlProperty(isAttribute = true, localName = "Date")
	@JsonFormat
			(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
	@NotNull
	private Date date;

	@JacksonXmlProperty(isAttribute = true)
	@NotNull
	private String name;

	@JacksonXmlProperty(localName = "Valute")
	@JacksonXmlElementWrapper(useWrapping = false)
	@NotNull
	private List<Valute> valuteList;

	public ValCurs() {
	}

	public ValCurs(@NotNull Date date, @NotNull String name, @NotNull List<Valute> valutes) {
		this.date = date;
		this.name = name;
		this.valuteList = valutes;
	}

	public @NotNull Date getDate() {
		return date;
	}

	public void setDate(@NotNull Date date) {
		this.date = date;
	}

	public @NotNull String getName() {
		return name;
	}

	public void setName(@NotNull String name) {
		this.name = name;
	}

	public @NotNull List<Valute> getValuteList() {
		return valuteList;
	}

	public void setValuteList(@NotNull List<Valute> valuteList) {
		this.valuteList = valuteList;
	}
}
