package hu.java.tutorial.java8;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

public class InstantApi
{
    @SuppressWarnings("unused")
    public static void main(String[] args)
    {
        Instant now = Instant.now();
        Instant now2 = Instant.ofEpochMilli(System.currentTimeMillis());
        System.out.println(now);
        System.out.println(now2);

        LocalDateTime ldtNow = LocalDateTime.now();

        System.out.println(ldtNow);

        // to date
        Date date = Date.from(now);

        // date to instant
        Instant now3 = date.toInstant();

        // date to localdatetime
        Date in = new Date();
        // solution 1
        LocalDateTime ldt = in.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        // solution 2
        LocalDateTime ldt2 = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
        // localdatetime to date
        // solution 1
        Date out = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
        // solution 2
        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        ZoneOffset offset = OffsetDateTime.now().getOffset();

        Date out2 = Date.from(ldt.toInstant(OffsetDateTime.now().getOffset()));


        // get local date time in given zone
        LocalDateTime ldt3 = ZonedDateTime
                .ofInstant(ldtNow.atZone(ZoneId.systemDefault()).toInstant(), ZoneId.of("Europe/Bucharest"))
                .toLocalDateTime();

        // get local date time in given zone (difficult solution :))
        LocalDateTime ldt4 = LocalDateTime.ofInstant(
                ldtNow.toInstant(ZoneId.systemDefault().getRules().getOffset(Instant.now())),
                ZoneId.of("Europe/London").getRules().getOffset(Instant.now()));

        // ez így rossz, ne használd
        Date date2 = Date.from(ldtNow.toInstant(ZoneOffset.UTC));
        System.out.println();
    }

}
