package reflect;

import domain.Fruit;

public class FruitReflection {
    public void printer(String classPath) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> fruit = Class.forName(classPath);
        Fruit ck = (Fruit) fruit.newInstance();
        ck.eat();
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        new FruitReflection().printer("domain.Banana");
        new FruitReflection().printer("domain.Apple");
    }
}
