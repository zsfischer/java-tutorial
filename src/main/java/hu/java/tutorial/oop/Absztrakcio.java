package hu.java.tutorial.oop;

//Absztrakciót használunk arra, hogy elfeldjük az implementációt, szóval csak a funkcionalitás érhető el a felhasználó számára
//Más szavakkal: A felhasználó azt fogja tudni, hogy miket lehet az objectummal végrehajtani, nem pedig azt, hogy azt hogyan csinálja az objectum
//java-ban az absztrakciót absztrakt osztályokkal és interfészekkel érhetjük el

//az osztály, amelyik abstract-ként van deklarálva, az egy absztrakt osztály
//absztrakt osztálynak vagy van abstract metódusa vagy nem -> absztrakt metódus azt jelenti, hogy nincs metódus törzs
//viszont, ha egy osztálynak van absztrakt metódusa, akkor az egész osztálynak absztraktnak kell lennie
//ha egy osztály abstract, akkor nem példányosítható
//ahhoz, hogy egy abstract osztályt használni tudjunk, egy másik osztályt származtatnunk kell belőle (extends)
//ha egy osztály egy abstrakt osztályból származik, akkor az adott osztálynak implementálnia kell az összes absztrakt metódust, vagy ez az osztály is abstract kell, hogy legyen
public abstract class Absztrakcio
{
    private String nev;
    private String cim;
    private int szam;

    public Absztrakcio(String nev, String cim, int szam)
    {
        this.nev = nev;
        this.cim = cim;
        this.szam = szam;
    }

    //absztrakt metódust az abstract kulcsszóval hozunk létre
    //absztrakt metódusnak nincs törzse
    //{} helyett ; van a sor végén
    //abstract metódus nem lehet private
    public abstract void abstractMetodus(String szoveg);

    protected void kiir()
    {
        System.out.println("Absztrakt osztályban kiir() metódus");
    }

    public static void main(String[] args)
    {
        //nem lehetséges, hiszen Absztrakció az egy abstract osztály
//        Absztrakcio absztrakcio = new Absztrakcio("Példa Péter","8000. Szfvár. Király sor 45.", 10);

        //ez már működik, hiszen a Munkas osztály nem abstract
        Absztrakcio absztrakcio = new Munkas("Példa Péter", "8000. Szfvár. Király sor 45.", 10, 3200);
        absztrakcio.kiir();
        absztrakcio.abstractMetodus("ez a szöveg");
    }
}
