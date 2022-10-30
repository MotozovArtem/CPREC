package io.rienel.view.util;

import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.util.List;
import java.util.Objects;

import io.rienel.util.FileExtensionUtils;
import io.rienel.util.Strings;

public abstract class AbstractFileFilter extends FileFilter {

	protected abstract List<String> getAcceptableFileFormats();

	@Override
	public boolean accept(File f) {
		Objects.requireNonNull(f);

		final String extension = FileExtensionUtils.getExtension(f);
		if (Strings.isNullOrEmpty(extension)) {
			return false;
		}
		return getAcceptableFileFormats().stream()
				.anyMatch(ext -> ext.equals(extension));
	}
}
