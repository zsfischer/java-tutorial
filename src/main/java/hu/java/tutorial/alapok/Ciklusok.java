package hu.java.tutorial.alapok;

import java.util.Arrays;
import java.util.List;

//Ciklusokat (loop) azért használunk, hogy pl egy listán végigmenjünk az egyes elemeken
public class Ciklusok {

  public static void main(String[] args) {
    //abc nevű lista, amely String-eket tartalmaz
    List<String> abc = Arrays.asList("a", "b", "c", "d", "e", "f");

    //for ciklus több féle képpen
    //szimplán végigmegyünk a listánkon
    //a következő for ciklusok ugyanazt csinálják
    for (int i = 0; i < abc.size(); ++i) {
      System.out.println(abc.get(i));

      //ha az abc lista eleme "d", akkor menjünk tovább
      if (abc.get(i).equals("d")) //==, equals()
      {
        continue;
      }

      //ha az abc lista eleme "c", akkor lépjünk ki a ciklusból azonnal
      if (abc.get(i).equals("c")) {
        break;
      }
    }

    //forEach ciklus
    for (int i = 0; i < abc.size(); ++i) {
      System.out.println(abc.get(i));
    }

    for (String elem : abc) {
      System.out.println(elem);
    }

    //Java8-as megoldás
    abc.forEach(elem -> System.out.println(elem));
    //Method reference
    abc.forEach(System.out::println);

    //while ciklus
    //while(feltétel) {} -> addig megy a ciklus, ameddig a feltétel igaz
    //az is lehet, hogy egyszer sem fut le, hiszen a feltétel vizsgálattal kezdődik a ciklus
    for (int a = 0; a < 10; ++a) {
      System.out.println(a);
    }

    int a = 0;
    while (a < 10) {
      System.out.println(a);
      a++;
    }

//        int c = 0;
//        if(c++==0){
//            System.out.println("c 0 volt");
//        }else{
//            System.out.println("c nem 0 volt");
//        }
//        System.out.println("c értéke: " + c);
//
//        int k = 0;
//        if(++k==0){
//            System.out.println("k 0 volt");
//        }else{
//            System.out.println("k nem 0 volt");
//        }
//        System.out.println("k értéke: " + k);

    //do..while ciklus
    //do{
    //
    // }while(feltétel) -> addig megy, ameddig a feltétel igaz.
    //legalább 1x lefut, hiszen a feltétel vizsgálat csak a ciklus végén történik meg
    do {
      System.out.println(a);
      a++;
    }
    while (a < 20);
  }
}
