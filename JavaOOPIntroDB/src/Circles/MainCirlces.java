package Circles;
import org.omg.CORBA.INTERNAL;

import java.util.*;
public class MainCirlces {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Circle c1 = new Circle();
        Circle c2 = new Circle();

        String[] circle1Prop = scanner.nextLine().split(" ");
        String[] circle2Prop = scanner.nextLine().split(" ");

        int[] c1Args = new int[circle1Prop.length];
        int[] c2Args = new int[circle2Prop.length];

        for(int i = 0; i < c1Args.length; i++){
            c1Args[i] = Integer.parseInt(circle1Prop[i]);
        }
        for(int i = 0; i < c2Args.length; i++){
            c2Args[i] = Integer.parseInt(circle2Prop[i]);
        }

        Point p1 = new Point();
        Point p2 = new Point();

        p1.setX(c1Args[0]);
        p1.setY(c1Args[1]);

        c1.setCenter(p1);
        c1.setRadius(c1Args[2]);

        p2.setX(c2Args[0]);
        p2.setY(c2Args[1]);

        c2.setCenter(p2);
        c2.setRadius(c2Args[2]);

        boolean result = intersect(c1, c2);
        if(result){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }

    public static  boolean intersect(Circle c1, Circle c2){
        double distance = Math.sqrt((c1.getCenter().getX()- c2.getCenter().getX()) * (c1.getCenter().getX()- c2.getCenter().getX())
                + (c1.getCenter().getY()- c2.getCenter().getY()) * (c1.getCenter().getY()- c2.getCenter().getY()));
        if(distance <= c1.getRadius() + c2.getRadius()){
            return true;
        }
        return  false;
    }
}
