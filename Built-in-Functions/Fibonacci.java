import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        int terms = getInput();
        Fibonacci(terms);
    }

    public static int getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of terms for Fibonacci sequence: ");
        return scanner.nextInt();
    }

    public static void Fibonacci(int n) {
        int a = 0, b = 1;
        System.out.print("Fibonacci Sequence: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
    }
}
