package hu.java.tutorial.alapok;

public class Osztalyok2
{
    String nev;

    public Osztalyok2()
    {
        this.nev = "Alap nev";
        System.out.println(this.nev);
    }

    public Osztalyok2(String nev)
    {
        this.nev = nev;
    }

    public Osztalyok2(String nev1, String nev2)
    {
        this.nev = nev1 + nev2;
    }

    public void setNev(String nev)
    {
        this.nev = nev;
    }

    public String getNev()
    {
        return this.nev;
    }


    public static void main(String[] args)
    {
        //Objectum létrehozása osztályból 3 lépésben
        //1.lépsben deklatárljuk a változó névvel és típussal pl: Macska macska1, ahol a Macska a változó típusa, és a macska1 pedig a változó neve
        //2. lépsben a new kulcsszóval hozzuk létre az új objectumot
        //3. lépésben pedig a new kulcsszót az osztály kostruktora követi -> ez fogja inicializálni az új objectumot
        //ebben az esetben a konstruktor be fogja állítani a "nev" változó értékét a paraméterként megkapott értékre
        Osztalyok2 osztalyok = new Osztalyok2("első osztályom");

        //A példány változóinak és metódusainak elérése
        //megváltoztatom az osztályok példányom "nev" változójának értékét "új név"-re a setNev(String nev) metódus meghívásával
        osztalyok.setNev("új név");

        //kiíratom az osztályok példányom "nev" változójának értékét getNev() metódus meghívásával
        System.out.println(osztalyok.getNev());
    }
}
