package com.company;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy");
        String inputStDate = scanner.nextLine();
        String inputEndDate = scanner.nextLine();

        int count = 0;
        Date currentDate = ft.parse(inputStDate);
        Date endDate = ft.parse(inputEndDate);
        while(currentDate.before(endDate) || currentDate.equals(endDate)){
            if(currentDate.getDay() != 6 && currentDate.getDay() != 7){
                count++;
            }
            currentDate = addDays(currentDate, 1);
        }

        System.out.println(count);

    }

    public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }
}
