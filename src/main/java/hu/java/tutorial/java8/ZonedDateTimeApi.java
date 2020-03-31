package hu.java.tutorial.java8;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Set;

public class ZonedDateTimeApi
{
    @SuppressWarnings("unused")
    public static void main(String[] args)
    {
        ZoneId zoneId = ZoneId.of("Europe/Budapest");

        Set<String> allZoneIds = ZoneId.getAvailableZoneIds();
//        allZoneIds.stream().sorted().forEach(System.out::println);

        // AKtuális idő adott zónában
        LocalDate now = LocalDate.now(zoneId);
        LocalDateTime now2 = LocalDateTime.now(zoneId);
//        System.out.println(now);
//        System.out.println(now2);

        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.now(), zoneId);
        LocalDateTime dateTime2 = zonedDateTime.toLocalDateTime();
        System.out.println(zonedDateTime);
        System.out.println(dateTime2);

        ZonedDateTime zonedDateTime2 = ZonedDateTime.parse("2015-05-03T10:15:30+01:00");
        LocalDateTime dateTime = zonedDateTime2.toLocalDateTime();

        LocalDateTime localDateTime = LocalDateTime.of(2015, Month.FEBRUARY, 20, 6, 30);
        ZoneOffset offset = ZoneOffset.of("+02:00");
        OffsetDateTime offSetByTwo = OffsetDateTime.of(localDateTime, offset);
        System.out.println(offset);
        System.out.println(offSetByTwo);

        System.out.println();
    }
}
