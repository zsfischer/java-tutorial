package hu.java.tutorial.oop;

//Ez egy sima class
public class SpecialisOsztalyok
{
    private int a = 10;
    private static int staticVariable = 20;

    //Ez egy sima inner class
    //inner-class lehet private/protected is
    public class InnerClass {
        public void sayA() {
            System.out.println(a);
        }
    }

    //Ez egy static inner class
    public static class StaticInnerClass
    {
        //'a' változó nem használható itt, mert nem static
        public void sayStaticVariable() {
            System.out.println(staticVariable);
        }
    }

    public static void main(String[] args)
    {
        //inner class
        InnerClass innerClass = new SpecialisOsztalyok().new InnerClass();
        innerClass.sayA();

        //static inner class
        StaticInnerClass staticInnerClass = new SpecialisOsztalyok.StaticInnerClass();
        staticInnerClass.sayStaticVariable();

        //Anonymous class
        //Mert nincs létrehozva egy külön osztály, ami implementálná ezt az interfacet, ezért nevezzük ezt anonymous osztálynak
        CustomFunctionalIFace doubleValue = new CustomFunctionalIFace()
        {
            @Override
            public int multiply(int number)
            {
                return number * 2;
            }
        };

        int a = 10;
        System.out.printf("%d duplája: %d", a, doubleValue.multiply(a));
        System.out.println();

        //Lambda kifejezés
        CustomFunctionalIFace tripleValue = number -> number * 3;
        System.out.printf("%d triplája: %d", a, tripleValue.multiply(a));
    }
}
