interface Discountable {
    void applyDiscount(double percentage);
    String getDiscountDetails();
}
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Encapsulation - Getters
    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    // Concrete Method
    public void getItemDetails() {
        System.out.println("Item: " + itemName + ", Price: ₹" + price + ", Quantity: " + quantity);
    }

    // Abstract Method
    public abstract double calculateTotalPrice();
}
class VegItem extends FoodItem implements Discountable {
    private double discount = 0;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    public double calculateTotalPrice() {
        double total = getPrice() * getQuantity();
        return total - (total * discount / 100);
    }

    public void applyDiscount(double percentage) {
        discount = percentage;
    }

    public String getDiscountDetails() {
        return "Veg Discount: " + discount + "%";
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private double extraCharge = 20.0; // Flat extra charge per item
    private double discount = 0;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    public double calculateTotalPrice() {
        double base = (getPrice() + extraCharge) * getQuantity();
        return base - (base * discount / 100);
    }

    public void applyDiscount(double percentage) {
        discount = percentage;
    }

    public String getDiscountDetails() {
        return "Non-Veg Discount: " + discount + "% (Extra ₹" + extraCharge + "/item added)";
    }
}
public class FoodDeliverySystem {
    public static void processOrder(FoodItem[] order) {
        for (FoodItem item : order) {
            item.getItemDetails();
            System.out.println("Total Price: ₹" + item.calculateTotalPrice());

            if (item instanceof Discountable) {
                Discountable d = (Discountable) item;
                System.out.println(d.getDiscountDetails());
            }
        }
    }

    public static void main(String[] args) {
        FoodItem f1 = new VegItem("Paneer Tikka", 150, 2);
        FoodItem f2 = new NonVegItem("Chicken Biryani", 200, 1);

        ((Discountable) f1).applyDiscount(10); // 10% discount on veg
        ((Discountable) f2).applyDiscount(5);  // 5% discount on non-veg

        FoodItem[] order = { f1, f2 };

        processOrder(order); // Polymorphism in action
    }
}
