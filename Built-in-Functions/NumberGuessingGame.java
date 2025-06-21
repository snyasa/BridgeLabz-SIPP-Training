import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int low = 1, high = 100;
        boolean correct = false;

        System.out.println("Think of a number between 1 and 100. I will try to guess it!");

        while (!correct && low <= high) {
            int guess = generateGuess(low, high);
            System.out.println("Is your number " + guess + "? (Enter: 'low', 'high', or 'correct')");
            String feedback = scanner.nextLine().toLowerCase();

            switch (feedback) {
                case "low":
                    low = guess + 1;
                    break;
                case "high":
                    high = guess - 1;
                    break;
                case "correct":
                    System.out.println("Yay! I guessed your number.");
                    correct = true;
                    break;
                default:
                    System.out.println("Invalid input. Please enter 'low', 'high', or 'correct'.");
            }
        }

        if (!correct) {
            System.out.println("Hmm... it seems there was a mistake in the feedback.");
        }

        scanner.close();
    }

    public static int generateGuess(int low, int high) {
        return (low + high) / 2;  
    }
}
