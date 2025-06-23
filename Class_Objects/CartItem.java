class CartItem {
    String itemName;
    double price;
    int quantity;

    void addItem(String name, double itemPrice, int qty) {
        itemName = name;
        price = itemPrice;
        quantity = qty;
    }

    void removeItem() {
        itemName = "";
        price = 0;
        quantity = 0;
        System.out.println("Item removed from cart.");
    }

    double totalCost() {
        return price * quantity;
    }

    void displayCart() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total: " + totalCost());
    }

    public static void main(String[] args) {
        CartItem cart = new CartItem();
        cart.addItem("Laptop", 50000, 1);
        cart.displayCart();
        cart.removeItem();
        cart.displayCart();
    }
}
