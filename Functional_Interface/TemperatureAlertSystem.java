import java.util.function.Predicate;
import java.util.Scanner;

public class TemperatureAlertSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask user for threshold
        System.out.print("Enter temperature threshold: ");
        double threshold = sc.nextDouble();

        // Predicate to check if temperature crosses threshold
        Predicate<Double> isTooHot = temp -> temp > threshold;

        System.out.println("Enter current temperature: ");
        double currentTemp = sc.nextDouble();

        // Check using Predicate
        if (isTooHot.test(currentTemp)) {
            System.out.println("ALERT! Temperature exceeds threshold!");
        } else {
            System.out.println("Temperature is normal.");
        }

        sc.close();
    }
}
