package io.rienel;

import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO ArMotozov
 *
 * @since 11/19/2022
 */
public class SortService {
	public List<Valute> sortByColumn(List<Valute> valuteList, String columnName, boolean isAscending) {
		return valuteList
				.stream()
				.sorted((valute1, valute2) -> {
					switch (columnName) {
						case "value" -> {
							if (isAscending) {
								return Double.compare(valute1.getValue(), valute2.getValue());
							} else {
								return Double.compare(valute2.getValue(), valute1.getValue());
							}
						}
						case "code" -> {
							if (isAscending) {
								return valute1.getCurrencyCode().compareTo(valute2.getCurrencyCode());
							} else {
								return valute2.getCurrencyCode().compareTo(valute1.getCurrencyCode());
							}
						}
					}
					throw new IllegalArgumentException();
				})
				.collect(Collectors.toList());
	}
}
