package Mankind;

public class Worker extends Human{
    private double weekSalary;

    private int workHoursPerDay;

    public Worker(String firstName, String lastName, double weekSalary, int workHoursPerDay) {
        super.setFirstName(firstName);
        super.setLastName(lastName);
        this.weekSalary = weekSalary;
        this.workHoursPerDay = workHoursPerDay;
    }

    public double getWeekSalary() {
        return weekSalary;
    }

    public void setWeekSalary(double weekSalary) {
        this.weekSalary = weekSalary;
    }

    public int getWorkHoursPerDay() {
        return workHoursPerDay;
    }

    public void setWorkHoursPerDay(int workHoursPerDay) {
        this.workHoursPerDay = workHoursPerDay;
    }

    public String correctWorkerProp(){

        if(weekSalary < 10){
            return "Expected value mismatch!Argument: weekSalary";
        }

        if(workHoursPerDay < 1 || workHoursPerDay > 12){
            return "Expected value mismatch!Argument: workHoursPerDay";
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
