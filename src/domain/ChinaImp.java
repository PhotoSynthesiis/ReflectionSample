package domain;

public class ChinaImp implements China {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ChinaImp() {
    }

    public ChinaImp(String name) {
        this.name = name;
    }

    @Override
    public void sayChina() {
        System.out.println("Say hello China");
    }

    @Override
    public void sayHello(String name, int age) {
        System.out.println(name + " " + age);
    }

    private void sayKKK() {

    }
}
