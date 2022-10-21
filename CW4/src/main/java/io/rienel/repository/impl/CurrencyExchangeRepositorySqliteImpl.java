package io.rienel.repository.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.rienel.database.Database;
import io.rienel.model.CurrencyExchange;
import io.rienel.repository.CurrencyExchangeRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CurrencyExchangeRepositorySqliteImpl implements CurrencyExchangeRepository {

	private static final Logger log = LoggerFactory.getLogger(CurrencyExchangeRepositorySqliteImpl.class);

	private final Database database = Database.getInstance();

	@Override
	public @Nullable CurrencyExchange findById(@NotNull Integer id) {
		Objects.requireNonNull(id);

		final Connection connection = database.getConnection();
		final CurrencyExchange currencyExchange;
		// SELECT id, \"value\", nominal, currency_name, currency_code, \"date\" FROM currency_exchange WHERE id=?
		try (PreparedStatement statement = connection.prepareStatement("SELECT " +
		                                                               CurrencyExchange.COLUMN_ID +
		                                                               "\"" + CurrencyExchange.COLUMN_VALUE + "\"" +
		                                                               CurrencyExchange.COLUMN_NOMINAL +
		                                                               CurrencyExchange.COLUMN_CURRENCY_NAME +
		                                                               CurrencyExchange.COLUMN_CURRENCY_CODE +
		                                                               "\"" + CurrencyExchange.COLUMN_DATE + "\"" +
		                                                               " FROM " + CurrencyExchange.TABLE_NAME +
		                                                               " WHERE " + CurrencyExchange.COLUMN_ID + "=?");) {
			// JDBC column and parameters starts count from 1
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			currencyExchange = new CurrencyExchange();
			while (resultSet.next()) {
				// JDBC column and parameters starts count from 1
				currencyExchange.setId(resultSet.getInt(1)); // id
				currencyExchange.setValue(resultSet.getDouble(2)); // value
				currencyExchange.setNominal(resultSet.getInt(3)); // nominal
				currencyExchange.setCurrencyName(resultSet.getString(4)); // currency_name
				currencyExchange.setCurrencyCode(resultSet.getString(5)); // currency_code
				currencyExchange.setDate(resultSet.getDate(6).toLocalDate()); // date
			}
			resultSet.close();
			return currencyExchange;
		} catch (SQLException e) {
			log.error("Error while requesting CurrencyExchange by id = {}", id, e);
			throw new RuntimeException(e);
		}
	}

	@Override
	public @NotNull List<CurrencyExchange> findAll() {
		final Connection connection = database.getConnection();
		final List<CurrencyExchange> currencyExchangeList = new ArrayList<>();
		// SELECT id, \"value\", nominal, currency_name, currency_code, \"date\" FROM currency_exchange
		try (PreparedStatement statement = connection.prepareStatement("SELECT " +
		                                                               CurrencyExchange.COLUMN_ID +
		                                                               "\"" + CurrencyExchange.COLUMN_VALUE + "\"" +
		                                                               CurrencyExchange.COLUMN_NOMINAL +
		                                                               CurrencyExchange.COLUMN_CURRENCY_NAME +
		                                                               CurrencyExchange.COLUMN_CURRENCY_CODE +
		                                                               "\"" + CurrencyExchange.COLUMN_DATE + "\"" +
		                                                               " FROM " + CurrencyExchange.TABLE_NAME);
		     ResultSet resultSet = statement.executeQuery()) {
			final CurrencyExchange currencyExchange = new CurrencyExchange();
			while (resultSet.next()) {
				currencyExchange.setId(resultSet.getInt(CurrencyExchange.COLUMN_ID)); // id
				currencyExchange.setValue(resultSet.getDouble(CurrencyExchange.COLUMN_VALUE)); // value
				currencyExchange.setNominal(resultSet.getInt(CurrencyExchange.COLUMN_NOMINAL)); // nominal
				currencyExchange.setCurrencyName(resultSet.getString(CurrencyExchange.COLUMN_CURRENCY_NAME)); // currency_name
				currencyExchange.setCurrencyCode(resultSet.getString(CurrencyExchange.COLUMN_CURRENCY_CODE)); // currency_code
				currencyExchange.setDate(resultSet.getDate(CurrencyExchange.COLUMN_DATE).toLocalDate()); // date
				currencyExchangeList.add(currencyExchange);
			}
		} catch (SQLException e) {
			log.error("Error while requesting CurrencyExchange", e);
			throw new RuntimeException(e);
		}
		return currencyExchangeList;
	}

	@Override
	public @NotNull List<CurrencyExchange> findAllByCode(@NotNull String currencyCode) {
		Objects.requireNonNull(currencyCode);

		final Connection connection = database.getConnection();
		final List<CurrencyExchange> currencyExchangeList = new ArrayList<>();
		// SELECT id, \"value\", nominal, currency_name, currency_code, \"date\" FROM currency_exchange WHERE currency_code=?
		try (PreparedStatement statement = connection.prepareStatement("SELECT " +
		                                                               CurrencyExchange.COLUMN_ID +
		                                                               "\"" + CurrencyExchange.COLUMN_VALUE + "\"" +
		                                                               CurrencyExchange.COLUMN_NOMINAL +
		                                                               CurrencyExchange.COLUMN_CURRENCY_NAME +
		                                                               CurrencyExchange.COLUMN_CURRENCY_CODE +
		                                                               "\"" + CurrencyExchange.COLUMN_DATE + "\"" +
		                                                               " FROM " + CurrencyExchange.TABLE_NAME +
		                                                               " WHERE " + CurrencyExchange.COLUMN_CURRENCY_CODE + "=?")) {
			statement.setString(1, currencyCode);
			ResultSet resultSet = statement.executeQuery();
			final CurrencyExchange currencyExchange = new CurrencyExchange();
			while (resultSet.next()) {
				currencyExchange.setId(resultSet.getInt(CurrencyExchange.COLUMN_ID)); // id
				currencyExchange.setValue(resultSet.getDouble(CurrencyExchange.COLUMN_VALUE)); // value
				currencyExchange.setNominal(resultSet.getInt(CurrencyExchange.COLUMN_NOMINAL)); // nominal
				currencyExchange.setCurrencyName(resultSet.getString(CurrencyExchange.COLUMN_CURRENCY_NAME)); // currency_name
				currencyExchange.setCurrencyCode(resultSet.getString(CurrencyExchange.COLUMN_CURRENCY_CODE)); // currency_code
				currencyExchange.setDate(resultSet.getDate(CurrencyExchange.COLUMN_DATE).toLocalDate()); // date
				currencyExchangeList.add(currencyExchange);
			}
			resultSet.close();
		} catch (SQLException e) {
			log.error("Error while requesting CurrencyExchange", e);
			throw new RuntimeException(e);
		}
		return currencyExchangeList;
	}

	@Override
	public int delete(@NotNull Integer id) {
		Objects.requireNonNull(id);

		final Connection connection = database.getConnection();
		int rowsDeleted = 0;
		// DELETE FROM currency_exchange WHERE id=?
		try (PreparedStatement statement = connection.prepareStatement("DELETE FROM " +
		                                                               CurrencyExchange.TABLE_NAME +
		                                                               " WHERE " + CurrencyExchange.COLUMN_ID + "=?")) {
			statement.setInt(1, id);
			rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 1) {
				log.warn("Deleted more than 1 row for id={}", id);
			}
		} catch (SQLException e) {
			log.error("Error while deleting CurrencyExchange with id={}", id, e);
			throw new RuntimeException(e);
		}
		return rowsDeleted;
	}

	@Override
	public int deleteAll() {
		final Connection connection = database.getConnection();
		int rowsDeleted = 0;
		// DELETE FROM currency_exchange;
		try (PreparedStatement statement = connection.prepareStatement("DELETE FROM " +
		                                                               CurrencyExchange.TABLE_NAME)) {
			rowsDeleted = statement.executeUpdate();
			log.warn("Deleted {} rows", rowsDeleted);
		} catch (SQLException e) {
			log.error("Error while deleting CurrencyExchange", e);
			throw new RuntimeException(e);
		}
		return rowsDeleted;
	}

	@Override
	public int insert(@NotNull CurrencyExchange currency) {
		Objects.requireNonNull(currency);

		final Connection connection = database.getConnection();
		int rowsInserted = 0;
		// INSERT INTO currency_exchange(id, \"value\", nominal, currency_code, currency_name, "date") VALUES (?,?,?,?,?,?);
		try (PreparedStatement statement = connection.prepareStatement("INSERT INTO " +
		                                                               CurrencyExchange.TABLE_NAME + "(" +
		                                                               CurrencyExchange.COLUMN_ID + "," +
		                                                               CurrencyExchange.COLUMN_VALUE + "," +
		                                                               CurrencyExchange.COLUMN_NOMINAL + "," +
		                                                               CurrencyExchange.COLUMN_CURRENCY_CODE + "," +
		                                                               CurrencyExchange.COLUMN_CURRENCY_NAME + "," +
		                                                               CurrencyExchange.COLUMN_DATE + ") VALUES (?,?,?,?,?,?)")) {
			statement.setInt(1, currency.getId());
			statement.setDouble(2, currency.getValue());
			statement.setInt(3, currency.getNominal());
			statement.setString(4, currency.getCurrencyName());
			statement.setString(5, currency.getCurrencyCode());
			statement.setDate(6, new Date(
							currency.getDate()
									.toEpochSecond(LocalTime.of(0, 0, 0),
											ZoneOffset.UTC)
					)
			);
			rowsInserted = statement.executeUpdate();
			if (rowsInserted > 1) {
				log.warn("Inserted more than 1 row for id = {}", currency.getId());
			}
		} catch (SQLException e) {
			log.error("Error while inserting {}", currency, e);
			throw new RuntimeException(e);
		}
		return rowsInserted;
	}

	@Override
	public int update(@NotNull CurrencyExchange currency) {
		Objects.requireNonNull(currency);

		final Connection connection = database.getConnection();
		int rowsUpdated = 0;
		// UPDATE currency_exchange SET \"value\"=?, nominal=?, currency_code=?, currency_name=?, \"date\"=?  WHERE id=?
		try (PreparedStatement statement = connection.prepareStatement("UPDATE " +
		                                                               CurrencyExchange.TABLE_NAME + " " +
		                                                               " SET " +
		                                                               "\"" + CurrencyExchange.COLUMN_VALUE + "\"" + "=?," +
		                                                               CurrencyExchange.COLUMN_NOMINAL + "=?," +
		                                                               CurrencyExchange.COLUMN_CURRENCY_CODE + "=?," +
		                                                               CurrencyExchange.COLUMN_CURRENCY_NAME + "=?," +
		                                                               "\"" + CurrencyExchange.COLUMN_DATE + "\"" + "=?" +
		                                                               " WHERE" + CurrencyExchange.COLUMN_ID + "=?")) {
			statement.setDouble(1, currency.getValue());
			statement.setInt(2, currency.getNominal());
			statement.setString(3, currency.getCurrencyName());
			statement.setString(4, currency.getCurrencyCode());
			statement.setDate(5, new Date(
							currency.getDate()
									.toEpochSecond(LocalTime.of(0, 0, 0),
											ZoneOffset.UTC)
					)
			);
			statement.setInt(6, currency.getId());
			rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 1) {
				log.warn("Updated more than 1 row for id={}", currency.getId());
			}
		} catch (SQLException e) {
			log.error("Error while updating CurrencyExchange with id={}", currency.getId(), e);
			throw new RuntimeException(e);
		}
		return rowsUpdated;
	}
}
