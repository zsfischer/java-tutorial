package hu.java.tutorial.oop;

//hasonló az osztályokhoz, viszont ez absztrakt metódusok gyűjteménye (általában)
//szóval amikor egy osztály implementál egy interfészt, akkor az összes metódust implementálnia kell, ami az interfészben van (kivéve ha az osztály abstract, mivel az interfész metódusai absztaktak)
//interfész az absztrakt metódusokon kívül tartalmazhat konstansokat, default metódusokat (Java 8-tól), static metódusokat
//metódus-törzzsel csak a default és static metódusok rendelkezhetnek
//interface kulcsszóval írjuk le az interfészt
//az osztállyal ellentétben itt csak annak az osztálynak a viselkedését írjuk le, ami majd implementálja az interfészt
//Amiben hasonlít az osztályokhoz:
//akárhány metódust írhatunk bele
//.java kiterjesztésű
//az interfész neve meg kell egyezzen a file nevével
//Amiben eltér az osztályoktól:
//nem példányosítható
//nem tartalmaz konstruktort
//minden metódus absztrakt
//implements kulcsszó használatával használhatóak más osztályokban
//nem használható az implements kulcsszó interfészben
//akárhány másik interfész lehet a szülő interfésze az extends kulcsszó használatával
//nem használhatóak a private/protected kulcsszavak
public interface Interfesz
{
    //static és final kulcsszavak elhagyhatóak, mert redundánsak
    static final int FEJER_MEGYE_IRANYITOSZAM = 8000;

    //public és abstract kulcsszavak elhagyhatóak, mert redundánsak
    public abstract void szamol();

    default void hello()
    {
        System.out.println("Szia. Irányítószám: " + FEJER_MEGYE_IRANYITOSZAM);
    }

    default void szamolMeghivasa()
    {
        szamol();
    }
}
