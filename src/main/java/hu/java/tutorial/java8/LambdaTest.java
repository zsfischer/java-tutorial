package hu.java.tutorial.java8;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LambdaTest
{
    @SuppressWarnings("unused")
    public static void main(String[] args)
    {
        List<String> names = Arrays.asList("peter", "gabor", "bélqa", "norbert", "viktor");

        Collections.sort(names, new Comparator<String>()
        {
            @Override
            public int compare(String a, String b)
            {
                int result = 0;
                if (a == b)
                {
                    result = 0;
                }
                else if (a == null)
                {
                    result = -1;
                }
                else if (b == null)
                {
                    result = 1;
                }
                else
                {
                    result = a.compareTo(b);
                }
                return result;
            }
        });

        Collections.sort(names, (String a, String b) -> {
            int result = 0;
            if (a == b)
            {
                result = 0;
            }
            else if (a == null)
            {
                result = -1;
            }
            else if (b == null)
            {
                result = 1;
            }
            else
            {
                result = a.compareTo(b);
            }
            return result;
        });
        Collections.sort(names, (String a, String b) -> a.compareTo(b));
        Collections.sort(names, (a, b) -> a.compareTo(b));
        Collections.sort(names, String::compareTo);
        Collections.sort(names, Comparator.naturalOrder());
        names.sort(Comparator.naturalOrder());
        names.sort(String::compareTo);
        List<String> sortedList = names.stream().sorted().collect(Collectors.toList());

        /**
         * Functional interface example
         */
        MyFunctionalIFace<Integer, String> functional000 = new MyFunctionalIFace<Integer, String>()
        {
            @Override
            public Integer test(String p1)
            {
                return Integer.valueOf(p1);
            }

        };

        MyFunctionalIFace<Integer, String> functional0 = p1 -> Integer.valueOf(p1);
        System.out.println(functional0.test("3"));

        MyFunctionalIFace<String, String> functional1 = (p1) -> "Hello World " + p1 + "!";
        System.out.println(functional1.test("Java"));

        MyFunctionalIFace<Integer, String> functional2 = (param1) -> Integer.valueOf(param1);
        System.out.println(functional2.test("3"));

        MyFunctionalIFace<Integer, String> functional3 = Integer::valueOf;
        System.out.println(functional3.test("3"));

        MyFuncImpl object = new MyFuncImpl();

        MyFunctionalIFace<Integer, String> functional34 = object::testValami;
        System.out.println(functional34.test("3"));

        MyFunctionalIFace<Integer, String> functional4 = (param1) -> {
            param1 += "10";
            return Integer.valueOf(param1);
        };
        System.out.println(functional4.test("3"));

        System.out.println(functional4.test2("3"));

        /**
         * Functional constructor example
         */
        FunctionalCommonObjectIFace<Integer, String> commonObject10 = new FunctionalCommonObjectIFace<Integer, String>()
        {
            @Override
            public Integer create(String p1)
            {
                return new Integer(p1);
            }
        };
        Integer i10 = commonObject10.create("3");
        System.out.println(i10);

        FunctionalCommonObjectIFace<Integer, String> commonObject1 = Integer::new;
        Integer i1 = commonObject1.create("3");
        System.out.println(i1);

        FunctionalCommonObjectIFace<BigDecimal, Double> commonObject2 = BigDecimal::new;
        BigDecimal bd1 = commonObject2.create(123.45);
        System.out.println(bd1);

        FunctionalCommonObjectIFace<MyObject, String> commonObject3 = MyObject::new;
        MyObject fco1 = commonObject3.create("4");
        System.out.println(fco1.s);

        /**
         *
         * DEFAULT functional interfaces
         *
         */

        /**
         * Predicate: logikai ertekkel ter vissza
         */
        Predicate<String> predicate = (string) -> string.length() > 0;
        System.out.println(predicate.test("testString1"));

        Predicate<String> predicate2 = s -> {
            if (s == null)
            {
                return false;
            }
            return s.length() > 0;
        };
        System.out.println(predicate.test("testString1"));

        System.out.println(predicate2.test(null));

        testPredicate(s -> s.length() > 0);

        /**
         * Function: adott muvelet vegrehajtasa, visszateresi ertekkel
         */
        Function<String, Integer> function0 = s -> Integer.valueOf(s);
        System.out.println(function0.apply("13"));

        Function<String, Integer> function = Integer::valueOf;
        System.out.println(function.apply("13"));

        /**
         * Supplier: peldanyositas
         */
        Supplier<MyObject> personSupplier0 = () -> new MyObject("s1");
        MyObject newMyObject0 = personSupplier0.get();

        Supplier<MyObject> personSupplier = MyObject::new;
        MyObject newMyObject = personSupplier.get();

        /**
         * Consumer: adott muvelet vegrehajtasa, visszateresi ertek nelkul
         */
        Consumer<String> consumer = s -> System.out.println("Hello world " + s + "!");
        consumer.accept("Java");

        /**
         * Comparator
         */
        Comparator<MyObject> comparator = (o1, o2) -> o1.s.compareTo(o2.s);
        Comparator<MyObject> comparator2 = Comparator.comparing(o -> o.s);

        MyObject o1 = new MyObject("Eniko");
        MyObject o2 = new MyObject("Peter");

        System.out.println(comparator.compare(o1, o2));
    }

    private static Boolean testPredicate(Predicate<String> p)
    {
        return p.test("s1");
    }

    @FunctionalInterface
    private interface MyFunctionalIFace<R, P>
    {

        public R test(P p1);

        default public String test2(String p1)
        {
            return "test value: " + p1;
        }
    }

    @FunctionalInterface
    private interface FunctionalCommonObjectIFace<R, P>
    {

        public R create(P p1);
    }

    private static class MyFuncImpl
    {

        public static Integer testValamis(String p1)
        {
            return Integer.valueOf(p1);
        }

        public Integer testValami(String p1)
        {
            return Integer.valueOf(p1);
        }

        public String testValami2(String p1)
        {
            return p1;
        }
    }

    private static class MyObject
    {

        String s;

        public MyObject()
        {
        }

        public MyObject(String s)
        {
            this.s = s;
        }
    }
}
