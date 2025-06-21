import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter a date (yyyy-MM-dd): ");
        String input = scanner.nextLine();

         LocalDate date = LocalDate.parse(input);

        LocalDate addedDate = date.plusDays(7).plusMonths(1).plusYears(2);

        LocalDate finalDate = addedDate.minusWeeks(3);

        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println("Original Date: " + date.format(formatter));
        System.out.println("After Adding (7d, 1m, 2y): " + addedDate.format(formatter));
        System.out.println("Final Date after subtracting 3 weeks: " + finalDate.format(formatter));

        scanner.close();
    }
}
