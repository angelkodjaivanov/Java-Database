package Multiple_Implementation;

public class Citizen implements Birthable, Person, Identifiable {

    private String id;

    private String name;

    private Integer age;

    private String birthDate;

    public Citizen(String name, Integer age, String id,  String birthDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
    }

    @Override
    public String getBirthDate() {
        return this.birthDate;
    }


    public void setBirthDate() {

    }

    @Override
    public String getId() {
        return this.id;
    }

    public void setId() {

    }

    @Override
    public String getName() {
        return this.name;
    }


    public void setName() {

    }

    @Override
    public Integer getAge() {
        return this.age;
    }

    public void setAge() {

    }
}
