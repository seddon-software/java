package date_time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

public class Dates {

	public static void main(String[] args) {
		Locale locale = Locale.getDefault();
		printDateOfFirstBirtday();
		whichDayIsThreeDaysAfterMonday();
		displayDifferentFormsOfDaysName(locale);
		howManyDaysInGivenMonth();
		displayDifferentFormsOfMonthsName(locale, Month.AUGUST);
		whenIsTheFollowingWednesday();
		numberOfDaysInGivenMonth();
		isTheGivenDateValid();
		isYearALeapYear();
	}

	private static void isYearALeapYear() {
		System.out.printf("%b\n", Year.of(2012).isLeap());
	}

	private static void isTheGivenDateValid() {
		MonthDay date = MonthDay.of(Month.FEBRUARY, 29);
		System.out.printf("%b\n", date.isValidYear(2010));
	}

	private static void printDateOfFirstBirtday() {
		LocalDate dateOfBirth = LocalDate.of(2012, Month.MAY, 14);
		LocalDate firstBirthday = dateOfBirth.plusYears(1);
		System.out.println(firstBirthday.toString());
	}

	private static void whichDayIsThreeDaysAfterMonday() {
		System.out.printf("%s%n", DayOfWeek.MONDAY.plus(3));
	}

	private static void displayDifferentFormsOfDaysName(Locale locale) {
		DayOfWeek dow = DayOfWeek.MONDAY;
		System.out.print(dow.getDisplayName(TextStyle.FULL, locale) + ", ");
		System.out.print(dow.getDisplayName(TextStyle.NARROW, locale) + ", ");
		System.out.println(dow.getDisplayName(TextStyle.SHORT, locale));
	}

	private static void displayDifferentFormsOfMonthsName(Locale locale,
			Month month) {
		System.out.print(month.getDisplayName(TextStyle.FULL, locale) + ", ");
		System.out.print(month.getDisplayName(TextStyle.NARROW, locale) + ", ");
		System.out.println(month.getDisplayName(TextStyle.SHORT, locale));
	}

	private static void howManyDaysInGivenMonth() {
		System.out.printf("%d%n", Month.FEBRUARY.maxLength());
	}

	private static void whenIsTheFollowingWednesday() {
		LocalDate date = LocalDate.of(2000, Month.NOVEMBER, 20);
		TemporalAdjuster adj = TemporalAdjusters.next(DayOfWeek.WEDNESDAY);
		LocalDate nextWed = date.with(adj);
		System.out.printf("For the date of %s, the next Wednesday is %s.%n",
				date, nextWed);
	}

	private static void numberOfDaysInGivenMonth() {
		YearMonth date = YearMonth.now();
		System.out.printf("%s: %d%n", date, date.lengthOfMonth());

		YearMonth date2 = YearMonth.of(2010, Month.FEBRUARY);
		System.out.printf("%s: %d%n", date2, date2.lengthOfMonth());

		YearMonth date3 = YearMonth.of(2012, Month.FEBRUARY);
		System.out.printf("%s: %d%n", date3, date3.lengthOfMonth());
	}

}
