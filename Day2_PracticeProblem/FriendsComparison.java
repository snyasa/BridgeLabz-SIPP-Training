import java.util.Scanner;

public class FriendsComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Amar's age and height: ");
        int amarAge = scanner.nextInt();
        int amarHeight = scanner.nextInt();

        System.out.print("Enter Akbar's age and height: ");
        int akbarAge = scanner.nextInt();
        int akbarHeight = scanner.nextInt();

        System.out.print("Enter Anthony's age and height: ");
        int anthonyAge = scanner.nextInt();
        int anthonyHeight = scanner.nextInt();

        String youngest = (amarAge < akbarAge && amarAge < anthonyAge) ? "Amar" :
                          (akbarAge < anthonyAge) ? "Akbar" : "Anthony";
        String tallest = (amarHeight > akbarHeight && amarHeight > anthonyHeight) ? "Amar" :
                         (akbarHeight > anthonyHeight) ? "Akbar" : "Anthony";

        System.out.println("Youngest friend: " + youngest);
        System.out.println("Tallest friend: " + tallest);
    }
}
