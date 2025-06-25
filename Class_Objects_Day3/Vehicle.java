import java.util.Scanner;

class Vehicle {
    // Static variable (shared by all vehicles)
    static double registrationFee = 1500.0;

    // Final variable (unique and unchangeable)
    final String registrationNumber;

    // Instance variables
    String ownerName;
    String vehicleType;

    // Constructor using 'this'
    Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    // Static method to update registration fee
    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    // Method to display vehicle details
    void displayDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Registration Fee: ₹" + registrationFee);
        System.out.println("----------------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for first vehicle
        System.out.print("Enter owner name: ");
        String owner1 = sc.nextLine();

        System.out.print("Enter vehicle type: ");
        String type1 = sc.nextLine();

        System.out.print("Enter registration number: ");
        String regNum1 = sc.nextLine();

        Vehicle v1 = new Vehicle(owner1, type1, regNum1);

        // Input for second vehicle
        System.out.print("Enter second owner name: ");
        String owner2 = sc.nextLine();

        System.out.print("Enter vehicle type: ");
        String type2 = sc.nextLine();

        System.out.print("Enter registration number: ");
        String regNum2 = sc.nextLine();

        Vehicle v2 = new Vehicle(owner2, type2, regNum2);

        // Optionally update registration fee
        System.out.print("Enter new registration fee: ");
        double newFee = sc.nextDouble();
        Vehicle.updateRegistrationFee(newFee);

        // Display details with instanceof check
        if (v1 instanceof Vehicle) {
            v1.displayDetails();
        }

        if (v2 instanceof Vehicle) {
            v2.displayDetails();
        }

        sc.close();
    }
}
