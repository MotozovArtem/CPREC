package io.rienel.util;

import java.io.File;
import java.util.Objects;

import org.jetbrains.annotations.NotNull;

public final class FileExtensionUtils {
	private FileExtensionUtils() {
	}

	/**
	 * Get file extension.
	 *
	 * @param file File object. Not null
	 * @return File extension or empty string if file doesn't have extension.
	 */
	public static @NotNull String getExtension(@NotNull File file) {
		Objects.requireNonNull(file);

		return getExtension(file.getName());
	}

	/**
	 * Get file extension.
	 *
	 * @param fileName filename Not null
	 * @return File extension or empty string if file doesn't have extension.
	 */
	public static @NotNull String getExtension(@NotNull String fileName) {
		Objects.requireNonNull(fileName);

		final String ext;
		final int i = fileName.lastIndexOf('.');
		if (i > 0 && i < fileName.length() - 1) {
			ext = fileName.substring(i + 1).toLowerCase();
		} else {
			ext = Strings.EMPTY_STRING;
		}
		return ext;
	}
}
