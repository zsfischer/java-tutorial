package hu.java.tutorial.java8;

public class SingletonDemo
{
    private static SingletonDemo instance;

    private SingletonDemo()
    {
    }

    public synchronized static SingletonDemo getInstance()
    {
        if (instance == null)
        {
            instance = new SingletonDemo();
        }
        return instance;
    }

    public String sayHi(String s)
    {
        return "Hi " + s;
    }
}
