package hu.java.tutorial.alapok;

//Metódusokat használunk arra, hogy összetartozó dolgot pl. átlagszámítást egy helyen tudjunk kezelni
public class Metodusok
{
    //Példa:
    //public static int metódusNév(int a, String b) { metódusTörzs }
    //public static - változtatók (láthatóság, osztály szintű stb.)
    //int - visszatérési érték típusa (ha nem akarunk semmivel sem visszatérni, akkor void kulcsszót használjuk)
    //metódusNév - a metódus neve
    //intaa, String b - paraméterek, amit a metódus megkap, amikor meghívjuk
    //metódusTörzs - a metódus törzse, ami leírja, hogy mit is csinál ez a metódus

    //Példa metódusok
    public void hello()
    {
        System.out.println("hello");
    }

    private int osszeg(int a, int b)
    {
        return a + b;
    }

    public String[] tombos(String[] stringTomb)
    {
        for (String elem : stringTomb)
        {
            System.out.println(elem);
        }
        return stringTomb;
    }

    private void kiir(int a, String b, double c)
    {
        if (a == 10)
        {
            System.out.println("'a' értéke 10");
        }

        if (b.equals("szia"))
        {
            System.out.println(b.concat(" hallgató"));
        }

        System.out.println("double értéke: " + c);
    }

    //metódus meghívása egy másik metódusban
    private void masikMetoduskMeghivasa(int a)
    {
        //meghívjuk az osszeg metódust a paraméterül megkapott 'a'-val és 'a' kétszeresével
        int osszeg = osszeg(a, a * 2);
        System.out.println(osszeg);
    }
}

