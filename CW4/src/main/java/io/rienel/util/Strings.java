package io.rienel.util;

import java.io.PrintWriter;
import java.io.StringWriter;

public final class Strings {
	public static final String EMPTY_STRING = "";

	// Predefined strings used for logging:
	public static final String NL = Strings.getLineSeparator();

	private Strings() {
		// forbidden
	}

	public static String nullToEmpty(String string) {
		return string == null ? Strings.EMPTY_STRING : string;
	}

	public static String emptyToNull(String string) {
		return isNullOrEmpty(string) ? null : string;
	}

	public static boolean isNullOrEmpty(String string) {
		return string == null || string.isEmpty();
	}

	public static String getLineSeparator() {
		String lineSeparator = System.getProperty("line.separator");
		if (Strings.isNullOrEmpty(lineSeparator))
			lineSeparator = "\n";
		return lineSeparator;
	}

	public static String exceptionToString(Throwable error, String usedNewLine) {
		if (error == null)
			return Strings.EMPTY_STRING;

		StringWriter errWriter = new StringWriter();
		error.printStackTrace(new PrintWriter(errWriter));
		String result = errWriter.toString();

		if (!Strings.isNullOrEmpty(usedNewLine) && !NL.equals(usedNewLine))
			result = result.replace(Strings.NL, usedNewLine);
		return result;
	}

	public static boolean hasDigitsOnly(String string) {
		if (isNullOrEmpty(string))
			return false;
		for (char c : string.toCharArray())
			if (!Character.isDigit(c))
				return false;
		return true;
	}

	public static void requireNotEmpty(String string, String message) {
		if (Strings.isNullOrEmpty(string)) {
			throw new IllegalArgumentException(message);
		}
	}
}
