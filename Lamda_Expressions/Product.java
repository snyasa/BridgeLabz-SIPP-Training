import java.util.*;

class Product {
    String name;
    double price;
    double rating;
    double discount; // in percentage

    Product(String name, double price, double rating, double discount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return String.format("%s | Price: ₹%.2f | Rating: %.1f | Discount: %.0f%%",
                name, price, rating, discount);
    }
}

public class ECommerceSorting {
    public static void main(String[] args) {

        List<Product> products = Arrays.asList(
                new Product("Laptop", 55000, 4.5, 10),
                new Product("Phone", 30000, 4.8, 15),
                new Product("Headphones", 2000, 4.3, 25),
                new Product("Smartwatch", 8000, 4.1, 5)
        );

        // Sorting by Price (Low to High)
        System.out.println("Sort by Price (Low to High):");
        products.sort((p1, p2) -> Double.compare(p1.price, p2.price));
        products.forEach(System.out::println);

        // Sorting by Rating (High to Low)
        System.out.println("\nSort by Rating (High to Low):");
        products.sort((p1, p2) -> Double.compare(p2.rating, p1.rating));
        products.forEach(System.out::println);

        // Sorting by Discount (High to Low)
        System.out.println("\nSort by Discount (High to Low):");
        products.sort((p1, p2) -> Double.compare(p2.discount, p1.discount));
        products.forEach(System.out::println);
    }
}
