import java.util.Scanner;

public class AthleteRunCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter side 1 of the triangle (in meters): ");
        double side1 = input.nextDouble();

        System.out.print("Enter side 2 of the triangle (in meters): ");
        double side2 = input.nextDouble();

        System.out.print("Enter side 3 of the triangle (in meters): ");
        double side3 = input.nextDouble();
        double perimeter = side1 + side2 + side3;
        double totalDistance = 5000.0;
        double rounds = totalDistance / perimeter;
        System.out.println("The athlete must complete " + Math.ceil(rounds) + " rounds to run 5 km.");
    }
}