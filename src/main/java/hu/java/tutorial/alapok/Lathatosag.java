package hu.java.tutorial.alapok;

//Láthatósági típusok alatt azt értjük, hogy az adott elem milyen range-ben érhető el, kik láthatják
//4 fajtája van: public, protected, package-private, private
public class Lathatosag
{
    //bárhol látható (osztályon kívül és belül is)
    public int a;

    //csak ebben az osztályban, és az ebből az osztályból leszármazó osztályokban látható
    protected String b;

    //amikor nem írok semmilyen kulcsszót, akkor lesz a változó láthatósága package-private.
    // Ekkor csak ez az osztály, és az ugyanebben a package-ben lévő osztályok láthatják
    boolean c;

    //csak ez az osztály látja
    private long d;

    //Egyéb módosítók
    //static - osztályszintű változók és metódusok definiálására
    //final - konstans változók definiálására (az értéke később nem változtatható meg)
    //abstract - abstract osztályok/metódusok létrehozására
    //synchronized/volatile - szálkezelésnél számít
}
