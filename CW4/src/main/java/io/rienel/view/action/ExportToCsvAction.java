package io.rienel.view.action;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import io.rienel.CurrencyApplication;
import io.rienel.export.CurrencyExchangeCsvExportService;
import io.rienel.export.ExportService;
import io.rienel.model.CurrencyExchange;
import io.rienel.repository.CurrencyExchangeRepository;
import io.rienel.repository.impl.CurrencyExchangeRepositorySqliteImpl;
import io.rienel.view.util.CsvFileFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExportToCsvAction extends AbstractAction {

	private static final Logger log = LoggerFactory.getLogger(ExportToCsvAction.class);
	public static final String DEFAULT_EXPORT_FILE_NAME = String.format("currency_%s.csv", LocalDate.now().format(DateTimeFormatter.ISO_DATE));

	private final Component parent;
	private final ExportService<CurrencyExchange> csvCurrencyExportService;
	private final CurrencyExchangeRepository currencyExchangeRepository;

	public ExportToCsvAction(Component parent) {
		super("Export to CSV");
		this.parent = parent;
		this.csvCurrencyExportService = new CurrencyExchangeCsvExportService();
		this.currencyExchangeRepository = CurrencyExchangeRepositorySqliteImpl.getInstance();
		putValue(MNEMONIC_KEY, KeyEvent.VK_C);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JFileChooser fileChooser = new JFileChooser(CurrencyApplication.USER_HOME_PATH.toFile());
		fileChooser.setFileFilter(new CsvFileFilter());
		fileChooser.setSelectedFile(CurrencyApplication.USER_HOME_PATH.resolve(DEFAULT_EXPORT_FILE_NAME).toFile());
		int returnValue = fileChooser.showSaveDialog(parent);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			log.info("Start exporting CurrencyExchange to CSV file");
			File selectedFile = fileChooser.getSelectedFile();
			List<CurrencyExchange> allCurrencies = currencyExchangeRepository.findAll();
			String fileContent = csvCurrencyExportService.export(allCurrencies);
			try (FileWriter writer = new FileWriter(selectedFile)) {
				writer.write(fileContent);
			} catch (IOException e) {
				log.error("Error while exporting currency exchange to CSV", e);
			}
			log.info("Export to CSV successfully. Exported {} objects", allCurrencies.size());
		}
	}
}
