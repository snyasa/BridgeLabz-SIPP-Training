import java.util.Scanner;

class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;

    public Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

public class InventoryManagement {
    private Item head = null;

    // Add at beginning
    public void addAtBeginning(String name, int id, int qty, double price) {
        Item newItem = new Item(name, id, qty, price);
        newItem.next = head;
        head = newItem;
    }

    // Add at end
    public void addAtEnd(String name, int id, int qty, double price) {
        Item newItem = new Item(name, id, qty, price);
        if (head == null) {
            head = newItem;
        } else {
            Item temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newItem;
        }
    }

    // Add at position (1-based)
    public void addAtPosition(int pos, String name, int id, int qty, double price) {
        if (pos <= 0) {
            System.out.println("Invalid position!");
            return;
        }

        if (pos == 1) {
            addAtBeginning(name, id, qty, price);
            return;
        }

        Item newItem = new Item(name, id, qty, price);
        Item temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Position out of bounds.");
            return;
        }

        newItem.next = temp.next;
        temp.next = newItem;
    }

    // Remove item by ID
    public void removeById(int id) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        if (head.itemId == id) {
            head = head.next;
            System.out.println("Item removed.");
            return;
        }

        Item current = head;
        while (current.next != null && current.next.itemId != id)
            current = current.next;

        if (current.next == null)
            System.out.println("Item not found.");
        else {
            current.next = current.next.next;
            System.out.println("Item removed.");
        }
    }

    // Update quantity by ID
    public void updateQuantity(int id, int newQty) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                System.out.println("Quantity updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    // Search by ID or name
    public void searchByIdOrName(String keyword) {
        boolean found = false;
        Item temp = head;
        while (temp != null) {
            if (String.valueOf(temp.itemId).equals(keyword) || temp.itemName.equalsIgnoreCase(keyword)) {
                displayItem(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found)
            System.out.println("Item not found.");
    }

    // Calculate total value
    public void calculateTotalValue() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.printf("Total Inventory Value: ₹%.2f%n", total);
    }

    // Display all items
    public void displayAll() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        System.out.println("\nInventory List:");
        Item temp = head;
        while (temp != null) {
            displayItem(temp);
            temp = temp.next;
        }
    }

    // Helper to display a single item
    private void displayItem(Item item) {
        System.out.printf("ID: %d, Name: %s, Quantity: %d, Price: ₹%.2f%n",
                item.itemId, item.itemName, item.quantity, item.price);
    }

    // Sort inventory by name or price
    public void sortInventory(String key, boolean ascending) {
        head = mergeSort(head, key, ascending);
        System.out.println("Inventory sorted by " + key + " (" + (ascending ? "asc" : "desc") + ").");
    }

    // Merge Sort for linked list
    private Item mergeSort(Item head, String key, boolean ascending) {
        if (head == null || head.next == null)
            return head;

        Item mid = getMiddle(head);
        Item midNext = mid.next;
        mid.next = null;

        Item left = mergeSort(head, key, ascending);
        Item right = mergeSort(midNext, key, ascending);

        return merge(left, right, key, ascending);
    }

    private Item getMiddle(Item head) {
        if (head == null) return head;
        Item slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Item merge(Item a, Item b, String key, boolean ascending) {
        Item dummy = new Item("", 0, 0, 0);
        Item tail = dummy;

        while (a != null && b != null) {
            boolean condition;
            if (key.equalsIgnoreCase("name")) {
                condition = ascending ? a.itemName.compareToIgnoreCase(b.itemName) <= 0
                        : a.itemName.compareToIgnoreCase(b.itemName) > 0;
            } else {
                condition = ascending ? a.price <= b.price : a.price > b.price;
            }

            if (condition) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }

        tail.next = (a != null) ? a : b;
        return dummy.next;
    }

    // Main menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InventoryManagement im = new InventoryManagement();
        int choice;

        do {
            System.out.println("\n--- Inventory Management ---");
            System.out.println("1. Add Item at Beginning");
            System.out.println("2. Add Item at End");
            System.out.println("3. Add Item at Position");
            System.out.println("4. Remove Item by ID");
            System.out.println("5. Update Quantity");
            System.out.println("6. Search by ID or Name");
            System.out.println("7. Display All Items");
            System.out.println("8. Calculate Total Value");
            System.out.println("9. Sort by Name");
            System.out.println("10. Sort by Price");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt(); sc.nextLine();

            String name;
            int id, qty, pos;
            double price;

            switch (choice) {
                case 1:
                    System.out.print("Enter Name, ID, Quantity, Price: ");
                    name = sc.nextLine();
                    id = sc.nextInt(); qty = sc.nextInt(); price = sc.nextDouble();
                    im.addAtBeginning(name, id, qty, price);
                    break;
                case 2:
                    System.out.print("Enter Name, ID, Quantity, Price: ");
                    name = sc.nextLine();
                    id = sc.nextInt(); qty = sc.nextInt(); price = sc.nextDouble();
                    im.addAtEnd(name, id, qty, price);
                    break;
                case 3:
                    System.out.print("Enter Position, Name, ID, Quantity, Price: ");
                    pos = sc.nextInt(); sc.nextLine();
                    name = sc.nextLine();
                    id = sc.nextInt(); qty = sc.nextInt(); price = sc.nextDouble();
                    im.addAtPosition(pos, name, id, qty, price);
                    break;
                case 4:
                    System.out.print("Enter Item ID to remove: ");
                    id = sc.nextInt();
                    im.removeById(id);
                    break;
                case 5:
                    System.out.print("Enter Item ID and New Quantity: ");
                    id = sc.nextInt(); qty = sc.nextInt();
                    im.updateQuantity(id, qty);
                    break;
                case 6:
                    System.out.print("Enter Item ID or Name to search: ");
                    String keyword = sc.nextLine();
                    im.searchByIdOrName(keyword);
                    break;
                case 7:
                    im.displayAll();
                    break;
                case 8:
                    im.calculateTotalValue();
                    break;
                case 9:
                    System.out.print("Sort ascending? (true/false): ");
                    boolean ascName = sc.nextBoolean();
                    im.sortInventory("name", ascName);
                    break;
                case 10:
                    System.out.print("Sort ascending? (true/false): ");
                    boolean ascPrice = sc.nextBoolean();
                    im.sortInventory("price", ascPrice);
                    break;
                case 11:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 11);

        sc.close();
    }
}
