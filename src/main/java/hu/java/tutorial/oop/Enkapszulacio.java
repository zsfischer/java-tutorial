package hu.java.tutorial.oop;

//Más néven, elrejtés
//OOP egyik alapja
//Lényege, hogy az összetartozó adatokat (változók, metódusok) becsomagoljuk egyetlen önálló egységgé
//Enkapszuláció esetén az osztály változói rejtve maradnak a többi osztály elől
//ahhoz, hogy elérjük az enkapszulációt:
//- a változóknak private-nek kell lenniük
//- public getter-ek és setter-ek kellenek, amelyeken keresztül elérjük és változtathatjük a változók értékeit
//az enkapszuláció előnyei:
//- az osztály változói lehetnek read-only vagy write-only
//- az osztálynak teljes irányítása van afelett, hogy mik tárolódnak a változóiban
public class Enkapszulacio
{
    private String nev;
    private int kor;

    public String getNev()
    {
        return nev;
    }

    public void setNev(String nev)
    {
        this.nev = nev;
    }

    public int getKor()
    {
        return kor;
    }

    public void setKor(int kor)
    {
        this.kor = kor;
    }

    public static void main(String[] args)
    {
        Enkapszulacio enkapszulacio = new Enkapszulacio();
        enkapszulacio.setNev("Példa Gábor");
        enkapszulacio.setKor(22);
        System.out.println(enkapszulacio.getNev());
        System.out.println(enkapszulacio.getKor());
    }
}
