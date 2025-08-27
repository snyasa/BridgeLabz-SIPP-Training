import java.util.Scanner;

class Item {
    // Static variable (shared by all items)
    static String category = "General Item";

    // Final variable (cannot be changed once set)
    final int itemId;

    // Instance variables
    String name;
    double price;

    // Constructor using 'this' to initialize
    Item(String name, double price, int itemId) {
        this.name = name;
        this.price = price;
        this.itemId = itemId;
    }

    // Static method to display category
    static void displayCategory() {
        System.out.println("Category: " + category);
    }

    // Method to display item details
    void displayDetails() {
        System.out.println("Item Name: " + name);
        System.out.println("Price: ₹" + price);
        System.out.println("Item ID: " + itemId);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input for first item
        System.out.print("Enter item name: ");
        String name1 = sc.nextLine();

        System.out.print("Enter item price: ");
        double price1 = sc.nextDouble();

        System.out.print("Enter item ID: ");
        int id1 = sc.nextInt();
        sc.nextLine(); // Consume newline

        // Creating first item
        Item item1 = new Item(name1, price1, id1);

        // Taking input for second item
        System.out.print("Enter second item name: ");
        String name2 = sc.nextLine();

        System.out.print("Enter second item price: ");
        double price2 = sc.nextDouble();

        System.out.print("Enter second item ID: ");
        int id2 = sc.nextInt();

        // Creating second item
        Item item2 = new Item(name2, price2, id2);

        // Display static category
        Item.displayCategory();

        // Using instanceof and displaying details
        if (item1 instanceof Item) {
            item1.displayDetails();
        }

        if (item2 instanceof Item) {
            item2.displayDetails();
        }

        sc.close();
    }
}
