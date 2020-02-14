package hu.java.tutorial.alapok;

public class Valtozok
{
    //Minden változónak van egy típusa és neve
    //Minden változót deklarálni kell, mielőtt használni tudnánk
    int a = 10;
    String b, c;
    double d = 10.3, d2 = 15.78;

    //Elnevezés
    //Ezekkel kezdődhet: A-Z, a-z, $, _
    //az első karakter után már lehet szám
    //kulcsszavak nem lehetnek változónevek
    //a változónevek case-sensitive-k, tehát a kis és nagybetű számít. alma nem ugyanaz, mint az Alma
    //jó változónevek: age, $salary, _value, __1_value
    //nem jó változónevek: 123abc, -salary

    //Változó típusok
    //Java-ban 3 féle változót különböztetünk meg -> lokális, példány változó, statikus/osztály színtű változó

    //Lokális változók
    //metódusban, konstruktorban vagy blokkokban vannak deklarálva
    //akkor jönnek létre, amikor a metódusba, konstruktorba, blokkba belép a program, és addig élnek, ameddig az adott metódus, konstruktor, blokk végére nem érünk
    //nem használható rájuk a private, public, protected kulcsszavak, tehát a láthatósági kucsszavak
    //csak a deklarált metódusban, konstruktorban vagy blokkban láthatóak
    //nincs default értéke a lokális változóknak, szóval mikor deklaráljuk, akkor értéket is kellene adnunk neki
    //példa:
    public class LokalisValtozo
    {
        public void kor()
        {
            //ez egy lokális változó
            int kor = 0;
            kor = kor + 7;
            System.out.println("Kor = " + kor);

            //itt a "szam"-nak nem adtunk értéket, amikor deklaráltuk, ezért hibát kapunk
//            int szam;
//            szam = szam + 12;
//            System.out.println("Szam = " + szam);
        }
    }


    //Példány változók
    //osztályon belül, de metóduson, konstruktoron és blokkon kívül vannak deklarálva
    //létrejön, amikor a new kulcsszóval példányosítjuk az osztályt
    //adható nekik láthatósági módosító kulcsszavak (public, private, protected)
    //az osztályon belül minden metódus, konstruktor és blokk látja őket
    //általában a láthatóságuk private-ra (ez az ajánlott) van állítva, és getter/setter használatával érjük el vagy módosítjuk a változó értékét
    //van default értékük
    //értéket kaphatnak deklaráláskor, konstruktorban, vagy bárhol
    //példa:
    public class Dolgozo
    {

        //példány változó, ami minden másik osztályból látható
        public String nev;

        //példány változó, amely csak ebben az osztályban látható
        private double fizetes;

        // konstruktorral beállítjuk a nev értékét
        public Dolgozo(String nev)
        {
            this.nev = nev;
        }

        //setter segítségével tudjuk állítani a "fizetes" értékét, azért, mert private
        public void setFizetes(double fizetes)
        {
            this.fizetes = fizetes;
        }

        //kiíratjuk a konzolra az osztály változóinak értékeit
        public void adatokKiirasa()
        {
            System.out.println("név  : " + this.nev);
            System.out.println("fizetes :" + this.fizetes);
        }
    }


    //Statikus/Osztály szintű változók
    //a static kulcsszó segítségével vannak deklarálva az osztályon belül, de a metódusokon, konstrukorokon és blokkokon kívül
    //csak 1x jön létre, függetlenül attól, hogy hányszor példányosítjuk az adott osztályt
    //általában konstansként vannak deklarával (konstans -> az értéke nem változtatható meg értékadás után)
    //a statikus memóriában vannak tárolva
    //általában public-ként deklaráljuk őket, hiszen más osztályokból is el szeretnénk érni
    //van default értéke
    //statikus változók elérése a következő -> OsztályNev.VáltozóNev
    //amikor úgy deklaráljuk a statikus változót, hogy public static final ...., akkor nagybetűvel írjuk a változó nevét
    //ha nem public és nem is final, akkor ugyanaz az elnevezési szabály érvényes rá, mint a lokális és példány változókra
    //példa:
    public class Ember
    {

        // ez egy publikus, osztályszintű, konstans változó, amelyet másik osztályból úgy érünk el, hogy Ember.NEMZETISEG
        public static final String NEMZETISEG = "Magyar";

    }
}
