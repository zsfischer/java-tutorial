package hu.java.tutorial.oop;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Annotations and reflection
 */
@CustomAnnotation
public class AnnotationsDemo
{
    @CustomAnnotation(description = "'name' mező")
    public String name = "name value";

    @CustomAnnotation(description = "'hello()' metódus")
    public void hello() {
        System.out.println("Szia!");
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException
    {
        //Osztály szintű annotációk lekérése
        AnnotationsDemo annotationsDemo = new AnnotationsDemo();
        Class<?> clazz = annotationsDemo.getClass();
        if (clazz.isAnnotationPresent(CustomAnnotation.class)) {
            CustomAnnotation customAnnotation = clazz.getAnnotation(CustomAnnotation.class);
            System.out.println(customAnnotation.description());
        }

        Annotation[] annotations = clazz.getAnnotations();
        for(Annotation annotation : annotations) {
            System.out.println(annotation.toString());
        }

        //Metódus szintű annotációk lekérése
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(CustomAnnotation.class)) {
                CustomAnnotation annotation = method.getAnnotation(CustomAnnotation.class);
                System.out.println(annotation.description());
                method.setAccessible(true);
                method.invoke(annotationsDemo); //futtatja a metódust
                System.out.printf("Method name: %s", method.getName());
                System.out.println();
            }

            Annotation[] methodAnnotations = method.getAnnotations();
            for(Annotation annotation : methodAnnotations) {
                System.out.println(annotation.toString());
            }
        }

        //Mező szintű annotációk lekérése
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(CustomAnnotation.class)) {
                CustomAnnotation annotation = field.getAnnotation(CustomAnnotation.class);
                System.out.println(annotation.description());
                System.out.printf("Field name: %s", field.getName());
                System.out.println();
                System.out.printf("Field value: %s", field.get(annotationsDemo));
                System.out.println();
            }

            Annotation[] fieldAnnotations = field.getAnnotations();
            for(Annotation annotation : fieldAnnotations) {
                System.out.println(annotation.toString());
            }
        }


        CustomFunctionalIFace customFunctionalIFace = number -> number * 10;

        System.out.println(customFunctionalIFace.multiply(10));

    }
}
