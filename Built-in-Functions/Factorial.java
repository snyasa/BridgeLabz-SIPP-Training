import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        int number = getInput();
        long fact = factorial(number);
        displayResult(number, fact);
    }

    public static int getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to find factorial: ");
        return scanner.nextInt();
    }

    public static long factorial(int n) {
        if (n <= 1)
            return 1;
        return n * factorial(n - 1);
    }

    public static void displayResult(int n, long result) {
        System.out.println("Factorial of " + n + " is: " + result);
    }
}
