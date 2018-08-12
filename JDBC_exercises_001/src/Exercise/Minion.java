package Exercise;

public class Minion {
    private String name;

    private int age;

    private String townName;

    public Minion(String name, int age, String townName) {
        this.name = name;
        this.age = age;
        this.townName = townName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }
}
