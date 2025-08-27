class Product {
    String productName;
    double price;
    static int totalProducts = 0; // Class variable

    // Constructor
    Product(String name, double price) {
        this.productName = name;
        this.price = price;
        totalProducts++; // Increment every time a product is created
    }

    // Instance method
    void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: ₹" + price);
    }

    // Class method
    static void displayTotalProducts() {
        System.out.println("Total Products: " + totalProducts);
    }
}
