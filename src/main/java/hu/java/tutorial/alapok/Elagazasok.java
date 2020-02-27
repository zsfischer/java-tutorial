package hu.java.tutorial.alapok;

//elágazásokat használunk azért, hogy csak bizonyos esetekben, ha bizonyos feltételek igazak, csak akkor fusson le egy adott kódrészlet
public class Elagazasok
{
    public static void main(String[] args)
    {
        int a = 10;

        //if
        if (a > 10)
        {
            System.out.println("'a' nagyobb, mint 10");
        }

        //if..else
        if (a == 10)
        {
            System.out.println("'a' értéke 10");
        }
        else
        {
            System.out.println("'a' értéke nem 10");
        }

        //több if egymásban
        if (a < 10)
        {
            System.out.println("'a' kisebb, mint 10");
        }
        else if (a == 10)
        {
            System.out.println("'a' értéke 10");
        }
        else
        {
            System.out.println("'a' nagyobb, mint 10");
        }

        //switch
        //ugyanaz, mint az if, viszont több elágazás esetén szebb
        switch (a)
        {
            case 1:
                System.out.println("'a' = 1");
                break;
            case 3:
                System.out.println("'a' = 3");
                break;
            case 10:
                System.out.println("'a' = 10");
                break;
            default:
                System.out.println("'a' nem 1, nem 3, nem 10");
        }

        //"b" értéke "a" értéke alapján fog eldőlni
        //ha "a" értéke 10, akkor "b" értéke 5 lesz, különben pedig 3

        int b;

        if(a==10){
            b = 5;
        } else {
            b = 3;
        }

        b = a==10 ? 5 : 3;
        //feltétel ? igaz_esetén : hamis_esetén;
    }
}
