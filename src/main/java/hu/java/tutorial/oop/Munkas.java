package hu.java.tutorial.oop;

public class Munkas extends Absztrakcio
{
    private double fizetes;

    public Munkas(String nev, String cim, int szam, double fizetes)
    {
        super(nev, cim, szam);
        this.fizetes = fizetes;
    }

    //implementálnunk kell az ősoztályban található abstract metódusokat (vagy abstract-tá tesszük ezt az osztályt is)
    @Override
    public void abstractMetodus(String szoveg)
    {
        System.out.println("A fizetés: " + this.fizetes);
        System.out.println(szoveg);
    }
}
