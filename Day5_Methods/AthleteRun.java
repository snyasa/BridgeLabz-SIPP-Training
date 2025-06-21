import java.util.Scanner;

public class AthleteRun {
    public static double calculateRounds(int a, int b, int c) {
        int perimeter = a + b + c;
        return 5000.0 / perimeter;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 3 sides of the triangular park: ");
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
        System.out.printf("Rounds needed: %.2f\n", calculateRounds(a, b, c));
    }
}
