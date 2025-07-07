import java.util.Scanner;

class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

public class MovieManagementSystem {
    private Movie head = null;
    private Movie tail = null;

    // Add at the beginning
    public void addAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    // Add at the end
    public void addAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Add at a specific position (1-based index)
    public void addAtPosition(int position, String title, String director, int year, double rating) {
        if (position <= 0) {
            System.out.println("Invalid position!");
            return;
        }
        if (position == 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        Movie newMovie = new Movie(title, director, year, rating);
        Movie current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }

        if (current == null || current == tail) {
            addAtEnd(title, director, year, rating);
        } else {
            newMovie.next = current.next;
            newMovie.prev = current;
            current.next.prev = newMovie;
            current.next = newMovie;
        }
    }

    // Remove a movie by title
    public void removeByTitle(String title) {
        Movie current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
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
                System.out.println("Movie removed successfully.");
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found.");
    }

    // Search by director
    public void searchByDirector(String director) {
        Movie current = head;
        boolean found = false;
        while (current != null) {
            if (current.director.equalsIgnoreCase(director)) {
                displayMovie(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No movie found by this director.");
        }
    }

    // Search by rating
    public void searchByRating(double rating) {
        Movie current = head;
        boolean found = false;
        while (current != null) {
            if (current.rating == rating) {
                displayMovie(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No movie found with this rating.");
        }
    }

    // Update rating by title
    public void updateRating(String title, double newRating) {
        Movie current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.rating = newRating;
                System.out.println("Rating updated successfully.");
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found.");
    }

    // Display all movies (forward)
    public void displayForward() {
        if (head == null) {
            System.out.println("No movies to display.");
            return;
        }

        System.out.println("\nMovies in forward order:");
        Movie current = head;
        while (current != null) {
            displayMovie(current);
            current = current.next;
        }
    }

    // Display all movies (reverse)
    public void displayReverse() {
        if (tail == null) {
            System.out.println("No movies to display.");
            return;
        }

        System.out.println("\nMovies in reverse order:");
        Movie current = tail;
        while (current != null) {
            displayMovie(current);
            current = current.prev;
        }
    }

    // Display movie details
    private void displayMovie(Movie m) {
        System.out.println("Title: " + m.title + ", Director: " + m.director + ", Year: " + m.year + ", Rating: " + m.rating);
    }

    // Main menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieManagementSystem system = new MovieManagementSystem();
        int choice;

        do {
            System.out.println("\n---- Movie Management System ----");
            System.out.println("1. Add Movie at Beginning");
            System.out.println("2. Add Movie at End");
            System.out.println("3. Add Movie at Position");
            System.out.println("4. Remove Movie by Title");
            System.out.println("5. Search Movie by Director");
            System.out.println("6. Search Movie by Rating");
            System.out.println("7. Update Movie Rating");
            System.out.println("8. Display All (Forward)");
            System.out.println("9. Display All (Reverse)");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            String title, director;
            int year, pos;
            double rating;

            switch (choice) {
                case 1:
                    System.out.print("Enter Title, Director, Year, Rating: ");
                    title = sc.nextLine();
                    director = sc.nextLine();
                    year = sc.nextInt();
                    rating = sc.nextDouble();
                    system.addAtBeginning(title, director, year, rating);
                    break;
                case 2:
                    System.out.print("Enter Title, Director, Year, Rating: ");
                    title = sc.nextLine();
                    director = sc.nextLine();
                    year = sc.nextInt();
                    rating = sc.nextDouble();
                    system.addAtEnd(title, director, year, rating);
                    break;
                case 3:
                    System.out.print("Enter Position, Title, Director, Year, Rating: ");
                    pos = sc.nextInt(); sc.nextLine();
                    title = sc.nextLine();
                    director = sc.nextLine();
                    year = sc.nextInt();
                    rating = sc.nextDouble();
                    system.addAtPosition(pos, title, director, year, rating);
                    break;
                case 4:
                    System.out.print("Enter Movie Title to remove: ");
                    title = sc.nextLine();
                    system.removeByTitle(title);
                    break;
                case 5:
                    System.out.print("Enter Director name to search: ");
                    director = sc.nextLine();
                    system.searchByDirector(director);
                    break;
                case 6:
                    System.out.print("Enter Rating to search: ");
                    rating = sc.nextDouble();
                    system.searchByRating(rating);
                    break;
                case 7:
                    System.out.print("Enter Title and New Rating: ");
                    title = sc.nextLine();
                    rating = sc.nextDouble();
                    system.updateRating(title, rating);
                    break;
                case 8:
                    system.displayForward();
                    break;
                case 9:
                    system.displayReverse();
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
