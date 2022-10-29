package io.rienel.view.action;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import io.rienel.CurrencyApplication;
import io.rienel.view.util.CsvFileFilter;

public class ExportToCSVAction extends AbstractAction {

	private final Component parent;

	public ExportToCSVAction(Component parent) {
		super("Export to CSV");
		this.parent = parent;
		putValue(MNEMONIC_KEY, KeyEvent.VK_C);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser fileChooser = new JFileChooser(CurrencyApplication.USER_HOME_PATH.toFile());
		fileChooser.setFileFilter(new CsvFileFilter());
		int returnValue = fileChooser.showSaveDialog(parent);
		if (returnValue == JFileChooser.APPROVE_OPTION) {

		}
	}
}
