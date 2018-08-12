package BirthdayCelebrations;

public class Citizen implements birthdayYear{
    private String name;

    private Integer age;

    private String id;

    private String date;

    public Citizen(String name, Integer age, String id, String date) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean isInTheYear(String year) {
        if(this.date.endsWith(year)){
            return true;
        }
        else{
            return false;
        }
    }
}
