package reflect;

import domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class PersonReflection_2 {
    public static void main(String args[]) {
        Class per = null;
        try {
            per = Class.forName("domain.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Constructor<?> cons[] = per.getConstructors();

        Person person1 = null;
        Person person2 = null;
        Person person3 = null;
        Person person4 = null;
        try {
            person1 = (Person) cons[0].newInstance();
            person2 = (Person) cons[3].newInstance(37);
            person3 = (Person) cons[2].newInstance("David Beckham");
            person4 = (Person) cons[1].newInstance("David Beckham", 37);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);
        System.out.println(person4);
    }
}
