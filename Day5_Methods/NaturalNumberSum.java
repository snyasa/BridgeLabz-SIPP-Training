import java.util.Scanner;

public class NaturalNumberSum {
    public static int recursiveSum(int n) {
        if (n == 1) return 1;
        return n + recursiveSum(n - 1);
    }

    public static int formulaSum(int n) {
        return n * (n + 1) / 2;
    }

    public static void compareSums(int n) {
        int sum1 = recursiveSum(n);
        int sum2 = formulaSum(n);
        System.out.println("Recursive Sum: " + sum1);
        System.out.println("Formula Sum: " + sum2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();
        if (n > 0) compareSums(n);
        else System.out.println("Invalid input.");
    }
}
