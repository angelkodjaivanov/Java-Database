package com.company;

public class Student {

    private String firstname;

    private String secondName;

    private int groupNumber;

    public Student(String firstname, String secondName, int groupNumber) {
        this.firstname = firstname;
        this.secondName = secondName;
        this.groupNumber = groupNumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

}
