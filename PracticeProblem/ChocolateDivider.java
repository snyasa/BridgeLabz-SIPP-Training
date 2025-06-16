import java.util.Scanner;

public class ChocolateDivider {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the total number of chocolates (N): ");
        int chocolates = input.nextInt();
        System.out.print("Enter the number of children (M): ");
        int children = input.nextInt();
        if (children == 0) {
            System.out.println("Cannot divide chocolates among 0 children!");
        } else {
            int eachChildGets = chocolates / children;
            int remaining = chocolates % children;
            System.out.println("Each child gets: " + eachChildGets + " chocolates");
            System.out.println("Remaining chocolates: " + remaining);
        }
    }
}
