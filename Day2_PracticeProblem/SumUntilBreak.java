import java.util.Scanner;

public class SumUntilBreak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        while (true) {
            System.out.print("Enter a number: ");
            int number = scanner.nextInt();
            
            if (number <= 0) break;
            
            sum += number;
        }
        System.out.println("Sum = " + sum);
    }
}
