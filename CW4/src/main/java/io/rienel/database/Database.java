package io.rienel.database;

import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import io.rienel.CurrencyApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Database {

	private static final Logger log = LoggerFactory.getLogger(Database.class);

	private static Database instance;

	private static final String JDBC_URL = "jdbc:sqlite:db/storage.db";

	private static final String SCHEMA_SQL = """
			CREATE TABLE IF NOT EXISTS currency_exchange (
			    id INTEGER PRIMARY KEY AUTOINCREMENT,
			    "value" REAL NOT NULL,
			    nominal INTEGER NOT NULL,
			    currency_name VARCHAR(100) NOT NULL,
			    currency_code VARCHAR(3) NOT NULL,
			    "date" DATE NOT NULL
			);""";

	private Connection connection;

	private Database() {
	}

	public static Database getInstance() {
		if (instance == null) {
			log.debug("Initializing...");
			instance = new Database();
			log.debug("Initialized...");
		}
		return instance;
	}

	public Connection getConnection() {
		if (connection == null) {
			try {
				log.info("Creating connection to database {}", JDBC_URL);
				prepareDirectory();
				connection = DriverManager.getConnection(JDBC_URL);
				connection.setAutoCommit(true);
				initDb();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return connection;
	}

	private void prepareDirectory() {
		if (!Files.exists(CurrencyApplication.APP_DB_PATH)) {
			try {
				Files.createDirectory(CurrencyApplication.APP_DB_PATH);
			} catch (IOException e) {
				log.error("Cannot create application database directory {}", CurrencyApplication.APP_DB_PATH.toAbsolutePath());
				throw new RuntimeException(e);
			}
		}
	}

	private void initDb() {
		try (PreparedStatement statement = connection.prepareStatement(SCHEMA_SQL)) {
			statement.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean closeConnection() {
		if (connection != null) {
			log.info("Closing connection to database {}", JDBC_URL);
			try {
				connection.close();
			} catch (SQLException e) {
				log.error("Cannot close database connection", e);
				try {
					// Finally
					connection.close();
				} catch (SQLException ex) {
					log.error("Cannot finally close database connection", e);
					throw new RuntimeException(ex);
				}
				throw new RuntimeException(e);
			}
			connection = null;
			return true;
		}
		return false;
	}
}
