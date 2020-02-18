package hu.java.tutorial;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

//JUnit tesztelés
//JUnit-ot használunk tesztesetek írására és futtatására
//ahogy a nevében is van, itt az egyes elemeket teszteljük (intergrációs tesztek esetén pedig több modul együttes működését)
public class Teszt
{
    @BeforeClass
    public static void beforClass()
    {
        System.out.println("Csak egyszer fut le, méghozzá mielőtt a tesztelés elkezdődne!");
    }

    @Before
    public void before()
    {
        System.out.println("Minden teszteset előtt lefut!");
    }

    @Test
    public void test1()
    {
        String str = "Junit works";
        assertEquals("Junit works", str);
    }

    @Test
    public void test2()
    {
        int osszeg = 1 + 3;
        assertEquals(4, osszeg);
    }

    @Test
    public void failedTest()
    {
        int osszeg = 1 + 3;
        assertEquals(6, osszeg);
    }

    @Test
    @Ignore
    public void ignoreTest()
    {
        String hello = "hello";
        assertTrue(hello.equals("hello"));
        System.out.println("Ignorált teszt");
    }
}
