package hu.java.tutorial.oop;


//Öröklödést arra használunk, hogy kevesebbet kelljen kódolnunk pl, vagy átláthatóbb legyen a kód
//pl legyen egy olyan osztályunk, hogy Állat
//ugye minden állat rendelkezik aggyal, szívvel, fejjel stb. -> szóval ezek általános dolgok, amik minden állatra igazak
//de vannak specikus dolgok, amelyek csak bizonyos állatokra igazak. pl.: kutyának van nyelve, a medvének van bundája, a cápának van kopoltyúja stb.
//szóval csinálnuk egy közös ősosztályt, az Állat-ot, ebbe beleírjuk a minden állatra jellemző dolgokat
//ezért később, amikor pl csinálunk egy Cápa osztályt, akkor ezeket a tulajdonságokat már nem kell leírnunk, hanem csak szimplán örököltetjük az Állat osztályból, és egyből elérjük a közös dolgokat (IS-A kapcsolat, Cápa IS-A Állat)
//Osztályok esetén a java-ban csak egyszeri öröklés lehetséges (viszont több interfészt is implementálhat), tehát 1 osztálynak csak 1 ősosztálya lehet (interfészek esetén ez nem igaz)
public class Orokles
{
    public static class SzuloOsztaly
    {
        protected int a;
        protected int b;

        public SzuloOsztaly(int a, int b)
        {
            this.a = a;
            this.b = b;
        }

        protected void hello()
        {
            System.out.println("Szia a SzuloOsztályban");
        }
    }

    //extends kulcsszóval örököltetünk
    //itt a GyerekOsztály a gyerek osztály (child class), a SzuloOsztaly pedig a szülő osztály (parent class)
    public static class GyerekOsztaly extends SzuloOsztaly
    {
        private int c;
        int a;

        public GyerekOsztaly(int a, int b, int c, int d)
        {
            //super kulcsszóval érjük el a szülő osztályban lévő metódusokat, jelen esetben a konstruktort
            //konstruktor esetén, a super(....)-nek a legelső kifejezésnek kell lennie
            super(a, b);
            this.c = c;
            this.a = d;
        }

        @Override
        public void hello()
        {
            System.out.println("Felülírt hello() metódus");
        }

        public void helloASzuloOsztalybol()
        {
            super.hello();
        }

        public void szamol()
        {
            System.out.println("A szulő osztályban található 'a' értéke " + super.a);
            System.out.println("A gyerek osztályban található 'a' értéke " + this.a);
            System.out.println(a + b + c);
        }
    }

    public static void main(String[] args)
    {
        int a = 10;
        int b = 20;
        int c = 30;
        int d = 40;
        //statikus típus a SzuloOsztaly, dinamikus típus pedig a GyerekOsztaly
        SzuloOsztaly osztaly = new GyerekOsztaly(a, b, c, d);
        osztaly.hello();
        //a szamol() metódus nem elérhető, mert a statikus típus az a SzuloOsztaly, abban pedig nincs szamol() metódus
//        osztaly.szamol();

        GyerekOsztaly osztaly2 = new GyerekOsztaly(a, b, c, d);
        //mostmár van szamol() metódus, mert a statikus típus GyerekOsztaly
        osztaly2.szamol();

        //instanceof vs getClass
        //instanceof azt vizsgálja, hogy a bal oldalon lévő érték (osztaly) az egy példánya e a jobb oldali osztálynak vagy annak valamilyen leszármazottja
        System.out.println(osztaly instanceof GyerekOsztaly);
        System.out.println(osztaly instanceof SzuloOsztaly);
        //getClass azt vizsgálja, hogy a típusok megegyeznek e
        System.out.println(osztaly.getClass() == GyerekOsztaly.class);
        System.out.println(osztaly.getClass() == SzuloOsztaly.class);
    }
}
