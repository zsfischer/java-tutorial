package hu.java.tutorial.java8;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class LocalTimeApi
{
    @SuppressWarnings("unused")
    public static void main(String[] args)
    {
        // The LocalTime represents time without a date.
        LocalTime now = LocalTime.now();

        LocalTime sixThirty = LocalTime.parse("06:30");

        LocalTime sixThirty2 = LocalTime.of(6, 30);

        LocalTime sevenThirty = LocalTime.parse("06:30").plus(1, ChronoUnit.HOURS);

        int six = LocalTime.parse("06:30").getHour();

        boolean isbefore = LocalTime.parse("06:30").isBefore(LocalTime.parse("07:30"));

        LocalTime maxTime = LocalTime.MAX;

        // duration
        LocalTime initialTime = LocalTime.of(6, 30, 0);
        LocalTime finalTime = initialTime.plus(Duration.ofSeconds(30));
        long thirty = Duration.between(finalTime, initialTime).getSeconds();
        long thirty2 = ChronoUnit.SECONDS.between(finalTime, initialTime);

        // compatibility
        LocalDateTime now1 = LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault());
        LocalDateTime now2 = LocalDateTime.ofInstant(Calendar.getInstance().toInstant(), ZoneId.systemDefault());
        LocalDateTime now3 = LocalDateTime.ofEpochSecond(System.currentTimeMillis(), 0, ZoneOffset.UTC);

        // format
        LocalDateTime localDateTime = LocalDateTime.of(2015, Month.JANUARY, 25, 6, 30);
        String formattedDate1 = localDateTime.format(DateTimeFormatter.ISO_DATE_TIME);
        String formattedDate2 = localDateTime.format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        String formattedDate3 = localDateTime
                .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).withLocale(new Locale("hu")));

        System.out.println();
    }
}
