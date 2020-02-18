package hu.java.tutorial.java8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/*
 *
 * Auto close resources (instead of try/finally) that implement java.lang.AutoCloseable
 *
 */
public class TryWithResourceClose
{
    private static List<String> list = new ArrayList<>();

    static
    {
        list.add("ddd2");
        list.add("aaa2");
        list.add("bbb1");
        list.add("aaa1");
        list.add("bbb3");
        list.add("ccc");
        list.add("bbb2");
        list.add("ddd1");
    }

    static String readFirstLineFromFile(String path) throws IOException
    {
        try (BufferedReader br = new BufferedReader(new FileReader(path)))
        {
            return br.readLine();
        }
    }

    static void streamHandling()
    {
        try (Stream<String> stream = list.stream())
        {
            stream.forEach(System.out::println);
        }
    }
}
