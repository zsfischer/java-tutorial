package hu.java.tutorial.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApi
{
    private static List<Long> numbers = new ArrayList<>();

    private static List<Item> list = new ArrayList<>();
    private static long sumVal = 0;

    static
    {
        list.add(new Item(2, "name2", 20));
        list.add(new Item(1, "name1", 10));
        list.add(new Item(5, "name5", 50));
        list.add(new Item(3, "name3", 30));
        list.add(new Item(4, "name4", 30));
        list.add(new Item(6, "name6", 60));

        numbers.add(2L);
        numbers.add(1L);
        numbers.add(6L);
        numbers.add(5L);
        numbers.add(4L);
        numbers.add(3L);
    }

    @SuppressWarnings("unused")
    public static void main(String[] args)
    {
        // forEach
        list.forEach(item -> sumVal += item.getValue());
        list.forEach(item -> System.out.println(item));
        list.forEach(System.out::println);
        list.stream().forEach(System.out::println);

        // stream iterate - limit
        List<Integer> intList = Stream.iterate(0, i -> i + 3).limit(10).collect(Collectors.toList());

        System.out.println(intList);

        // sort - local
        Stream<Item> sortedStream = list.stream().sorted((a, b) -> a.getName().compareTo(b.getName()));
        List<Item> sortedList = sortedStream.collect(Collectors.toList());

        List<Item> sortedList2 = list.stream().sorted(Comparator.comparing(Item::getName)).collect(Collectors.toList());

        // sort - inplace
        list.sort((a, b) -> a.getName().compareTo(b.getName()));
        list.sort(Comparator.comparing(Item::getName));

        // reversed sort
        List<Item> revSortedList = list.stream().sorted(Comparator.comparing(Item::getName).reversed()).collect(
                Collectors.toList());

        // multiple sort
        List<Item> multiSortedList = list
                .stream()
                .sorted(Comparator.comparing(Item::getName).thenComparing(Item::getValue))
                .collect(Collectors.toList());

        // Filter
        Stream<Item> res0 = list.stream().filter(item -> item.getId() == 2);

        Optional<Item> res = list.stream().filter(item -> item.getId() == 2).findFirst();
        Item item2 = res.get();

        Item res1 = list.stream().filter(item -> item.getId() == 2).findFirst().orElse(null);

        long count = list.stream().filter(item -> item.getId() == 2).count();

        List<Long> filteredNumbers = numbers.stream().filter(item -> item > 3).collect(Collectors.toList());

        OptionalDouble average = list.stream().mapToLong(item -> item.getValue()).average();
        double averageValue = average.getAsDouble();

        // max
        OptionalLong maxValue = list.stream().mapToLong(item -> item.getValue()).max();
        OptionalLong maxValue01 = list.stream().mapToLong(Item::getValue).max();
        OptionalLong maxValue2 = numbers.stream().mapToLong(value -> value).max();
        OptionalLong maxValue3 = numbers.stream().mapToLong(Long::longValue).max();

        // min
        OptionalLong minValue = list.stream().mapToLong(item -> item.getValue()).min();
        OptionalLong minValue2 = numbers.stream().mapToLong(Long::longValue).min();

        // sum
        long sumValue = list.stream().mapToLong(item -> item.getValue()).sum();
        long sumValue1 = list.stream().mapToLong(Item::getId).sum();
        long sumValue2 = numbers.stream().mapToLong(Long::longValue).sum();

        // reduce
        long sumValue3 = numbers.stream().reduce((a, b) -> a + b).get();
        long sumValue4 = numbers.stream().reduce(Long::sum).get();
        numbers.stream().reduce(Long::sum).ifPresent(value -> System.out.println(value));
        numbers.stream().reduce(Long::sum).ifPresent(System.out::println);
        // reduce - join
        String[] strArray = {"a", "b", "c"};
        String joinedStrings = Arrays.stream(strArray).reduce((a, b) -> a + "," + b).get();
        String joinedStrings2 = String.join(",", strArray);
        // reduce with start value
        long sumValue5 = numbers.stream().reduce(10l, Long::sum);

        // collect
        List<Item> foundItems = list.stream().filter(item -> item.getName().toLowerCase().contains("name")).collect(
                Collectors.toList());

        // collect joining
        String joinedString = list.stream().map(Item::getName).collect(Collectors.joining(","));
        String joinedString2 = numbers.stream().map(String::valueOf).collect(Collectors.joining(","));

        System.out.println();
    }

    private static class Item
    {
        private long id;

        private String name;

        private long value;

        public Item(long id, String name, long value)
        {
            super();
            this.id = id;
            this.name = name;
            this.value = value;
        }

        public long getId()
        {
            return id;
        }

        public String getName()
        {
            return name;
        }

        public long getValue()
        {
            return value;
        }

        @Override
        public String toString()
        {
            return "Item [id=" + id + ", name=" + name + ", value=" + value + "]";
        }
    }
}
