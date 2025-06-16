import java.util.Scanner;

public class SimpleInterestCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Principal amount (INR): ");
        double principal = input.nextDouble(); 
        System.out.print("Enter the Rate of interest (% per annum): ");
        double rate = input.nextDouble();  
        System.out.print("Enter the Time period (in years): ");
        double time = input.nextDouble(); 
        double simpleInterest = (principal * rate * time) / 100;
        System.out.println("Simple Interest is: INR " + simpleInterest);
    }
}