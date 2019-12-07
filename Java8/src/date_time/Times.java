package date_time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Times {

	public static void main(String[] args) {
		printTheTimeNow();
	    printVariousTimes();
	}

	private static void printTheTimeNow() {
		LocalTime thisSec = LocalTime.now();
	    System.out.printf("%d hrs %d min %d sec", thisSec.getHour(), thisSec.getMinute(), thisSec.getSecond());
	}

	private static void printVariousTimes() {
		System.out.printf("now: %s%n", LocalDateTime.now());

	    System.out.printf("Apr 15, 1994 @ 11:30am: %s%n",
	                      LocalDateTime.of(1994, Month.APRIL, 15, 11, 30));

	    System.out.printf("now (from Instant): %s%n",
	                      LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()));

	    System.out.printf("6 months from now: %s%n",
	                      LocalDateTime.now().plusMonths(6));

	    System.out.printf("6 months ago: %s%n",
	                      LocalDateTime.now().minusMonths(6));
	}
}
