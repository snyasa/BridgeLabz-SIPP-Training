import java.util.Scanner;

public class DivisionWithFinally {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Take two integers from the user
            System.out.print("Enter the numerator: ");
            int num1 = scanner.nextInt();

            System.out.print("Enter the denominator: ");
            int num2 = scanner.nextInt();

            // Perform division
            int result = num1 / num2;
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            // Handle divide-by-zero error
            System.out.println("Error: Cannot divide by zero.");

        } finally {
            // Always executed
            System.out.println("Operation completed.");
            scanner.close();
        }
    }
}
