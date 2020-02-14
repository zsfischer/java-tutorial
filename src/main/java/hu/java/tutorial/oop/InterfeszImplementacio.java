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
        System.out.println(InterfeszImplementacio.FEJER_MEGYE_IRANYITOSZAM);
    }
}
