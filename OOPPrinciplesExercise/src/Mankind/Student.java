package Mankind;

public class Student extends Human {
    private String facultyNumber;

    public Student(String firstName, String lastName, String facultyNumber) {
        super.setFirstName(firstName);
        super.setLastName(lastName);
        this.facultyNumber = facultyNumber;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(String facultyNumber) {
        this.facultyNumber = facultyNumber;
    }

    public String correctFacultyNumber(){
        if(this.facultyNumber.length() < 5 || this.facultyNumber.length() > 10){
            return "Invalid faculty number!";
        }
        return null;
    }

    @Override
    public String correctName(){
        if(super.getFirstName().charAt(0) < 'A' || super.getFirstName().charAt(0) > 'Z'){
            return "Expected upper case letter!Argument: firstName";
        }

        if(super.getFirstName().length() < 4){
            return "Expected length at least 4 symbols!Argument: firstName";
        }

        if(super.getLastName().charAt(0) < 'A' || super.getLastName().charAt(0) > 'Z'){
            return "Expected upper case letter!Argument: lastName";
        }

        if(super.getLastName().length() < 3){
            return "Expected length at least 3 symbols!Argument: lastName ";
        }

        return null;
    }
}
