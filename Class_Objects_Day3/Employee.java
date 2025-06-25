import java.util.Scanner;

class Employee {
    // Static variable (shared by all employees)
    static String companyName = "Tech Solutions Ltd.";
    static int totalEmployees = 0;

    // Final variable (employee ID can't be changed)
    final int id;

    // Instance variables
    String name;
    String designation;

    // Constructor using 'this'
    Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

    // Static method to display total employees
    static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    // Method to display employee details
    void displayDetails() {
        System.out.println("Company: " + companyName);
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Designation: " + designation);
        System.out.println("-------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // First employee input
        System.out.print("Enter employee name: ");
        String name1 = sc.nextLine();

        System.out.print("Enter employee ID: ");
        int id1 = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter employee designation: ");
        String desig1 = sc.nextLine();

        Employee emp1 = new Employee(name1, id1, desig1);

        // Second employee input
        System.out.print("Enter second employee name: ");
        String name2 = sc.nextLine();

        System.out.print("Enter second employee ID: ");
        int id2 = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter second employee designation: ");
        String desig2 = sc.nextLine();

        Employee emp2 = new Employee(name2, id2, desig2);

        // Show total employees
        Employee.displayTotalEmployees();

        // Display employee details directly (no instanceof)
        emp1.displayDetails();
        emp2.displayDetails();

        sc.close();
    }
}
