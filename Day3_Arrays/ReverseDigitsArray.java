import java.util.Scanner;

public class ReverseDigitsArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        while (number != 0 && index < maxDigit) {
            digits[index] = number % 10;
            number /= 10;
            index++;
        }
        System.out.print("Reversed number: ");
        for (int i = 0; i < index; i++) {
            System.out.print(digits[i]);
        }
        System.out.println();
    }
}
