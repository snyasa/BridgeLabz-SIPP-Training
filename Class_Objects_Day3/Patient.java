import java.util.Scanner;

class Patient {
    // Static variable shared across all patients
    static String hospitalName = "Sunrise Hospital";
    static int totalPatients = 0;

    // Final variable - cannot be changed
    final int patientID;

    // Instance variables
    String name;
    int age;
    String ailment;

    // Constructor using 'this'
    Patient(String name, int age, String ailment, int patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }

    // Static method to return total patient count
    static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }

    // Method to display patient details
    void displayDetails() {
        System.out.println("Hospital: " + hospitalName);
        System.out.println("Patient ID: " + patientID);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Ailment: " + ailment);
        System.out.println("------------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for first patient
        System.out.print("Enter patient name: ");
        String name1 = sc.nextLine();

        System.out.print("Enter age: ");
        int age1 = sc.nextInt();
        sc.nextLine(); // Consume newline

        System.out.print("Enter ailment: ");
        String ailment1 = sc.nextLine();

        System.out.print("Enter patient ID: ");
        int id1 = sc.nextInt();
        sc.nextLine();

        Patient p1 = new Patient(name1, age1, ailment1, id1);

        // Input for second patient
        System.out.print("Enter second patient name: ");
        String name2 = sc.nextLine();

        System.out.print("Enter age: ");
        int age2 = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter ailment: ");
        String ailment2 = sc.nextLine();

        System.out.print("Enter patient ID: ");
        int id2 = sc.nextInt();

        Patient p2 = new Patient(name2, age2, ailment2, id2);

        // Display total patients
        Patient.getTotalPatients();

        // Use instanceof before displaying details
        if (p1 instanceof Patient) {
            p1.displayDetails();
        }

        if (p2 instanceof Patient) {
            p2.displayDetails();
        }

        sc.close();
    }
}
