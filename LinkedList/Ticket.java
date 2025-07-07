import java.util.Scanner;

class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

public class TicketReservationSystem {
    private Ticket head = null;
    private Ticket tail = null;

    // Add ticket at end
    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = tail = newTicket;
            tail.next = head; // Circular link
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head;
        }
        System.out.println("Ticket booked successfully!");
    }

    // Remove ticket by ID
    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket current = head, prev = tail;
        boolean found = false;

        do {
            if (current.ticketId == ticketId) {
                found = true;
                if (current == head && current == tail) { // Only one node
                    head = tail = null;
                } else {
                    prev.next = current.next;
                    if (current == head)
                        head = current.next;
                    if (current == tail)
                        tail = prev;
                }
                System.out.println("Ticket ID " + ticketId + " removed.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("Ticket ID not found.");
        }
    }

    // Display all tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket current = head;
        System.out.println("\n--- Booked Tickets ---");
        do {
            System.out.printf("ID: %d | Customer: %s | Movie: %s | Seat: %s | Time: %s\n",
                    current.ticketId, current.customerName, current.movieName, current.seatNumber, current.bookingTime);
            current = current.next;
        } while (current != head);
    }

    // Search by Customer Name or Movie Name
    public void searchTicket(String keyword) {
        if (head == null) {
            System.out.println("No tickets to search.");
            return;
        }

        Ticket current = head;
        boolean found = false;
        System.out.println("\n--- Search Results ---");
        do {
            if (current.customerName.equalsIgnoreCase(keyword) || current.movieName.equalsIgnoreCase(keyword)) {
                System.out.printf("ID: %d | Customer: %s | Movie: %s | Seat: %s | Time: %s\n",
                        current.ticketId, current.customerName, current.movieName, current.seatNumber, current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No matching tickets found.");
        }
    }

    // Count total tickets
    public void countTickets() {
        if (head == null) {
            System.out.println("Total Booked Tickets: 0");
            return;
        }

        int count = 0;
        Ticket current = head;
        do {
            count++;
            current = current.next;
        } while (current != head);

        System.out.println("Total Booked Tickets: " + count);
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketReservationSystem system = new TicketReservationSystem();
        int choice;

        do {
            System.out.println("\n--- Ticket Reservation Menu ---");
            System.out.println("1. Book Ticket");
            System.out.println("2. Remove Ticket by ID");
            System.out.println("3. Display All Tickets");
            System.out.println("4. Search Ticket (Customer or Movie)");
            System.out.println("5. Count Total Booked Tickets");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Ticket ID: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Movie Name: ");
                    String movie = sc.nextLine();
                    System.out.print("Enter Seat Number: ");
                    String seat = sc.nextLine();
                    System.out.print("Enter Booking Time: ");
                    String time = sc.nextLine();
                    system.addTicket(id, name, movie, seat, time);
                    break;
                case 2:
                    System.out.print("Enter Ticket ID to remove: ");
                    int removeId = sc.nextInt();
                    system.removeTicket(removeId);
                    break;
                case 3:
                    system.displayTickets();
                    break;
                case 4:
                    System.out.print("Enter Customer or Movie name to search: ");
                    String keyword = sc.nextLine();
                    system.searchTicket(keyword);
                    break;
                case 5:
                    system.countTickets();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 6);

        sc.close();
    }
}
