package hu.java.tutorial.java8;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class LocalDateApi
{
    @SuppressWarnings("unused")
    public static void main(String[] args)
    {
        // The LocalDate represents a date in ISO format (yyyy-MM-dd) without
        // time.
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        LocalDate localDate2 = LocalDate.of(2015, 1, 20);
        LocalDate localDate3 = LocalDate.parse("2015-02-20");

        LocalDate tomorrow = LocalDate.now().plusDays(1);
        LocalDate previousMonthSameDay = LocalDate.now().minus(1, ChronoUnit.MONTHS);

        DayOfWeek sunday = LocalDate.parse("2016-06-12").getDayOfWeek();

        boolean leapYear = LocalDate.now().isLeapYear();

        boolean notBefore = LocalDate.parse("2016-06-12").isBefore(LocalDate.parse("2016-06-11"));
        boolean isAfter = LocalDate.parse("2016-06-12").isAfter(LocalDate.parse("2016-06-11"));

        LocalDateTime beginningOfDay = LocalDate.parse("2016-06-12").atStartOfDay();
        LocalDate firstDayOfMonth = LocalDate.parse("2016-06-12").with(TemporalAdjusters.firstDayOfMonth());

        // Period
        LocalDate initialDate = LocalDate.parse("2007-05-10");
        LocalDate finalDate = initialDate.plus(Period.ofDays(5));
        int five = Period.between(initialDate, finalDate).getDays();
        long weekDif = ChronoUnit.WEEKS.between(initialDate, finalDate);
        long five2 = ChronoUnit.DAYS.between(initialDate, finalDate);

        // from current time in millis - long-b�l d�tum
        LocalDateTime localDate4 = Instant
                .ofEpochMilli(System.currentTimeMillis())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        LocalDateTime localDate5 = Instant
                .ofEpochMilli(System.currentTimeMillis())
                .atZone(ZoneOffset.UTC)
                .toLocalDateTime();

        System.out.println();
    }
}
