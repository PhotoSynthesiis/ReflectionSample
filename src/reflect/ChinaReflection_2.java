package reflect;

import domain.ChinaImp;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ChinaReflection_2 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class ci = null;
        try {
            ci = Class.forName("domain.ChinaImp");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Field[] fields = ci.getFields();
        Field[] declaredFields = ci.getDeclaredFields();
        Method methods[] = ci.getMethods();
        Class<?>[] para = null;
        for (int i = 0; i < fields.length; i++) {
            System.out.println("all fields -- > " + fields[i].getName());
        }

        System.out.println("****************************************");
        for (int i = 0; i < declaredFields.length; i++) {
            System.out.println("declared fields -- > " + declaredFields[i].getName());
        }

        System.out.println("****************************************");
        for (int i = 0; i < methods.length; i++) {
            System.out.println("method name  -- > " + methods[i].getName());
            para = methods[i].getParameterTypes();
            for (int j = 0; j < para.length; j++) {
                System.out.println("paramater -- > " + para[j].getName());
            }
            int modifier = methods[i].getModifiers();
            System.out.println("Modifiers -- > " + Modifier.toString(modifier));

            Class<?> returnType = methods[i].getReturnType();
            System.out.println("return type -- > " + returnType.getName());

            System.out.println(" --------------------------------------- ");
        }

        System.out.println("invoke method");
        Method invokeMethods = ci.getMethod("sayChina");
        invokeMethods.invoke(ci.newInstance());

        invokeMethods = ci.getMethod("sayHello", String.class, int.class);
        invokeMethods.invoke(ci.newInstance(), "David Beckham", 37); //函数调用会隐含地把调用该函数的对象传到函数的第一个函数，
        //所以此处需要把该函数的对象传到invoke中去
        System.out.println("invoke setter and getter");

        ChinaImp obj = (ChinaImp) ci.newInstance();
        setter(ci, "Name", obj);
        getter(ci, "Name", obj);
    }

    private static void setter(Class ci, String name, ChinaImp chinaImp) throws InstantiationException {
        Method method = null;
        try {
            method = ci.getMethod("set" + name, String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("call setter method");
            method.invoke(chinaImp, "Robin Van Persie");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void getter(Class clazz, String attr, ChinaImp chinaImp) {
        Method method = null;
        try {
            method = clazz.getMethod("get" + attr);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("getter value : " + method.invoke(chinaImp));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
