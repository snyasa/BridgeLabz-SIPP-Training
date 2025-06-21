import java.util.Scanner;

public class QuadraticSolver {
    public static void findRoots(double a, double b, double c) {
        double delta = b * b - 4 * a * c;
        if (delta > 0) {
            double r1 = (-b + Math.sqrt(delta)) / (2 * a);
            double r2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("Two real roots: " + r1 + " and " + r2);
        } else if (delta == 0) {
            double r = -b / (2 * a);
            System.out.println("One real root: " + r);
        } else {
            System.out.println("No real roots");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a, b, c: ");
        findRoots(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
    }
}
