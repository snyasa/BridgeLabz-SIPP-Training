import java.util.Scanner;

// Step 1: Create custom exception by extending Exception
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class AgeValidator {
    
    // Step 2: Method to validate age
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or above");
        } else {
            System.out.println("Access granted!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Step 3: Take user input
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();

            // Step 4: Validate age
            validateAge(age);

        } catch (InvalidAgeException e) {
            // Step 5: Handle custom exception
            System.out.println(e.getMessage());

        } catch (Exception e) {
            // Optional: catch any other exceptions
            System.out.println("An error occurred: " + e.getMessage());

        } finally {
            scanner.close(); // Always close Scanner
        }
    }
}
