interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private String borrowerName = null;  // Encapsulated borrower info

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Getters
    public String getItemId() { return itemId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    public void getItemDetails() {
        System.out.println("Item ID: " + itemId + ", Title: " + title + ", Author: " + author);
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    // Abstract method
    public abstract int getLoanDuration();
}
class Book extends LibraryItem implements Reservable {
    private boolean isReserved = false;

    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 14; // 2 weeks
    }

    public void reserveItem(String borrowerName) {
        if (!isReserved) {
            isReserved = true;
            setBorrowerName(borrowerName);
            System.out.println("Book reserved for " + borrowerName);
        } else {
            System.out.println("Book is already reserved.");
        }
    }

    public boolean checkAvailability() {
        return !isReserved;
    }
}

class Magazine extends LibraryItem implements Reservable {
    private boolean isReserved = false;

    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 7; // 1 week
    }

    public void reserveItem(String borrowerName) {
        if (!isReserved) {
            isReserved = true;
            setBorrowerName(borrowerName);
            System.out.println("Magazine reserved for " + borrowerName);
        } else {
            System.out.println("Magazine is already reserved.");
        }
    }

    public boolean checkAvailability() {
        return !isReserved;
    }
}

class DVD extends LibraryItem implements Reservable {
    private boolean isReserved = false;

    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 3; // 3 days
    }

    public void reserveItem(String borrowerName) {
        if (!isReserved) {
            isReserved = true;
            setBorrowerName(borrowerName);
            System.out.println("DVD reserved for " + borrowerName);
        } else {
            System.out.println("DVD is already reserved.");
        }
    }

    public boolean checkAvailability() {
        return !isReserved;
    }
}
public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryItem[] items = {
            new Book("B001", "Java Programming", "James Gosling"),
            new Magazine("M001", "Tech Today", "Editor A"),
            new DVD("D001", "Inception", "Christopher Nolan")
        };

        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            // Reservable interface usage
            if (item instanceof Reservable) {
                Reservable r = (Reservable) item;
                if (r.checkAvailability()) {
                    r.reserveItem("John Doe");
                } else {
                    System.out.println("Item is already reserved.");
                }
            }
        }
    }
}
