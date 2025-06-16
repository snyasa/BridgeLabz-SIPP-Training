import java.util.Scanner;

public class HeightConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your height in centimeters: ");
        double cm = input.nextDouble();
         double totalInches = cm / 2.54;
        int feet = (int)(totalInches / 12);
        int inches = (int)(totalInches % 12);
        System.out.println("Your height is " + feet + " feet and " + inches + " inches.");
    }
}
