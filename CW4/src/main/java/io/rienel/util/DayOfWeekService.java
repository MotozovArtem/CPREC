package io.rienel.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Objects;

import org.jetbrains.annotations.NotNull;

public class DayOfWeekService {
	/**
	 * Used for receiving last weekday.
	 * If date is weekday returns same date.
	 * If date is <b>weekend</b> returns <b>friday<b> day date.
	 *
	 * @param date - date
	 * @return last business date from requested date
	 */
	public @NotNull LocalDate getLastWeekdayDate(@NotNull LocalDate date) {
		Objects.requireNonNull(date);

		if (isWeekday(date.getDayOfWeek())) {
			return date;
		} else {
			return switch(date.getDayOfWeek()) {
				case SATURDAY -> date.minusDays(1);
				case SUNDAY -> date.minusDays(2);
				default -> throw new IllegalStateException("Cannot be weekday");
			};
		}
	}

	public boolean isWeekday(DayOfWeek dayOfWeek){
		return switch (dayOfWeek) {
			case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> true;
			case SATURDAY, SUNDAY -> false;
		};
	}
}
