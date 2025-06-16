import java.util.Scanner;

public class WeightConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);  
        System.out.print("Enter weight in pounds: ");
        double pounds = input.nextDouble();
        double kilograms = pounds * 0.453592;
        System.out.println("Weight in kilograms: " + kilograms + " kg");
    }
}