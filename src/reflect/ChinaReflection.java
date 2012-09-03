package reflect;

import java.lang.reflect.Constructor;

public class ChinaReflection {
    public static void main(String args[]) {
        Class c = null;
        try {
            c = Class.forName("domain.ChinaImp");  //domain is the package of ChinaImp.java
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Class interfaces[] = c.getInterfaces();
        Class superClass = c.getSuperclass();
        Constructor[] cons = c.getConstructors();
        for (int i = 0; i < interfaces.length; i++) {
            System.out.println("interface -- >" + interfaces[i].getName());
        }
        System.out.println("SuperClass -- >" + superClass.getName());
        for (int i = 0; i < cons.length; i++){
            System.out.println("constructor name -- >" + cons[i]);
        }
    }
}
