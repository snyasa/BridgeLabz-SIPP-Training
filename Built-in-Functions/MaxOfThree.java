import java.util.Scanner;

public class MaxOfThree {

    public static void main(String[] args) {
        int num1 = Input("Enter first number: ");
        int num2 = Input("Enter second number: ");
        int num3 = Input("Enter third number: ");

        int max = findMax(num1, num2, num3);
        System.out.println("Maximum of the three numbers is: " + max);
    }

    public static int Input(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.nextInt();
    }

    public static int findMax(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
