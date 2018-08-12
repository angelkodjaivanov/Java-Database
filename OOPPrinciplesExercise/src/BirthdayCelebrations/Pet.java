package BirthdayCelebrations;

public class Pet implements birthdayYear{
    private String name;

    private String date;

    public Pet(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
