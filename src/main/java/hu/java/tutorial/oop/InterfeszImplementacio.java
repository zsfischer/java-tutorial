package hu.java.tutorial.oop;

public class InterfeszImplementacio implements Interfesz
{
    @Override
    public void szamol()
    {
        System.out.println("szamol() metódus implementálása");
    }

    public static void main(String[] args)
    {
        InterfeszImplementacio interfeszImplementacio = new InterfeszImplementacio();
        interfeszImplementacio.szamol();
        interfeszImplementacio.szamolMeghivasa();
        interfeszImplementacio.hello();
        System.out.println(interfeszImplementacio.FEJER_MEGYE_IRANYITOSZAM);
        System.out.println(Interfesz.FEJER_MEGYE_IRANYITOSZAM);
    }
}
