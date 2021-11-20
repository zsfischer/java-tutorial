package hu.java.tutorial.alapok;

//majdnem minden java programnak kell rendelkeznie main metódussal
//a main metódus publikus, statikus (osztályszintű) és void, tehát visszatérés érték nélküli
//paraméterként egy String[] tömböt kap, ami a parancssori argumentumok tömbje
//szóval ha úgy indítanánk el a programunkat, hogy
//javac Main.java
//java Main argumentum1 argumentum2 argumentum3
//akkor a String[] tömbben lenne 3 érték, az argumentum1-2-3
//fontos, hogy a parancssori argumentumok tömbje nem tartalmazza a program nevét, és 0-tól indexelődik
//szóval args[0]=argumentum1; args[1]=argumentum2; args[2]=argumentum3

public class Foosztaly
{
    public static void main(String[] args)
    {
        //a kód, ami először lefut a program indításakor
    }
}
