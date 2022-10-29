package io.rienel.view.util;

import java.io.File;

import io.rienel.util.Strings;

public final class FileExtensionUtils {
	private FileExtensionUtils() {
	}

	/**
	 * Get file extension.
	 *
	 * @param f File object. Not null
	 * @return File extension or empty string if file doesn't have extension.
	 */
	public static String getExtension(File f) {
		final String ext;
		final String s = f.getName();
		final int i = s.lastIndexOf('.');
		if (i > 0 && i < s.length() - 1) {
			ext = s.substring(i + 1).toLowerCase();
		} else {
			ext = Strings.EMPTY_STRING;
		}
		return ext;
	}
}
