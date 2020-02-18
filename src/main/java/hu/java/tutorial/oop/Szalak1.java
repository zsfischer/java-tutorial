package hu.java.tutorial.oop;

//Java az egy többszálú programozási nyelv, ami azt jelenti, hogy a program több szálon tud futni egyszerre
//Tehát egy többszálú program egymás mellett, különböző szálakon fut, és egymástól független feladatokat hajt végre szinkronban
//Life-cycle:
//-New - egy új szálat hozunk létre
//-Runnable - miután létrehozunk egy új szálat, az futtathatóvá válik
//-Waiting - egy szál várakozhat pl egy másik szál befejezésére
//-Terminated - a szál terminated(lezárt) állapotba kerül, ha elvégezte a dolgát vagy valami más miatt lezárul
//Minden szálnak van egy prioritása
//A default priority 5
//A legkisebb prioritás értéke 1, a legnagyobbé 10
//Új szálat többféle képpen is létrehozhatunk
//1. - Runnable interface implementálása
//ekkor a Runnable interface-ben lévő run() metódust kell implementálnunk
//mindegy, hogy milyen módon indítunk 2 vagy több szálat, de előfordulhat az az eset, hogy 2 vagy több szál egyszerre szeretne hozzáférni egy erőforráshoz
//pl. ha több file is egyszerre szeretne beleírni egy fileba, ekkor az egyik szál épp megnyitná a filet, miközben egy másik szál pedig pont lezárná azt
//Szóval emiatt van szükség szinkronizálásra, amely biztosítja, hogy egyszerre csak egyetlen szál tud hozzáférni az adott erőforráshoz, addig pedig a többi szál várakozik
//erre használjuk a synchronized kulcsszót
public class Szalak1 implements Runnable
{
    private Thread t;
    private String szalNev;

    public Szalak1(String szalNev)
    {
        this.szalNev = szalNev;
        System.out.println(this.szalNev + " létrehozása...");
    }

    @Override
    public void run()
    {
        System.out.println(szalNev + " futtatása...");
        try
        {
            for (int i = 0; i < 4; i++)
            {
                System.out.println("Thread: " + szalNev + ", " + i);
                Thread.sleep(50);
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("Thread " + szalNev + " megszakítva.");
        }
        System.out.println("Thread " + szalNev + " kilép.");
    }

    public void start()
    {
        System.out.println(szalNev + " indítása...");
        if (t == null)
        {
            t = new Thread(this, szalNev);
            //amikor a start() mjetódus meghívódik, akkor ennek az osztálynak a run() metódusa fogja elindítani a szálat
            t.start();
        }
    }
}
