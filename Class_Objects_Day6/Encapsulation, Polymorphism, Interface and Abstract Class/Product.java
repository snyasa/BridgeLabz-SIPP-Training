// Interface for Taxable items
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Abstract Product class
abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Encapsulation: Getters and Setters
    public int getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    // Abstract method
    public abstract double calculateDiscount();

    // Method to display details
    public void displayProduct() {
        System.out.println("Product ID: " + productId + ", Name: " + name + ", Price: " + price);
    }
}

// Electronics class
class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }

    public double calculateTax() {
        return getPrice() * 0.18; // 18% GST
    }

    public String getTaxDetails() {
        return "18% GST on Electronics";
    }
}

// Clothing class
class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.20; // 20% discount
    }

    public double calculateTax() {
        return getPrice() * 0.05; // 5% GST
    }

    public String getTaxDetails() {
        return "5% GST on Clothing";
    }
}

// Groceries class (not taxable)
class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }
}
public class ECommercePlatform {
    // Method to calculate and display final price
    public static void showFinalPrice(Product[] products) {
        for (Product p : products) {
            p.displayProduct();
            double discount = p.calculateDiscount();
            double tax = 0;
            
            if (p instanceof Taxable) {
                tax = ((Taxable) p).calculateTax();
                System.out.println("Tax: " + tax + " (" + ((Taxable) p).getTaxDetails() + ")");
            } else {
                System.out.println("Tax: 0 (No tax on this product)");
            }

            System.out.println("Discount: " + discount);
            double finalPrice = p.getPrice() + tax - discount;
            System.out.println("Final Price: " + finalPrice);
            System.out.println("--------------------------------");
        }
    }

    public static void main(String[] args) {
        Product p1 = new Electronics(101, "Smartphone", 20000);
        Product p2 = new Clothing(102, "T-Shirt", 1000);
        Product p3 = new Groceries(103, "Rice", 500);

        Product[] productList = { p1, p2, p3 };

        showFinalPrice(productList);
    }
}
