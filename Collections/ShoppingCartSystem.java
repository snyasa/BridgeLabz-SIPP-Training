import java.util.*;

public class ShoppingCartSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Product price list
        HashMap<String, Double> productPrices = new HashMap<>();
        productPrices.put("Apple", 40.0);
        productPrices.put("Banana", 10.0);
        productPrices.put("Milk", 50.0);
        productPrices.put("Bread", 30.0);
        productPrices.put("Eggs", 60.0);

        // Shopping cart with insertion order
        LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();

        System.out.print("Enter number of items to add to cart: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter product name: ");
            String item = sc.nextLine();

            if (productPrices.containsKey(item)) {
                cart.put(item, cart.getOrDefault(item, 0) + 1);
            } else {
                System.out.println("Product not found");
            }
        }

        System.out.println("\nCart (Insertion Order):");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " x" + entry.getValue());
        }

        TreeMap<Double, List<String>> sortedByPrice = new TreeMap<>();
        for (String item : cart.keySet()) {
            double price = productPrices.get(item);
            sortedByPrice.putIfAbsent(price, new ArrayList<>());
            sortedByPrice.get(price).add(item);
        }

        System.out.println("\nItems Sorted by Price:");
        for (Map.Entry<Double, List<String>> entry : sortedByPrice.entrySet()) {
            for (String item : entry.getValue()) {
                int quantity = cart.get(item);
                System.out.println(item + " @ ₹" + entry.getKey() + " x" + quantity);
            }
        }

        double total = 0;
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            total += entry.getValue() * productPrices.get(entry.getKey());
        }

        System.out.println("\nTotal Amount: ₹" + total);
    }
}
