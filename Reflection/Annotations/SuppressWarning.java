import java.util.ArrayList;
import java.util.Scanner;

public class SuppressWarning {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        ArrayList list = new ArrayList();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            String input = sc.nextLine();
            list.add(input); // user inputs are added
        }

        System.out.println("\nList elements: " + list);
    }
}
