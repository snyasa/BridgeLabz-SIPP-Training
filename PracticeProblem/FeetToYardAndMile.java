
import java.util.Scanner;

public class FeetToYardAndMile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter distance in feet: ");
        double feet = input.nextDouble();

        double yards = feet / 3;
        double miles = feet / 5280;

        System.out.println("Distance in yards: " + yards);
        System.out.println("Distance in miles: " + miles);

        input.close();
    }
}