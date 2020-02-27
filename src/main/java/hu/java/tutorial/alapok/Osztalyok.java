package hu.java.tutorial.alapok; //azt jelöli, hogy az adott osztály (jelen esetben Osztalyok.java) melyik package-ben (mappában) van

//Java az egy objectum-orientált programozási (OOP) nyelv. A javaban minden az Object ősosztály közvetlen/közvetett leszármazottja.
//Objektum (Object) - egy objektuomnak vannak tulajdonságai és viselkedése. pl: a kutyának van lába, nyelve (ezek a tulajdonságok), és tud ugatni (viselkedés)
//az objektum az egy osztály (class) példánya
//Osztály (Class) - Egy osztály az olyan, mint egy template/sablon, ami leírja az objectum tulajdonságait, viselkedéseit

//osztály neve meg kell hogy egyezzen a file nevével
public class Osztalyok
{
    public class Kutya
    {
        //tulajdonságok (változók)
        private String orr;
        private int nyelv;
        private String szin;

        //viselkedések (metódusok)
        public void ugat()
        {
        }

        public void fut()
        {
        }

        public void alszik()
        {
        }
    }

    //konstruktorok
    //minden osztálynak kell lennie legalább 1 konstruktornak
    //ha mi nem írunk konstruktort az osztályhoz, akkor a Java compiler(fordító) létrehoz magának egy paraméter nélküli, úgynevezett default konstruktort
    //minden alkalommal, amikor egy új példányt hozunk létre az adott osztályból, akkor azt a konstruktorral tesszük
    //legfontosabb szabály, hogy a konstruktornak a neve meg kell hogy egyezzen az osztály nevével, és nincs visszatérési értéke!!
    //egy osztálynak több eltérő konstruktora is lehet, ami azt jelenti, hogy más a paraméterek száma
    public class Macska
    {
        private String szin;

        //1. konstruktor, paraméter nélküli (ez nem a default konstruktor)
        public Macska()
        {
        }

        //2. konstruktor
        public Macska(String szin, int i)
        {
        }

        //3. konstruktor, amely paraméterül egy szöveges típusú értéket vár, majd a kapott értéket beállítja a az osztály "szin" változójának értékéül
        public Macska(String szin)
        {
            this.szin = szin;
        }
    }
}
