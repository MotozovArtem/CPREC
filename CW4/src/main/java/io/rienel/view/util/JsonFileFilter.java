package io.rienel.view.util;

import java.util.List;

public class JsonFileFilter extends AbstractFileFilter {

	private final List<String> acceptableFileFormats = List.of(
			"json"
	);

	@Override
	protected List<String> getAcceptableFileFormats() {
		return acceptableFileFormats;
	}

	@Override
	public String getDescription() {
		return "JavaScript Object Notation File (*.json)";
	}
}
