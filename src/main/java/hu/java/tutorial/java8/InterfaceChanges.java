package hu.java.tutorial.java8;

/*
 *
 * New default methods
 *
 */
public interface InterfaceChanges
{
    String func1();

    default String func2()
    {
        return "func2 called";
    }

    default String func3()
    {
        return "func3 called";
    }

    default String func4()
    {
        return "func4 called";
    }
}
