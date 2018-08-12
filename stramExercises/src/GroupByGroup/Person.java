package GroupByGroup;

public class Person {
    private String firstname;

    private String lastname;

    private Integer group;

    public Person(String firstname, String lastname, Integer group) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.group = group;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }
}
