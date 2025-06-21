import java.time.LocalDate;
import java.util.Scanner;

public class DateComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter first date (yyyy-MM-dd): ");
        String input1 = scanner.nextLine();
        LocalDate date1 = LocalDate.parse(input1);

        System.out.print("Enter second date (yyyy-MM-dd): ");
        String input2 = scanner.nextLine();
        LocalDate date2 = LocalDate.parse(input2);

        
        if (date1.isBefore(date2)) {
            System.out.println("First date is before the second date.");
        } else if (date1.isAfter(date2)) {
            System.out.println("First date is after the second date.");
        } else if (date1.isEqual(date2)) {
            System.out.println("Both dates are the same.");
        }

        scanner.close();
    }
}
