import java.util.Scanner;

public class LargestTwoDigits {
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
        if (index < 2) {
            System.out.println("Not enough digits to find the second largest.");
            return;
        }
        int largest = -1;
        int secondLargest = -1;

        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }
        System.out.println("Largest digit: " + largest);
        if (secondLargest != -1)
            System.out.println("Second largest digit: " + secondLargest);
        else
            System.out.println("Second largest digit not found.");
    }
}
