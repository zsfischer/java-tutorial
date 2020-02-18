package hu.java.tutorial;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner
{
    public static void main(String[] args)
    {
        Result result = JUnitCore.runClasses(Teszt.class);

        for (Failure failure : result.getFailures())
        {
            System.out.println(failure.toString());
        }

        System.out.println("Elbukott tesztesetek száma: " + result.getFailureCount());

        System.out.println("Ignorált tesztesetek száma: " + result.getIgnoreCount());

        System.out.println("Tesztelés eredménye: " + (result.wasSuccessful() ? "sikeres" : "sikertelen"));
    }
}
