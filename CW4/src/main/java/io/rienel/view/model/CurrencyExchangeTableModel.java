package io.rienel.view.model;

import javax.swing.table.AbstractTableModel;
import java.util.Collections;
import java.util.List;

import io.rienel.model.CurrencyExchange;

public final class CurrencyExchangeTableModel extends AbstractTableModel {

	private static final String COLUMN_ID = "ID";
	private static final String COLUMN_VALUE = "Value";
	private static final String COLUMN_NOMINAL = "Nominal";
	private static final String COLUMN_CURRENCY_NAME = "Name";
	private static final String COLUMN_CURRENCY_CODE = "Code";
	private static final String COLUMN_DATE = "Date";

	private static final List<String> TABLE_COLUMNS_LIST = List.of(
			COLUMN_ID,
			COLUMN_VALUE,
			COLUMN_NOMINAL,
			COLUMN_CURRENCY_NAME,
			COLUMN_CURRENCY_CODE,
			COLUMN_DATE
	);
	private final List<CurrencyExchange> tableData;

	public CurrencyExchangeTableModel(List<CurrencyExchange> tableData) {
		this.tableData = tableData != null ? tableData : Collections.emptyList();
	}

	@Override
	public int getRowCount() {
		return tableData.size();
	}

	@Override
	public int getColumnCount() {
		return TABLE_COLUMNS_LIST.size();
	}

	@Override
	public int findColumn(String columnName) {
		return TABLE_COLUMNS_LIST.indexOf(columnName);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		CurrencyExchange currencyExchange = tableData.get(rowIndex);
		switch (columnIndex) {
			case 0:
				return currencyExchange.getId();
			case 1:
				return currencyExchange.getValue();
			case 2:
				return currencyExchange.getNominal();
			case 3:
				return currencyExchange.getCurrencyName();
			case 4:
				return currencyExchange.getCurrencyCode();
			case 5:
				return currencyExchange.getDate();
			default:
				throw new IllegalArgumentException("Unknown argument");
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public String getColumnName(int column) {
		return TABLE_COLUMNS_LIST.get(column);
	}
}
