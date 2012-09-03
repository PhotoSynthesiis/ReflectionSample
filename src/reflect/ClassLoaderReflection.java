package reflect;

import domain.ClassLoader_model;

public class ClassLoaderReflection {
    public static void main(String args[]){
        ClassLoader_model classLoader_model = new ClassLoader_model();
        System.out.println("ClassLoader Name : " + classLoader_model.getClass().getClassLoader().getClass().getName());
    }
}
