package Animals;

public class Animal implements Cat, Dog {

    public String name;
    public Integer age;

    @Override
    public void miau() {
        System.out.println("miau");
    }

    @Override
    public void djaf() {
        System.out.println("djaf");
    }
}
