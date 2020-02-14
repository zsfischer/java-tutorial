package hu.java.tutorial.alapok;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//Kivételeket (Exception) használunk arra, hogy a program futása során esetlegesen felmerülő hibákat kezeljük
//alap esetben, ha nem kezelünk egy hibát, akkor a program abnormálisan fejeződik be
//hiba külböző okokból léphetnek fel. pl: a felhasználó érvénytelen adatot ad meg, megnyitni kívánt file nem található stb.
public class Kivetel
{
    public static void main(String[] args) throws SajatKivetel
    {
        //2 féle kivétel létezik:
        //Kötelezően kezelendő (Checked) - ezek olyan kivételek, amelyeket a fordító fordítási időben észlel, és emiatt kötelező lekezelnie a programozónak
        //példa:
        //itt a new FileReader(file) FileNotFOundException-t dob, ha a keresett exception.txt file nem található
        //emiatt ezt a kivételt kezelnünk kell
        //a kivételek kezelésér a try-catch szerkezetet használjuk
        File file = new File("exception.txt");
        try
        {
            FileReader fr = new FileReader(file);
        }
        catch (FileNotFoundException e)
        {
            //ide, a catch ágba fut bele a program akkor, ha FileNotFoundException keletkezett
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        //Nem kötelezően kezelendő (Unchecked) - ezek olyan kivételek, amelyek fordítási időben keletkeznek (Runtime Exceptions), emiatt nem tudjuk őket előre lekezelni. pl.: logikai hibák,
        //ha ezt futtatnánk, akkor egy ArrayIndexOutOfBoundsException kapnánk, hiszen a num tömb 6. elemét szeretnénk megkapni, viszont a tömbünknek csak 5 eleme van
        //ezt a hibát viszont nem kell kötelezően lekezelni, mert ez majd csak futási időben fog kiderülni
        int[] num = {1, 2, 3, 4, 5};
        System.out.println(num[5]);


        //több catch ág is szerepelhet egymás után
        //az Exceptionok fajtáját fel is sorolhatjuk a | elválasztóval
        //a finally ág mindenképpen lefut, akár volt kivétel, akár nem
        //a finally ágba tipikusan pl olyanok kerülnek, amikor egy erőforrást használó objectumot szeretnénk lezárni a close() metódussal
        File file2 = new File("exception.txt");
        try
        {
            FileReader fr = new FileReader(file);
        }
        catch (FileNotFoundException | NumberFormatException e)
        {
            //ide, a catch ágba fut bele a program akkor, ha FileNotFoundException keletkezett
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        catch (Exception e)
        {
            System.out.println(
                    "Ide akkor fur a program, ha a keletkezett kivétel se nem FileNotFoundException, se nem NumberFormatException");
        }
        finally
        {
            System.out.println("Ide mindenképpen befut a program!");
        }


        //Saját kivétel kezelése, dobása
        int a = 10;
        if (a == 10)
        {
            //amikor új kivételt dobunk, akkor vagy azonnal lekezeljük, vagy továbbdobjuk a metódus szignatúrájában a throws kulcsszóval (jelen esetben a main metódus továbbdobja SajatKivetel)
            //ha tovább dobjuk a kivételt, akkor vagy lekezeljük ott, ahol az a metódus meg van hívva, ami a kivételt továbbdobta, vagy a meghívó metódus is továbbdobja
            throw new SajatKivetel("Itt most dobunk egy saját kivételt");

            //ha nem dobnánk tovább az exception-t a main metódusban, akkor itt kéne lokálisan lekezelni
//            try
//            {
//                throw new SajatKivetel("Itt most dobunk egy saját kivételt");
//            }
//            catch (SajatKivetel sajatKivetel)
//            {
//                sajatKivetel.printStackTrace();
//            }
        }

        //catch ág nem létezhet try nélkül
        //a finally ág nem kötelező
        //ha van try, akkor kell lennie vagy catch vagy finally ágnak
        //egyéb kód nem lehet a try, catch és finally blokkok között


        //try-with-resources szerkezet
        //általában, amikor mi erőforrást használunk pl: streameket stb, akkor ezeket az erőforrásokat le kell zárnunk a finally ágban a close() metódussal
        //Példa:
        FileReader fr = null;
        try
        {
            File file3 = new File("file.txt");
            fr = new FileReader(file3);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                fr.close();
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }

        //Azért, hogy ne kelljen ezt a lezárást nekünk saját kézzel megtennünk, erre használjuk a try-with resources szerkezetet
        //Ekkor az erőforrások automatikus lezáródnak, amikor már nem használjuk őket
        //több erőforrást használó objectum is létrehozható a try-with-resource szerkezetben. Lezáráskor ezek fordított sorrendben fognak lefutni
        try (FileReader fr2 = new FileReader("file path"))
        {
            // ide írhatjuk a kódunkat
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
