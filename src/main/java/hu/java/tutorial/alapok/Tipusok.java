package hu.java.tutorial.alapok;

//Java-ban két féle adattípus van
//Primitív típusok
//Referencia/Objectum típusok - ezek akkor keletkeznek, amikor konstruktor segítségével példányosítunk egy osztályt. default érték null, pl. Kutya kutya = new Kutya(), itt a típus Kutya

public class Tipusok
{
    //Primitív típusok
    private byte bajt; //8-biten(1 byte) van tárolva, min -128, max 127, default 0
    private short rovidSzam; //16-biten van tárolva, min -32.768, max 32.768, default 0
    private int egeszSzam; //32-biten van tárolva, min -2^31, max (2^31)-1, default 0
    private long hosszuSzam; //64-biten van tárolva, min -2^63, max (2^63)-1, default 0L, pl: long l=123L
    private float lebegoPontos1; //32-biten van tárolva, default 0.0f, pl: float f=12.45f
    private double lebegoPontos2; //64-biten van tárolva, default 0.0d, pl: double d=123.4
    private boolean logikai; //1-biten van tárolva, false vagy true, default false
    private char karakter; //16-biten van tárolva, pl: char letterA='A'

    //A String nem primitív típus, de nagyon sokszor használjuk
    private String szoveg; //szöveget tárolunk benne
}
