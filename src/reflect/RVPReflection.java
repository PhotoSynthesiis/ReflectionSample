package reflect;

import domain.RVP;

import java.lang.reflect.Field;

public class RVPReflection {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class<?> cl = Class.forName("domain.RVP");
        Field field = cl.getDeclaredField("name");
        RVP rvp = (RVP) cl.newInstance();
         rvp.name = "test name";
//        field.setAccessible(true);
//        field.set(rvp, "Van Persie");
        System.out.println(field.get(rvp));
    }
}
