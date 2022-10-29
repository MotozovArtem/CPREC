package io.rienel.ui.action;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import io.rienel.CurrencyApplication;
import io.rienel.ui.util.JsonFileFilter;

public class ExportToJsonAction extends AbstractAction {

	private final Component parent;

	public ExportToJsonAction(Component parent) {
		super("Export to JSON");
		this.parent = parent;
		putValue(MNEMONIC_KEY, KeyEvent.VK_J);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser fileChooser = new JFileChooser(CurrencyApplication.USER_HOME_PATH.toFile());
		fileChooser.setFileFilter(new JsonFileFilter());
		int returnValue = fileChooser.showSaveDialog(parent);
		if (returnValue == JFileChooser.APPROVE_OPTION) {

		}
	}
}
