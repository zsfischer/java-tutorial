package hu.java.tutorial.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class StreamApi2
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

    public static void main(String[] args)
    {
        /**
         * Filter1
         */
        list.stream().filter((s) -> s.startsWith("a")).forEach(System.out::println);

        /**
         * Filter2
         */
        List<String> filteredList = new ArrayList<>();
        // list.stream().filter((s) -> s.endsWith("1")).forEach((s) ->
        // filteredList.add(s));
        list.stream().filter((s) -> s.endsWith("1")).forEach(filteredList::add);
        System.out.println(filteredList);

        filteredList.clear();

        /**
         * Filter3
         */
        Stream<String> stream = list.stream().filter((s) -> s.endsWith("1"));
        stream.iterator().forEachRemaining(filteredList::add);
        System.out.println(filteredList);

        /**
         * Sort
         */
        list.stream().sorted().forEach(System.out::println);

        /**
         * Map + sort
         */
        list.stream().map(String::toUpperCase).sorted((a, b) -> b.compareTo(a)).forEach(System.out::println);
        list.stream().map(String::toUpperCase).sorted(Comparator.reverseOrder()).forEach(System.out::println);

        /**
         * Match check
         */
        boolean anyStartsWithA = list.stream().anyMatch(s -> s.startsWith("a"));

        System.out.println(anyStartsWithA);

        boolean allStartsWithA = list.stream().allMatch(s -> s.startsWith("a"));

        System.out.println(allStartsWithA);

        boolean noneStartsWithZ = list.stream().noneMatch(s -> s.startsWith("z"));

        System.out.println(noneStartsWithZ);

        /**
         * Count
         */
        long startsWithB = list.stream().filter((s) -> s.startsWith("b")).count();

        System.out.println(startsWithB);

        /**
         * Sequential sort: lassabb feldolgozas
         */
        long t0 = System.nanoTime();

        long count = list.stream().sorted().count();
        System.out.println(count);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));

        /**
         * Parallel stream sort: sokkal gyorsabb feldolgozas !!! Nem biztos az
         */
        t0 = System.nanoTime();

        count = list.parallelStream().sorted().count();
        System.out.println(count);

        t1 = System.nanoTime();

        millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("parallel sort took: %d ms", millis));
    }
}
