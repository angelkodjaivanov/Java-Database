package Mankind;

public abstract class  Human {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String correctName(){
        if(this.firstName.charAt(0) < 'A' || this.firstName.charAt(0) > 'Z'){
            return "Expected upper case letter!Argument: firstName";
        }

        if(this.firstName.length() < 4){
            return "Expected length at least 4 symbols!Argument: firstName";
        }

        if(this.lastName.charAt(0) < 'A' || this.lastName.charAt(0) > 'Z'){
            return "Expected upper case letter!Argument: lastName";
        }

        if(this.lastName.length() < 3){
            return "Expected length at least 3 symbols!Argument: lastName ";
        }

        return null;
    }
}
