import java.util.Scanner;

class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    Book next, prev;

    public Book(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

public class LibraryManagementSystem {
    private Book head = null;
    private Book tail = null;

    // Add book at beginning
    public void addAtBeginning(String title, String author, String genre, int id, boolean status) {
        Book newBook = new Book(title, author, genre, id, status);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    // Add book at end
    public void addAtEnd(String title, String author, String genre, int id, boolean status) {
        Book newBook = new Book(title, author, genre, id, status);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    // Add at a specific position (1-based index)
    public void addAtPosition(int pos, String title, String author, String genre, int id, boolean status) {
        if (pos <= 0) {
            System.out.println("Invalid position!");
            return;
        }
        if (pos == 1) {
            addAtBeginning(title, author, genre, id, status);
            return;
        }

        Book newBook = new Book(title, author, genre, id, status);
        Book current = head;

        for (int i = 1; i < pos - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null || current == tail) {
            addAtEnd(title, author, genre, id, status);
        } else {
            newBook.next = current.next;
            newBook.prev = current;
            current.next.prev = newBook;
            current.next = newBook;
        }
    }

    // Remove a book by Book ID
    public void removeByBookId(int id) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }

        Book current = head;
        while (current != null) {
            if (current.bookId == id) {
                if (current == head && current == tail) {
                    head = tail = null;
                } else if (current == head) {
                    head = head.next;
                    head.prev = null;
                } else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                System.out.println("Book removed.");
                return;
            }
            current = current.next;
        }

        System.out.println("Book not found.");
    }

    // Search by Title or Author
    public void searchByTitleOrAuthor(String keyword) {
        boolean found = false;
        Book current = head;

        while (current != null) {
            if (current.title.equalsIgnoreCase(keyword) || current.author.equalsIgnoreCase(keyword)) {
                displayBook(current);
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("No book found with the given title or author.");
        }
    }

    // Update availability
    public void updateAvailability(int id, boolean status) {
        Book current = head;
        while (current != null) {
            if (current.bookId == id) {
                current.isAvailable = status;
                System.out.println("Availability updated.");
                return;
            }
            current = current.next;
        }
        System.out.println("Book not found.");
    }

    // Display all books in forward order
    public void displayForward() {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }

        System.out.println("\nBooks in Forward Order:");
        Book current = head;
        while (current != null) {
            displayBook(current);
            current = current.next;
        }
    }

    // Display all books in reverse order
    public void displayReverse() {
        if (tail == null) {
            System.out.println("Library is empty.");
            return;
        }

        System.out.println("\nBooks in Reverse Order:");
        Book current = tail;
        while (current != null) {
            displayBook(current);
            current = current.prev;
        }
    }

    // Count total books
    public void countBooks() {
        int count = 0;
        Book current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        System.out.println("Total number of books: " + count);
    }

    // Display a book
    private void displayBook(Book b) {
        System.out.printf("ID: %d, Title: %s, Author: %s, Genre: %s, Available: %s%n",
                b.bookId, b.title, b.author, b.genre, b.isAvailable ? "Yes" : "No");
    }

    // Main menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryManagementSystem lib = new LibraryManagementSystem();
        int choice;

        do {
            System.out.println("\n--- Library Management Menu ---");
            System.out.println("1. Add Book at Beginning");
            System.out.println("2. Add Book at End");
            System.out.println("3. Add Book at Position");
            System.out.println("4. Remove Book by ID");
            System.out.println("5. Search Book by Title or Author");
            System.out.println("6. Update Availability Status");
            System.out.println("7. Display Books (Forward)");
            System.out.println("8. Display Books (Reverse)");
            System.out.println("9. Count Total Books");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            int id, pos;
            String title, author, genre;
            boolean status;

            switch (choice) {
                case 1:
                    System.out.print("Enter Title, Author, Genre, ID, Availability (true/false): ");
                    title = sc.nextLine();
                    author = sc.nextLine();
                    genre = sc.nextLine();
                    id = sc.nextInt();
                    status = sc.nextBoolean();
                    lib.addAtBeginning(title, author, genre, id, status);
                    break;
                case 2:
                    System.out.print("Enter Title, Author, Genre, ID, Availability (true/false): ");
                    title = sc.nextLine();
                    author = sc.nextLine();
                    genre = sc.nextLine();
                    id = sc.nextInt();
                    status = sc.nextBoolean();
                    lib.addAtEnd(title, author, genre, id, status);
                    break;
                case 3:
                    System.out.print("Enter Position, Title, Author, Genre, ID, Availability (true/false): ");
                    pos = sc.nextInt();
                    sc.nextLine();
                    title = sc.nextLine();
                    author = sc.nextLine();
                    genre = sc.nextLine();
                    id = sc.nextInt();
                    status = sc.nextBoolean();
                    lib.addAtPosition(pos, title, author, genre, id, status);
                    break;
                case 4:
                    System.out.print("Enter Book ID to remove: ");
                    id = sc.nextInt();
                    lib.removeByBookId(id);
                    break;
                case 5:
                    System.out.print("Enter Title or Author to search: ");
                    String keyword = sc.nextLine();
                    lib.searchByTitleOrAuthor(keyword);
                    break;
                case 6:
                    System.out.print("Enter Book ID and New Availability (true/false): ");
                    id = sc.nextInt();
                    status = sc.nextBoolean();
                    lib.updateAvailability(id, status);
                    break;
                case 7:
                    lib.displayForward();
                    break;
                case 8:
                    lib.displayReverse();
                    break;
                case 9:
                    lib.countBooks();
                    break;
                case 10:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 10);

        sc.close();
    }
}
