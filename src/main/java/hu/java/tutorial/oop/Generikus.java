package hu.java.tutorial.oop;

import java.util.Arrays;
import java.util.List;

//Az alap ötlet az az, hogy milyen jó lenne, ha lenne pl egy metódusom, amivel rendezni tudok egy int-ekből álló listát, egy String-ekből álló listát stb.
//Erre találták ki a java-ban a generikus osztályokat/metódusokat
public class Generikus<T>
{
    public T element;

    //<> között meg kell adnunk, hogy milyen típus-paraméterek szerepelnek majd a metódusban (,-vel elválasztva)
    //az adott betűvel hivatkozunk a típusra a ésőbbiekben
    //primitív típusokat nem reprezentálhatnak a típus-paraméterek
    public static <E> void listaKiir(List<E> lista)
    {
//        E e = lista.get(0);
//        if(e instanceof String){
//            int i = Integer.parseInt(lista.get(0));
//        }

        for (E elem : lista)
        {
            System.out.println(elem);
        }
    }

    public static void main(String[] args)
    {
        List<Integer> egeszLista = Arrays.asList(1, 2, 3, 4);
        listaKiir(egeszLista);

        List<String> szovegLista = Arrays.asList("egy", "ketto", "harom");
        listaKiir(szovegLista);

        List<Double> tizedesLista = Arrays.asList(10.5, 17.8, 5.67);
        listaKiir(tizedesLista);

        Generikus<String> generikus = new Generikus<>();
        generikus.element = "Szia";

        Generikus<Integer> generikus2 = new Generikus<>();
        generikus2.element = 13;

        Generikus<Boolean> generikus3 = new Generikus<>();
        generikus3.element = true;
    }
}
