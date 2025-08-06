import java.util.Scanner;

public class NestedTryCatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample array
        int[] arr = {10, 20, 30, 40, 50};

        try {
            // Outer try block: for array access
            System.out.print("Enter the index to access: ");
            int index = scanner.nextInt();

            try {
                // Inner try block: for division
                System.out.print("Enter the divisor: ");
                int divisor = scanner.nextInt();

                int result = arr[index] / divisor;
                System.out.println("Result: " + result);

            } catch (ArithmeticException e) {
                // Handles division by zero
                System.out.println("Cannot divide by zero!");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            // Handles invalid index
            System.out.println("Invalid array index!");
        }

        scanner.close();
    }
}
