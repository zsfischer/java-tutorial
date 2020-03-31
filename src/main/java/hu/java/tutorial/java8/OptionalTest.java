package hu.java.tutorial.java8;

import java.util.Optional;

public class OptionalTest
{
    public static void main(String[] args)
    {
        Optional<String> o1 = Optional.empty();
        try
        {
            System.out.println(o1.get());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        Optional<Bean1> bean1 = Optional.of(new Bean1(1L, "name1"));

        // get values
        System.out.println(bean1.get());
        bean1.ifPresent(value -> System.out.println(value));
        bean1.ifPresent(value -> System.out.println(value.id));
        bean1.ifPresent(System.out::println);
        if (bean1.isPresent())
        {
            System.out.println(bean1.get());
        }

        // orElse...
        Bean1 b1 = bean1.orElse(null);
        Bean1 b2 = bean1.orElseThrow(RuntimeException::new);
        Bean1 b3 = bean1.orElseGet(() -> new Bean1());

        // map
        Optional<String> bean1Name1 = bean1.map(value -> value.getName());
        bean1Name1 = bean1.map(Bean1::getName);

        Optional<Optional<String>> s = bean1.map(value2 -> Optional.ofNullable(value2.getName()));
        Optional<String> s1 = bean1.flatMap(value2 -> Optional.ofNullable(value2.getName()));

        // filter
        Optional<Bean1> filteredBean1 = bean1.filter(value -> 1L == value.getId());

        // can contain null
        Bean1 nullBean = null;
        Optional<Bean1> bean2 = Optional.ofNullable(nullBean);
        bean2.ifPresent(value -> System.out.println(value));
    }

    protected static class Bean1
    {
        private Long id;

        private String name;

        public Bean1()
        {
        }

        public Bean1(Long id, String name)
        {
            this.id = id;
            this.name = name;
        }

        public Long getId()
        {
            return id;
        }

        public void setId(Long id)
        {
            this.id = id;
        }

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        @Override
        public String toString()
        {
            StringBuilder builder = new StringBuilder();
            builder.append("Bean1 [id=");
            builder.append(id);
            builder.append(", name=");
            builder.append(name);
            builder.append("]");
            return builder.toString();
        }
    }
}
