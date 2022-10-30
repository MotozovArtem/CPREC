package io.rienel;

import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import io.rienel.database.Database;
import io.rienel.view.MainForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CurrencyApplication {

	private static final Logger log = LoggerFactory.getLogger(CurrencyApplication.class);
	private static final String USER_HOME = System.getProperty("user.home");

	public static final String APP_NAME = "Currency Viewer";
	public static final String APP_VERSION = "1.0-SNAPSHOT";
	public static final String APP_FULL_NAME = String.format("%s v.%s", APP_NAME, APP_VERSION);
	public static final Path USER_HOME_PATH = Paths.get(USER_HOME != null ? USER_HOME : "./");
	public static final Path APP_DB_PATH = Paths.get("db");

	public static void main(String[] args) {
		log.info("{} started", APP_NAME);
		log.info("Version: {}", APP_VERSION);
		onStart();
		JFrame app = new MainForm(APP_FULL_NAME);
		app.setVisible(true);
		app.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				onClose();
			}
		});
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