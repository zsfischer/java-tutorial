package hu.java.tutorial.oop;

//Egy új szál indításának másik módja, ha a Thread osztályból származtatunk
//Ekkor a Thread-ben lévő run() metódust kell felülírnunk
public class Szalak2 extends Thread
{
    private Thread t;
    private String szalNev;

    public Szalak2(String szalNev)
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
