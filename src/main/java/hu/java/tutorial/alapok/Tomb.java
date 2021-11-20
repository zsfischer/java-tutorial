package hu.java.tutorial.alapok;

//Tömböket használunk azért, hogy ha pl van 100 db egész számunk akkor ne kelljen 100 int-et deklarálni, hanem csak egy int-eket tartalmazó tömböt, amelynek aztán az elemeit be tudjuk állítani
//a tömb egy fix méretű, azonos típusú objektumok gyűjteménye
public class Tomb
{
    public static void main(String[] args)
    {
        //Deklarálás
        int[] sajatLista; //vagy int sajatLista[];

        //Inicializálási fajták
        //meg kell adnunk, hogy mekkora méretű, azaz hány elemet fog tartalmazni a tömbünk
        int[] sajatLista2 = new int[3];
        int[] sajatLista3 = {1, 2, 3, 4, 5, 6, 7};
        int[] sajatLista4 = new int[]{1, 2, 3, 4, 5, 6};


        //egy tömb elemeit az indexeik alapján érünk el
        //az indexelés 0-tól kezdődik
        //visszaadja a sajatLista3 első elemét
        System.out.println(sajatLista3[0]);

        //mivel 0-tól kezdődik az indexelés, ezért a tömb utolsó elemének indexe a tömbMéret - 1
        //visszaadja a sajatLista3 utolsó elemét
        System.out.println(sajatLista3[sajatLista3.length - 1]);

        //tömb feltöltése
        for (int i = 0; i < sajatLista2.length; ++i)
        {
            //beállítjuk a tömb i. elemének értékét i-re
            sajatLista2[i] = i;
        }
//        System.out.println(Arrays.toString(sajatLista2));

        //forEach tömbökön
        for (int elem : sajatLista2)
        {
            System.out.println(elem);
        }
    }
}
