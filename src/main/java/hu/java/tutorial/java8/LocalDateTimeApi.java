package hu.java.tutorial.java8;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeApi
{
    @SuppressWarnings("unused")
    public static void main(String[] args)
    {
        // The LocalDateTime is used to represent a combination of date and
        // time.
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDateTime);

        LocalDateTime localDateTime2 = LocalDateTime.of(2015, Month.FEBRUARY, 20, 6, 30);

        LocalDateTime localDateTime3 = LocalDateTime.parse("2015-02-20T06:30:00");
        LocalDateTime localDateTime31 = LocalDateTime.parse("2015.02.20 16:30:00",
                DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));

        LocalDateTime localDateTime4 = localDateTime.plusDays(1);

        LocalDateTime localDateTime5 = localDateTime.minusHours(2);

        Month month = localDateTime.getMonth();

        // from current time in millis
        LocalDateTime localDateTime6 = LocalDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), ZoneId.systemDefault());

        LocalDateTime localDateTime7 = Instant
                .ofEpochMilli(System.currentTimeMillis())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        System.out.println();
    }
}
