import java.util.Scanner;
import java.util.InputMismatchException;

public class DivisionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Ask for numerator
            System.out.print("Enter the numerator: ");
            int numerator = scanner.nextInt();

            // Ask for denominator
            System.out.print("Enter the denominator: ");
            int denominator = scanner.nextInt();

            // Perform division
            int result = numerator / denominator;
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            // Handle division by zero
            System.out.println("Cannot divide by zero.");

        } catch (InputMismatchException e) {
            // Handle non-numeric input
            System.out.println("Invalid input. Please enter numeric values only.");

        } finally {
            scanner.close(); // Always close the scanner
        }
    }
}
