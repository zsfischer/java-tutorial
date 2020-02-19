package hu.java.tutorial.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//Collections
//azonos típusú elemek dinamikus gyűjteménye
//Leggyakrabban használtak: ArrayList, LinkedList, HashSet, HashMap -> ezeket összefoglaló néven collections-öknek, azaz gyűjteményeknek nevezzük
//Az ősosztálya minden collection-nek a Collection interfész, amely a gyűjtemények fő metódusait deklarálja
public class Gyujtemeny
{
    public static void main(String[] args)
    {
        //List interface
        //azonos típusú elemek gyűjteménye
        //indexük alapján tudjuk lekérdezni az egyes elemeket(0-tól kezdődik az indexelés)
        //tartalmazhat duplikátumokat, azaz ugyanaz az elem többször is szerepelhet
        //a Collection interface-ben deklarált metódusokon kívül saját metódusokkal is rendelkezik
        //ArrayList, LinkedList
        List<Integer> egeszLista = new ArrayList<>();
        egeszLista.add(2);
        egeszLista.add(3);
        egeszLista.add(2, 1);
        System.out.println("A lista 3. eleme: " + egeszLista.get(2));

        //rendezzük a listát természetes rendezettség alapján (növekvő)
        egeszLista.sort(Comparator.naturalOrder());
        System.out.println(egeszLista);
        System.out.println("A lista mérete: " + egeszLista.size());

        //kivesszük a 1-es értékű elemet a listából
        egeszLista.remove(new Integer(1));
        System.out.println(egeszLista.toString());

        //kivesszük a 0., azaz 1. elemet a listából
        egeszLista.remove(0);
        System.out.println(egeszLista.toString());

        //lista inicializálása kezdeti értékekkel egy Collection segítségével
        List<Integer> lista2 = new ArrayList<>(Arrays.asList(10, 20, 30));
        System.out.println(lista2.toString());

        //addAll(); hozzáadja a listához az összes elemet, ami a Collection-ben van
        List<Integer> integers = Arrays.asList(40, 50);
        lista2.addAll(integers);
        System.out.println(lista2.toString());

        //üres e a lista?
        System.out.println(lista2.isEmpty());

        //boolean-nal tér vissza, hogy tartalmazza e az adott objectumot vagy sem
        System.out.println(lista2.contains(20));

        //List átalakítása tömbbé
        Object[] intArray = lista2.toArray();
        System.out.println(Arrays.toString(intArray));

        //végig iterálás egy listán (de ennél vannak jobb módszerek is)
        Iterator<Integer> listaIterator = lista2.iterator();
        while (listaIterator.hasNext())
        {
            System.out.println(listaIterator.next());
        }

        //kitakarítja a listát
        lista2.clear();

        //----------------------------------------------------
        //Set interface
        //a legnagyobb különbség a List és Set között az az, hogy a Set NEM tartalmazhat duplikátumokat
        //HashSet nem garantálja a sorrendet (pl: LinkedHashSet garantálja)
        Set<String> set = new HashSet<>();
        set.add("egy");
        set.add("kettő");
        set.add("három");
        set.add("egy");

        System.out.println(set.toString());
        System.out.println(set.size());

        //----------------------------------------------------
        //Map interface
        //kulcs-érték párokat tartalmaz
        //a kulcs egyedi, az érték nem
        //kulcs alapján kitudjuk kérni a hozzá tartozó értéket
        //HashMap nem garantálja a beszúrás szerinti sorrendet (LinkedHasMap garantálja)
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "egy");
        map.put(2, "ketto");
        map.put(3, "harom");
        map.put(4, "harom");
        System.out.println(map.toString());

        //ha olyan kulcs-érték párost akarunk beszúrni, ahol a kulcs már benne van a map-ben, akkor felülírjuk a már korábbi elem értékét
        map.put(1, "ez az új egy");
        System.out.println(map.toString());

        //visszaadja az 1-es kulcshoz tartozó értéket
        System.out.println(map.get(1));

        //visszaadja, hogy van e ilyen kulcs/érték már a map-ben
        System.out.println(map.containsKey(1));
        System.out.println(map.containsValue("nyolc"));

        //üres e a map
        System.out.println(map.isEmpty());

        //kiveszi az 1-es kulcsú elemet a map-ből
        map.remove(1);
        System.out.println(map.toString());

        //map mérete
        System.out.println(map.size());

        //visszaadja a map-ben található értékeket egy Collection-ben
        Collection<String> values = map.values();

        Map<Integer, String> map2 = new HashMap<>();
        map2.put(5, "öt");
        map2.put(6, "hat");

        //hozzááadunk a map-hez egy másik map-et
        map.putAll(map2);
        System.out.println(map.toString());
    }
}
