package io.rienel.ui.action;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import io.rienel.CurrencyApplication;

public class AboutAction extends AbstractAction {

	private final Component parent;

	public AboutAction(Component parent) {
		super("About");
		this.parent = parent;
		putValue(MNEMONIC_KEY, KeyEvent.VK_A);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(parent, """
                %s
                Made by Motozov Artyom
                Sources - https://github.com/MotozovArtyom/CPREC/tree/master/CW4
                """.formatted(CurrencyApplication.APP_NAME));
	}
}
