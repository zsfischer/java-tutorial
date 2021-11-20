package hu.java.tutorial.alapok;

public class Varargs
{
    //Csak 1 db varargs szereplhet a paraméterek között
    //Az utolsó paraméternek kell lennie
    public void helloInManyLanguages(String... hellos) {
        for(String hello : hellos) {
            System.out.println(hello);
        }
    }
}
