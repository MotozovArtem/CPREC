package io.rienel.view.action;

import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.KeyboardFocusManager;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

public class ExitAction extends AbstractAction {

	public ExitAction() {
		super("Exit");
		putValue(Action.MNEMONIC_KEY, KeyEvent.VK_X);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Window w = KeyboardFocusManager.getCurrentKeyboardFocusManager().getActiveWindow();
		if (w != null) {
			WindowEvent closing = new WindowEvent(w, WindowEvent.WINDOW_CLOSING);
			w.dispatchEvent(closing);
		}
	}
}
