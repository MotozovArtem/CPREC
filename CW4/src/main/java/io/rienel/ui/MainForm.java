package io.rienel.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainForm extends JFrame {

	private JPanel content;

	public MainForm(String title) {
		super(title);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(content);
		this.pack();
		this.setSize(500, 700);
	}
}
