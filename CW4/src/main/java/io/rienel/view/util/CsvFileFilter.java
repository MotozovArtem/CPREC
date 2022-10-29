package io.rienel.view.util;

import java.util.List;

public class CsvFileFilter extends AbstractFileFilter {

	private final List<String> acceptableFileFormats = List.of(
			"csv"
	);

	@Override
	public String getDescription() {
		return "Comma Separated Value File";
	}

	@Override
	protected List<String> getAcceptableFileFormats() {
		return acceptableFileFormats;
	}
}
