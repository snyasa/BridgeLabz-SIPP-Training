import java.util.Scanner;

class Product {
    // Static variable shared by all products
    static double discount = 10.0; // percentage

    // Final variable: cannot be changed once set
    final int productID;

    // Instance variables
    String productName;
    double price;
    int quantity;

    // Constructor using 'this'
    Product(String productName, double price, int quantity, int productID) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productID = productID;
    }

    // Static method to update discount
    static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    // Method to calculate total price after discount
    double getTotalPrice() {
        double total = price * quantity;
        return total - (total * discount / 100);
    }

    // Method to display product details
    void displayDetails() {
        System.out.println("Product ID: " + productID);
        System.out.println("Product Name: " + productName);
        System.out.println("Price: ₹" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Total after discount: ₹" + getTotalPrice());
        System.out.println("------------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // First product input
        System.out.print("Enter product name: ");
        String name1 = sc.nextLine();

        System.out.print("Enter price: ");
        double price1 = sc.nextDouble();

        System.out.print("Enter quantity: ");
        int qty1 = sc.nextInt();

        System.out.print("Enter product ID: ");
        int id1 = sc.nextInt();
        sc.nextLine(); // consume newline

        Product p1 = new Product(name1, price1, qty1, id1);

        // Second product input
        System.out.print("Enter second product name: ");
        String name2 = sc.nextLine();

        System.out.print("Enter price: ");
        double price2 = sc.nextDouble();

        System.out.print("Enter quantity: ");
        int qty2 = sc.nextInt();

        System.out.print("Enter product ID: ");
        int id2 = sc.nextInt();

        Product p2 = new Product(name2, price2, qty2, id2);

        // Optional: Update discount for all products
        System.out.print("Enter new discount percentage: ");
        double newDiscount = sc.nextDouble();
        Product.updateDiscount(newDiscount);

        // Display product details (no instanceof check)
        p1.displayDetails();
        p2.displayDetails();

        sc.close();
    }
}
