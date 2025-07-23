import java.util.*;

//  Abstract class
abstract class WarehouseItem {
    private String name;
    private double price;

    public WarehouseItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }

    public double getPrice() { return price; }

    public abstract String getCategory();

    @Override
    public String toString() {
        return getCategory() + ": " + name + " - ₹" + price;
    }
}

//  Subclasses
class Electronics extends WarehouseItem {
    public Electronics(String name, double price) {
        super(name, price);
    }

    @Override
    public String getCategory() {
        return "Electronics";
    }
}

class Groceries extends WarehouseItem {
    public Groceries(String name, double price) {
        super(name, price);
    }

    @Override
    public String getCategory() {
        return "Groceries";
    }
}

class Furniture extends WarehouseItem {
    public Furniture(String name, double price) {
        super(name, price);
    }

    @Override
    public String getCategory() {
        return "Furniture";
    }
}

// Generic Storage class
class Storage<T extends WarehouseItem> {
    private List<T> items;

    public Storage() {
        items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }
}

//  Utility class with wildcard method
class WarehouseUtil {
    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }
}

//  Main class to test the system
public class WarehouseSystem {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Smartphone", 30000));
        electronicsStorage.addItem(new Electronics("Laptop", 75000));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Rice", 60));
        groceriesStorage.addItem(new Groceries("Wheat", 45));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair", 1200));
        furnitureStorage.addItem(new Furniture("Table", 3000));

        System.out.println("=== Electronics ===");
        WarehouseUtil.displayItems(electronicsStorage.getItems());

        System.out.println("\n=== Groceries ===");
        WarehouseUtil.displayItems(groceriesStorage.getItems());

        System.out.println("\n=== Furniture ===");
        WarehouseUtil.displayItems(furnitureStorage.getItems());
    }
}
