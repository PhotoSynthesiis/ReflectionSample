package reflect;

import domain.Demo;

public class DemoReflection {
    public static void main(String[] args) {
        Demo demo = new Demo();
        System.out.println("sample 1 -- > " + demo.getClass().getName());

        Class demo1 = null;
        Class demo2 = null;
        Class demo3 = null;
        try {
            demo1 = Class.forName("domain.Demo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("sample 2 -- > " + demo1.getName());
        demo2 = new Demo().getClass();
        System.out.println("sample 2 -- > " + demo2.getName());
        demo3 = Demo.class;
        System.out.println("sample 2 -- > " + demo3.getName());
    }
}
