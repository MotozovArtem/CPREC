package io.rienel.ui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;

import io.rienel.ui.action.AboutAction;
import io.rienel.ui.action.ExitAction;
import io.rienel.ui.action.ExportToCSVAction;
import io.rienel.ui.action.ExportToJsonAction;

public class MainForm extends JFrame {

	private JPanel content;
	private  JTable currencyTable;
	private final JMenuBar menuBar;
	private final JMenu fileMenu;
	private final JMenuItem exportToCsvMenuItem;
	private final JMenuItem exportToJsonMenuItem;
	private final JMenuItem exitMenuItem;
	private final JMenu helpMenu;
	private final JMenuItem aboutMenuItem;


	public MainForm(String title) {
		super(title);

		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		exportToCsvMenuItem = new JMenuItem("Export to CSV");
		exportToCsvMenuItem.setAction(new ExportToCSVAction(this));
		fileMenu.add(exportToCsvMenuItem);
		exportToJsonMenuItem = new JMenuItem("Export to JSON");
		exportToJsonMenuItem.setAction(new ExportToJsonAction(this));
		fileMenu.add(exportToJsonMenuItem);
		exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.setAction(new ExitAction());
		fileMenu.addSeparator();
		fileMenu.add(exitMenuItem);

		helpMenu = new JMenu("Help");
		menuBar.add(helpMenu);
		aboutMenuItem = new JMenuItem("About");
		aboutMenuItem.setAction(new AboutAction(this));
		helpMenu.add(aboutMenuItem);

		currencyTable = new JTable();

		this.setJMenuBar(menuBar);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(content);
		this.pack();
		this.setSize(500, 700);
	}
}
