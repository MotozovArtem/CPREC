package io.rienel.database

import APP_DB_PATH
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.IOException
import java.nio.file.Files
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object Database {
	private val log: Logger = LoggerFactory.getLogger(Database::class.java);

	const val JDBC_URL = "jdbc:sqlite:db/storage.db"

	private val SCHEMA_SQL: String = """
			CREATE TABLE IF NOT EXISTS currency_exchange (
			    id INTEGER PRIMARY KEY AUTOINCREMENT,
			    "value" REAL NOT NULL,
			    nominal INTEGER NOT NULL,
			    currency_name VARCHAR(100) NOT NULL,
			    currency_code VARCHAR(3) NOT NULL,
			    "date" DATE
			);""".trimIndent()

	val connection: Connection

	init {
		prepareDirectory()
		connection = DriverManager.getConnection(JDBC_URL)
		initDb()
	}

	private fun prepareDirectory() {
		if (!Files.exists(APP_DB_PATH)) {
			try {
				Files.createDirectory(APP_DB_PATH)
			} catch (e: IOException) {
				log.error(
					"Cannot create application database directory {}",
					APP_DB_PATH.toAbsolutePath()
				)
				throw e
			}
		}
	}

	private fun initDb() {
		try {
			connection.prepareStatement(SCHEMA_SQL).use { statement -> statement.execute() }
		} catch (e: SQLException) {
			log.error("Cannot create database schema", e)
			throw e
		}
	}

	fun closeConnection(): Boolean {
		log.info("Closing connection to database {}", JDBC_URL)
		try {
			connection.close()
		} catch (e: SQLException) {
			log.error("Cannot close database connection", e)
			try {
				// Finally
				connection.close()
			} catch (ex: SQLException) {
				log.error("Cannot finally close database connection", e)
				throw RuntimeException(ex)
			}
			throw RuntimeException(e)
		}
		return true
	}
}