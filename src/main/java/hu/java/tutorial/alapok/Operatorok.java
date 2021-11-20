package hu.java.tutorial.alapok;

//Operátorokat a változók manipulálására használunk
//Több csoportba is sorolhatók (aritmetikai, kapcsolati, logikai, értékváltoztató)
public class Operatorok
{
    public static void main(String[] args)
    {
        int a = 10;
        int b = 20;

        //Aritmetikai
        System.out.println(a + b); //összeadás
        System.out.println(a - b); //kivonás
        System.out.println(a * b); //szorzás
        System.out.println(a / b); //osztás
        System.out.println(a % b); //maradékos osztás, pl.: 5%2=1

        //Kapcsolati
        System.out.println(a == b); //egyenlő-e "a" és "b" értéke (Stringek esetén az equals() metódust használjuk)
        System.out.println(a != b); //nem egyenlőséget vizsgál
        System.out.println(a > b); //nagyobb
        System.out.println(a < b); //kisebb
        System.out.println(a >= b); //nagyobb vagy egyenlő
        System.out.println(a <= b); //kisebb vagy egyenlő

        //Logikai
        boolean igen = true;
        boolean nem = false;
        System.out.println(igen && nem); //és
        System.out.println(igen || nem); //vagy

        //Értékváltoztató
        System.out.println(++a); //"a" értékét megnöveli 1-gyel
        System.out.println(--a); //"a" értékét csökkenti 1-gyel
        int l = 0;
        System.out.println(l++);
        System.out.println(l);
        int o = 0;
        System.out.println(++o);

        int p = 10; // = értékadás
        p = p + 2;
        p += 2; //hozzáad p-hez 2-t, ugyanaz mintha azt írnánk, hogy p=p+2
        p -= 2; //levon p-ből 2-t -> p=p-2
        p *= 2; //p-t megszorozza 2-vel -> p=p*2
        p /= 2; //p-t elosztja 2-vel -> p=p/2
        p %= 2; //p-t maradékosan elosztja 2-vel -> p=p%2
        p ^= 2; //p-t négyzetre emeli -> p=p^2
    }


}
