package hu.java.tutorial.oop;

/**
 * Polymorphism in Java is the ability of an object to take many forms.
 */
public class Polymorph
{
    static class Animal {
        public void animalSound() {
            System.out.println("The animal makes a sound");
        }
    }

    static class Pig extends Animal {
        public void animalSound() {
            System.out.println("The pig says: wee wee");
        }
    }

    static class Dog extends Animal {
        public void animalSound() {
            System.out.println("The dog says: wau wau");
        }
    }

    public static void main(String[] args)
    {
        Animal myAnimal = new Animal();  // Create a Animal object

        //Animal is the static type (known in compile time)
        //Pig is the dynamic type (known in runtime)
        Animal myPig = new Pig();  // Create a Pig object
        Animal myDog = new Dog();  // Create a Dog object
        myAnimal.animalSound();
        myPig.animalSound();
        myDog.animalSound();
    }
}
