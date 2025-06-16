import java.util.Scanner;

public class DiscountCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

               System.out.print("Enter the course fee (INR): ");
        double fee = sc.nextDouble();

                System.out.print("Enter the university discount percentage: ");
        double discountPercent = sc.nextDouble();

                double discount = (discountPercent / 100.0) * fee;

                double finalFee = fee - discount;

              System.out.printf("The discount amount is INR %.2f%n", discount);
        System.out.printf("The final discounted fee is INR %.2f%n", finalFee);

        
    }
}
