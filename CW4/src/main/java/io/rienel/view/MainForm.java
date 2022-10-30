package io.rienel.view;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.List;

import io.rienel.controller.CentralBankOfRussiaCurrencyExchangeController;
import io.rienel.controller.CurrencyExchangeController;
import io.rienel.model.CurrencyExchange;
import io.rienel.view.action.AboutAction;
import io.rienel.view.action.ExitAction;
import io.rienel.view.action.ExportToCsvAction;
import io.rienel.view.action.ExportToJsonAction;
import io.rienel.view.model.CurrencyExchangeTableModel;

public class MainForm extends JFrame {

	private final JPanel content;
	private final JTable currencyTable;
	private final JMenuBar menuBar;
	private final JMenu fileMenu;
	private final JMenuItem exportToCsvMenuItem;
	private final JMenuItem exportToJsonMenuItem;
	private final JMenuItem exitMenuItem;
	private final JMenu helpMenu;
	private final JMenuItem aboutMenuItem;
	private final JButton updateButton;

	private final CurrencyExchangeController currencyExchangeController;

	private static final int MAIN_FORM_HORIZONTAL_GAP = 10;
	private static final int MAIN_FORM_VERTICAL_GAP = 10;

	public MainForm(String title) {
		super(title);

		currencyExchangeController = CentralBankOfRussiaCurrencyExchangeController.getInstance();

		content = new JPanel(new BorderLayout(MAIN_FORM_HORIZONTAL_GAP, MAIN_FORM_VERTICAL_GAP));

		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		exportToCsvMenuItem = new JMenuItem("Export to CSV");
		exportToCsvMenuItem.setAction(new ExportToCsvAction(this));
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
		currencyTable.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(currencyTable);
		content.add(scrollPane, BorderLayout.CENTER);

		updateButton = new JButton("Update");
		updateButton.addActionListener(this::onUpdateButtonClick);
		JPanel updatePanel = new JPanel();
		BoxLayout boxLayout = new BoxLayout(updatePanel, BoxLayout.LINE_AXIS);
		updatePanel.setLayout(boxLayout);
		updatePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
		updatePanel.add(Box.createHorizontalGlue());
		updatePanel.add(updateButton);
		updateTableContent();
		content.add(updatePanel, BorderLayout.NORTH);

		this.setJMenuBar(menuBar);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(content);
		this.pack();
		this.setSize(500, 700);
	}

	public void onUpdateButtonClick(ActionEvent e) {
		currencyExchangeController.updateCurrency(LocalDate.now());
		updateTableContent();
	}

	public void updateTableContent() {
		List<CurrencyExchange> allCurrencyExchanges = currencyExchangeController.getAllCurrencyExchanges();
		currencyTable.setModel(new CurrencyExchangeTableModel(allCurrencyExchanges));
	}
}
