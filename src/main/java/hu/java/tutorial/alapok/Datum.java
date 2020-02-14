package hu.java.tutorial.alapok;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//Java biztosít egy Date osztályt (java.util package-ben), amellyel az aktuális dátumot és időt tudjuk lekérni/manipulálni
public class Datum
{
    public static void main(String[] args) throws ParseException
    {
        //Létrehoz egy új Date objectuomot, amely a létrehozás időpillanatát tartalmazza
        Date date = new Date();

        Date date2 = new Date();

        //metódusok a Date osztályon
        if (date.after(date2))
        {
            System.out.println("date későbbi mint date2");
        }

        if (date.before(date2))
        {
            System.out.println("date korábbi mint date2");
        }

        if (date.equals(date2))
        {
            System.out.println("date és date2 megegyezik");
        }

        //átkonvertálja a date objectumot String-é és visszaadja az értékét
        System.out.println(date.toString());

        //dátum formálása
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(sf.format(date));

        //String átalakítása Date objectummá
        String stringDate = "2020-01-01 12:15:23";
        Date parsingDate = sf.parse(stringDate);
        System.out.println(parsingDate);
    }
}
