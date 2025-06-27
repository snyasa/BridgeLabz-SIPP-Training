import java.util.ArrayList;

// Book class (can exist independently)
class Book {
    private String title;
    private String author;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Display book details
    public void displayBook() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}

// Library class (aggregates books)
class Library {
    private String name;
    private ArrayList<Book> books;

    // Constructor
    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    // Add book to library
    public void addBook(Book book) {
        books.add(book);
    }

    // Display library and its books
    public void displayLibrary() {
        System.out.println("Library: " + name);
        System.out.println("Books in this library:");
        for (Book b : books) {
            b.displayBook();
        }
    }
}

// Main class to demonstrate aggregation
public class AggregationExample {
    public static void main(String[] args) {
        // Creating books independently
        Book book1 = new Book("The Alchemist", "Paulo Coelho");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book book3 = new Book("1984", "George Orwell");

        // Creating libraries
        Library library1 = new Library("City Library");
        Library library2 = new Library("University Library");

        // Adding books to different libraries
        library1.addBook(book1);
        library1.addBook(book2);

        library2.addBook(book2); // same book in another library
        library2.addBook(book3);

        // Displaying library contents
        library1.displayLibrary();
        System.out.println();
        library2.displayLibrary();
    }
}
