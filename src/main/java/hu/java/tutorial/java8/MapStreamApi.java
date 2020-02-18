package hu.java.tutorial.java8;

import java.util.HashMap;
import java.util.Map;

public class MapStreamApi
{
    public static void main(String[] args)
    {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++)
        {
            // putIfAbsent: ha van már olyan kulcs, akkor nem irja felul az erteket
            map.putIfAbsent(i, "val" + i);
        }

        map.forEach((key, value) -> System.out.println(key + "=" + value));

        // ha van value, akkor valtoztat
        map.computeIfPresent(3, (key, val) -> val + key);
        System.out.println(map.get(3));

        map.computeIfPresent(3, (num, val) -> null);

        // ha nincsen value, akkor valtoztat
        map.computeIfAbsent(3, num -> num + "3");
        System.out.println(map.get(3));

    }

}
