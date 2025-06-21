import java.util.Scanner;

public class SimpleInterest {
    public static double calculateSimpleInterest(double p, double r, double t) {
        return (p * r * t) / 100;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Principal, Rate, Time: ");
        double p = sc.nextDouble(), r = sc.nextDouble(), t = sc.nextDouble();
        double si = calculateSimpleInterest(p, r, t);
        System.out.println("The Simple Interest is " + si + 
            " for Principal " + p + ", Rate of Interest " + r + ", and Time " + t);
    }
}
