package io.rienel;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * TODO ArMotozov
 *
 * @since 12/3/2022
 */
public class SearchService {
	public List<Valute> searchValute(List<Valute> valuteList, String searchValue, Valute.Columns searchColumn) {
        return valuteList
		        .stream()
		        .filter(valute -> {
					switch (searchColumn) {
						case CURRENCY_CODE -> {
							return valute.getCurrencyCode().contains(searchValue);
						}
						case CURRENCY_NAME -> {
							return valute.getCurrencyName().contains(searchValue);
						}
					}
					return false;
		        })
		        .toList();
	}
}
