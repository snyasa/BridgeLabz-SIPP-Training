
import java.util.Scanner;

public class TriangleAreaConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter base of the triangle in cm: ");
        double base = input.nextDouble();
        System.out.print("Enter height of the triangle in cm: ");
        double height = input.nextDouble();
        double areaCm = 0.5 * base * height;
        double areaInch = areaCm / (2.54 * 2.54);
        System.out.println("Area of the triangle:");
        System.out.println("In square centimeters: " + areaCm + " cm²");
        System.out.println("In square inches: " + areaInch + " in²");

    }
}