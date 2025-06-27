class Product {
    private String productName;
    private double price;

    public Product(String name, double price) {
        this.productName = name;
        this.price = price;
    }

    public String getName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public void displayProduct() {
        System.out.println(" - " + productName + " @ ₹" + price);
    }
}
import java.util.ArrayList;

class Order {
    private static int orderCounter = 1;
    private int orderId;
    private ArrayList<Product> productList;

    public Order() {
        this.orderId = orderCounter++;
        this.productList = new ArrayList<>();
    }

    public int getOrderId() {
        return orderId;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void displayOrderDetails() {
        System.out.println("Order ID: #" + orderId + " | Products:");
        for (Product p : productList) {
            p.displayProduct();
        }
        System.out.println("Total: ₹" + getTotalAmount());
    }

    public double getTotalAmount() {
        double total = 0;
        for (Product p : productList) {
            total += p.getPrice();
        }
        return total;
    }
}
import java.util.ArrayList;

class Customer {
    private String name;
    private ArrayList<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // Customer places an order
    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println(name + " placed Order #" + order.getOrderId());
    }

    public void viewOrders() {
        System.out.println("Orders for Customer: " + name);
        for (Order order : orders) {
            order.displayOrderDetails();
            System.out.println();
        }
    }
}
