package hu.java.tutorial.alapok;

//Java az egy objektum-orientált programozási nyelv ugye
//Ez azt jelenti, hogy minden objectum közvetlenül/közvetve egy közös Object nevű ősosztályból származik
//És ennek az Object osztálynak vannak metódusai, amikkel minden objectum rendelkezik, és ezeket felül tudjuk definiálni (pl.:toString(), equals(), hashCode())
public class ObjectOsosztaly
{
    private static class Test1
    {
        private String nev;
        private int kor;

        public Test1(String nev, int kor)
        {
            this.nev = nev;
            this.kor = kor;
        }

        //equals() metódus
        //az equals() metódust arra használjuk, hogy két azonos típusú objectumról eldöntsük, hogy azok megegyeznek-e
        //Vegyünk egy példát:
        //Test1 teszt1 = new Test1("hello", 3);
        //Test1 teszt2 = new Test1("hello", 3);
        //boolean egyenlo = teszt1.equals(teszt2)
        //itt ugye azt várnánk, hogy az eredmény true lesz, pedig nem
        //Ha nem definiáljuk felül az equals() metódust, akkor a java alapból az objectum azonosítókat fogja összehasonlítani, tehát, hogy a 2 objectum ugyanaz-e
        //Nyilván itt nem ugyanaz a 2 objectum, mert 2 különböző példányról beszélünk
        //Teszt1 teszt3 = teszt2;
        //egyenlo = teszt2.equals(teszt3) -> ezek már egyenlőek lesznek

        @Override
        public boolean equals(Object o)
        {
            //első körben megnézzük, hogy a 2 objectum megegyezik e
            if (o == this)
            {
                return true;
            }
            //itt azt vizsgáljuk, hogy a 2 objectum típusa megegyezik e
            if (!(o instanceof Test1))
            {
                return false;
            }
            //mivel itt már megegyeznek a típusok, ezért castolunk
            Test1 other = (Test1) o;
            //itt pedig megmondjuk, hogy mikor egyenlő a 2 objectum
            return this.nev.equals(other.nev) && this.kor == other.kor;
        }

        //ha felül definiáljuk az equals()-t, akkor felül kell definiálnunk a hashCode() metódust is
        //a hashCode minden objectumra külön hash értékkel fog visszatérni, még akkor is, ha ezeknek a változó értékei megegyeznek
        //Erre pedig azért van szükség, mert pl ha HashMap-et használunk, akkor is jó értéket kapjunk vissza
        //Példa:
        //Map<Team,Integer> leaders = new HashMap<>();
        //leaders.put(new Team("New York", 1), "Anne");
        //leaders.put(new Team("Boston", 2), "Brian");
        //leaders.put(new Team("Boston", 2), "Charlie");
        //
        //Team myTeam = new Team("New York", 1);
        //String myTeamLeader = leaders.get(myTeam);
        //Itt ugye azt várnánk, hogy vissza kapjuk azt, hogy Anne. De nem kapjuk (null-t fogunk kapni)
        //Ha az osztály egy pédlányát akarjuk kulcsként használni, akkor felül kell írnunk a hashCode() metódust, és ekkor ugyanaz a hashCode() fog visszajönni nekünk.
        @Override
        public int hashCode()
        {
            int result = 17;
            if (nev != null)
            {
                result = 31 * result + nev.hashCode();
            }
            result = 31 * result + kor;
            return result;
        }

        //felüldefiniálás után már a megfelelő Anne értéket fogjuk visszakapni
    }

    private static class Test2
    {
        private String nev;
        private int kor;

        public Test2(String nev, int kor)
        {
            this.nev = nev;
            this.kor = kor;
        }

        //ha egy objectumot ki akarunk íratni String formájában, akkor a toString() metódusra van szükségünk
        //amikor kiíratunk egy objectumot, akkor automatikusan az Object osztály toString() metódusa fog meghívódni
        //Azért írjunk felül a toString() metódust a mi saját osztályunkban, hogy az általunk kívánt String formátumban tudjuk kiíratni az adott objectumot
        @Override
        public String toString()
        {
            final StringBuilder sb = new StringBuilder("Test2{");
            sb.append("nev='").append(nev).append('\'');
            sb.append(", kor=").append(kor);
            sb.append('}');
            return sb.toString();
        }
    }

    public static void main(String[] args)
    {
        Test1 test1 = new Test1("Teszt1", 10);
        Test2 test2 = new Test2("Teszt2", 20);
        System.out.println(test1);
        System.out.println(test2);

        Test1 teszt1 = new Test1("hello", 3);
        Test1 teszt2 = new Test1("hello", 3);
        boolean egyenlo = teszt1.equals(teszt2);
        System.out.println("teszt1 és teszt2 egyenlő? " + egyenlo);
        Test1 teszt3 = teszt2;
        egyenlo = teszt2.equals(teszt3);
        System.out.println("teszt2 és teszt3 egyenlő? " + egyenlo);
        Test1 teszt4 = new Test1("Teszt4", 12);
        System.out.println("teszt4 és teszt1 egyenlő? " + teszt4.equals(test1));
    }
}
