package hu.java.tutorial.java8;

public interface InterfaceChanges2 extends InterfaceChanges
{
    @Override
    default String func2()
    {
        String result = InterfaceChanges.super.func2();
        return result + "_override";
    }
}
