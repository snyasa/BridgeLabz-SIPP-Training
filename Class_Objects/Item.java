class Item {
    int itemCode;
    String itemName;
    double price;

    void displayDetails() {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: " + price);
    }

    double totalCost(int quantity) {
        return price * quantity;
    }

    public static void main(String[] args) {
        Item item = new Item();
        item.itemCode = 123;
        item.itemName = "Notebook";
        item.price = 45.5;
        item.displayDetails();
        System.out.println("Total Cost for 3 items: " + item.totalCost(3));
    }
}
