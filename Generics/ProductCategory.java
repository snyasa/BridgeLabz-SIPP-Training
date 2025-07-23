import java.util.*;

//  Interface for Category
interface ProductCategory {
    String getCategoryName();
}

//  Category Implementations
class BookCategory implements ProductCategory {
    public String getCategoryName() {
        return "Book";
    }
}

class ClothingCategory implements ProductCategory {
    public String getCategoryName() {
        return "Clothing";
    }
}

class GadgetCategory implements ProductCategory {
    public String getCategoryName() {
        return "Gadget";
    }
}

//  Generic Product Class with Bounded Type Parameter
class Product<T extends ProductCategory> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public T getCategory() { return category; }

    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    @Override
    public String toString() {
        return category.getCategoryName() + ": " + name + " - ₹" + price;
    }
}

//  Catalog to hold all products (type-safe)
class Catalog {
    private List<Product<? extends ProductCategory>> products = new ArrayList<>();

    public void addProduct(Product<? extends ProductCategory> product) {
        products.add(product);
    }

    public void showCatalog() {
        for (Product<? extends ProductCategory> product : products) {
            System.out.println(product);
        }
    }
}

//  Utility class with generic method to apply discount
class DiscountUtil {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double oldPrice = product.getPrice();
        double discountAmount = oldPrice * (percentage / 100);
        product.setPrice(oldPrice - discountAmount);
        System.out.println("Applied " + percentage + "% discount to " + product.getName() + ": New Price = ₹" + product.getPrice());
    }
}

//  Main class to test the system
public class MarketplaceSystem {
    public static void main(String[] args) {
        // Creating products
        Product<BookCategory> book1 = new Product<>("Java Programming", 499.0, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("Casual Shirt", 999.0, new ClothingCategory());
        Product<GadgetCategory> mobile = new Product<>("Smartphone", 15999.0, new GadgetCategory());

        // Creating catalog
        Catalog catalog = new Catalog();
        catalog.addProduct(book1);
        catalog.addProduct(shirt);
        catalog.addProduct(mobile);

        System.out.println("=== Product Catalog ===");
        catalog.showCatalog();

        // Apply discounts
        System.out.println("\n=== Applying Discounts ===");
        DiscountUtil.applyDiscount(book1, 10);     // 10% off on book
        DiscountUtil.applyDiscount(shirt, 20);     // 20% off on clothing
        DiscountUtil.applyDiscount(mobile, 15);    // 15% off on gadgets

        System.out.println("\n=== Catalog After Discounts ===");
        catalog.showCatalog();
    }
}
