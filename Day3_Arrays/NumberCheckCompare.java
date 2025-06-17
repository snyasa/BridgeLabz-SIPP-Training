import java.util.Scanner;

public class NumberCheckCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }

        for (int num : numbers) {
            if (num > 0) {
                if (num % 2 == 0) System.out.println(num + " is Positive Even");
                else System.out.println(num + " is Positive Odd");
            } else if (num < 0) {
                System.out.println(num + " is Negative");
            } else {
                System.out.println(num + " is Zero");
            }
        }

        if (numbers[0] == numbers[4]) {
            System.out.println("First and last numbers are equal.");
        } else if (numbers[0] > numbers[4]) {
            System.out.println("First number is greater than last.");
        } else {
            System.out.println("First number is less than last.");
        }
    }
}
