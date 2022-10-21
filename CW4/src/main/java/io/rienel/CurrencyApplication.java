package io.rienel;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import io.rienel.database.Database;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CurrencyApplication {

	private static final Logger log = LoggerFactory.getLogger(CurrencyApplication.class);

	private static final String APP_NAME = "Currency Viewer";

	public static final Path APP_DB_PATH = Paths.get("db");

	public static void main(String[] args) {
		log.info("{} started", APP_NAME);
		onStart();
		JFrame app = new JFrame(APP_NAME);
		app.setSize(400, 600);
		app.setLayout(null);
		app.setVisible(true);
	}

	public static void onStart() {
		if (!Files.exists(APP_DB_PATH)) {
			try {
				Files.createDirectory(APP_DB_PATH);
			} catch (IOException e) {
				log.error("Cannot create application database directory {}", APP_DB_PATH.toAbsolutePath());
				throw new RuntimeException(e);
			}
		}
	}

	public static void onClose() {
		boolean isClosed = Database.getInstance().closeConnection();
		if (!isClosed) {
			log.warn("Database connection is not closed!!!!");
		}
	}

}