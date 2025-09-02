import java.util.function.Function;
import java.util.Scanner;

public class StringLengthChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask user for character limit
        System.out.print("Enter maximum character limit: ");
        int limit = sc.nextInt();
        sc.nextLine(); // consume leftover newline

        // Ask user for the message
        System.out.print("Enter your message: ");
        String message = sc.nextLine();

        // Function to calculate string length
        Function<String, Integer> lengthFunction = str -> str.length();

        // Check the length
        int length = lengthFunction.apply(message);

        if (length > limit) {
            System.out.println("Warning! Message exceeds character limit.");
        } else {
            System.out.println("Message is within the limit.");
        }

        sc.close();
    }
}
