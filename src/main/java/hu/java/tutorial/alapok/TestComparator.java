package hu.java.tutorial.alapok;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestComparator implements Comparator<String>
{
    @Override
    public int compare(String test1, String t1)
    {
        return test1.compareTo(t1);
    }

    public static void main(String[] args)
    {
        List<String> lista = Arrays.asList("egy", "kettő", "béla", "andor");
        System.out.println(lista);
        //Ha így akarom meghívni a Collections.sort metódust, hogy megadom neki a Comparatort is
        Collections.sort(lista, new TestComparator());
        //Ez egy rövidebb verzió
        lista.sort(new TestComparator());
        //Ezt pedig akkor tudom megtenni, hogy a lista elemeinek típusa implementálja a Comparable interfacet
        Collections.sort(lista);

        System.out.println(lista);
    }
}
