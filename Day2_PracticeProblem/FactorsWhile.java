import java.util.Scanner;

public class FactorsWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive number: ");
        int number = sc.nextInt();

        if (number > 0) {
            int counter = 1;
            System.out.println("Factors of " + number + ":");
            while (counter <= number) {
                if (number % counter == 0)
                    System.out.print(counter + " ");
                counter++;
            }
        } else {
            System.out.println("Enter a positive number only.");
        }
    }
}
