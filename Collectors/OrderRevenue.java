import java.util.*;
import java.util.stream.Collectors;

public class OrderRevenue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String[]> orders = new ArrayList<>();

        System.out.print("Enter number of orders: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter customer name: ");
            String customer = sc.nextLine();

            System.out.print("Enter order amount: ");
            double amount = sc.nextDouble();
            sc.nextLine(); // consume newline

            orders.add(new String[]{customer, String.valueOf(amount)});
        }

        Map<String, Double> revenue =
            orders.stream()
                  .collect(Collectors.groupingBy(
                      o -> o[0], // customer name
                      Collectors.summingDouble(o -> Double.parseDouble(o[1]))
                  ));

         System.out.println("\n--- Revenue Summary ---");
        revenue.forEach((cust, total) ->
            System.out.println(cust + " -> " + total)
        );
    }
}
