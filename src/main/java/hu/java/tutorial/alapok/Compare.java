package hu.java.tutorial.alapok;

import java.util.Collections;
import java.util.Comparator;

//Comparable vs Comparator
public class Compare
{
    private static class Test1 implements Comparable<Test1>, Comparator<Test1>
    {

        private String nev;
        private int kor;

        public Test1(String nev, int kor)
        {
            this.nev = nev;
            this.kor = kor;
        }

        //Ehhez az osztálynak implementálnia kell a Comparable interfacet
        //Ahogy a nevében is benne van, a Comparable interface definiálja, hogy mi alapján hasonlítson össze két objectumot -> természetes rendezettség
        //Ha egy Test1 típusú objectumokból álló Listát rendezni szeretnék a sort() metódussal, akkor a Test1 objectumban kell lennie compareTo() metódusnak
        //a compareTo() által visszaadott értékek alapján rendeződik le a listánk
        @Override
        public int compareTo(Test1 test1)
        {
            int diff = nev.compareTo(test1.nev);
            if (diff != 0)
            {
                return diff;
            }
            return Integer.compare(kor, test1.kor);
        }

        //Ez is a rendezettségért felel, viszont ezt ki tudom szervezni egy külön osztályba is -> lásd TestComparator.java
        @Override
        public int compare(Test1 test1, Test1 test2)
        {
            int diff = test1.nev.compareTo(test2.nev);
            if (diff != 0)
            {
                return diff;
            }
            return Integer.compare(test1.kor, test2.kor);
        }
    }

    public static void main(String[] args)
    {
        Test1 test1 = new Test1("Zsolti", 10);
        Test1 test2 = new Test1("Béla", 20);
        Test1 test3 = new Test1("Andor", 30);
        Test1 test4 = new Test1("Zsolti", 20);

        System.out.println("Zsolti Bélával összehasonlítva: " + test1.compareTo(test3));

    }
}
