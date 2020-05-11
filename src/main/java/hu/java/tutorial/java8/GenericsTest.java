package hu.java.tutorial.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericsTest
{
    @SuppressWarnings("unchecked")
    public static <R, P1, P2> R testMethod1(P1 p1, P2 p2)
    {
        return (R) "s1";
    }

    public static void main(String[] args)
    {
        
        String s = testMethod1("", 1);
        System.out.println(s);

        List<String> strList = new ArrayList<>();
        strList.add("3");
        strList.add("1");
        strList.add("2");

        strList.sort(new Comparator<String>()
        {
            @Override
            public int compare(String a, String b)
            {
                return a.compareTo(b);
            }
        });

        strList.sort((a, b) -> a.compareTo(b));

        System.out.println(strList);

        Map<String, Integer> map = new HashMap<>();
        map.put("3", 3);
        map.put("1", 1);
        map.put("2", 2);
        map.forEach((key, value) -> System.out.println(key + "=" + value));
    }
}
