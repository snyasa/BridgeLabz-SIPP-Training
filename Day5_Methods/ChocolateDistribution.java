import java.util.Scanner;

public class ChocolateDistribution {
    public static int[] findRemainderAndQuotient(int total, int children) {
        return new int[]{total / children, total % children};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter total chocolates and number of children: ");
        int chocolates = sc.nextInt(), children = sc.nextInt();
        int[] result = findRemainderAndQuotient(chocolates, children);
        System.out.println("Each child gets: " + result[0] + " chocolates");
        System.out.println("Remaining chocolates: " + result[1]);
    }
}
