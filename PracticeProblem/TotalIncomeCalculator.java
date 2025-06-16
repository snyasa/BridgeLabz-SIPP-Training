import java.util.Scanner;

public class TotalIncomeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);   
        System.out.print("Enter your salary: ");
        double salary = input.nextDouble(); 
        System.out.print("Enter your bonus: ");
        double bonus = input.nextDouble();
        double totalIncome = salary + bonus;
        System.out.println("Your total income is: INR " + totalIncome);
    }
}