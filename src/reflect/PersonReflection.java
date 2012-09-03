package reflect;

import domain.Person;

public class PersonReflection {
    public static void main(String[] args) {
        Class person1 = null;
        try {
            person1 = Class.forName("domain.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Person person2 = null;
        try {
            person2 = (Person) person1.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        person2.setName("David Beckham");
        person2.setAge(37);

        System.out.println(person2);
    }
}
