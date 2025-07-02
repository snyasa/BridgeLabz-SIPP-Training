// Interface: Insurable
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    // Constructor
    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // Getters (Encapsulation)
    public String getVehicleNumber() { return vehicleNumber; }
    public String getType() { return type; }
    public double getRentalRate() { return rentalRate; }

    // Abstract method
    public abstract double calculateRentalCost(int days);

    public void displayVehicleDetails() {
        System.out.println("Vehicle No: " + vehicleNumber + ", Type: " + type + ", Rate/Day: " + rentalRate);
    }
}
class Car extends Vehicle implements Insurable {
    private String policyNumber;

    public Car(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.policyNumber = policyNumber;
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    public double calculateInsurance() {
        return 0.05 * getRentalRate(); // 5% of rental rate as insurance
    }

    public String getInsuranceDetails() {
        return "Policy #" + policyNumber + " (5% Insurance)";
    }
}

class Bike extends Vehicle implements Insurable {
    private String policyNumber;

    public Bike(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Bike", rentalRate);
        this.policyNumber = policyNumber;
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 0.9; // 10% discount
    }

    public double calculateInsurance() {
        return 0.02 * getRentalRate(); // 2% of rental rate
    }

    public String getInsuranceDetails() {
        return "Policy #" + policyNumber + " (2% Insurance)";
    }
}

class Truck extends Vehicle implements Insurable {
    private String policyNumber;

    public Truck(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Truck", rentalRate);
        this.policyNumber = policyNumber;
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 500; // Fixed loading fee
    }

    public double calculateInsurance() {
        return 0.08 * getRentalRate(); // 8% of rental rate
    }

    public String getInsuranceDetails() {
        return "Policy #" + policyNumber + " (8% Insurance)";
    }
}
public class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("CAR123", 1000, "CAR-INS-001"),
            new Bike("BIK456", 500, "BIK-INS-002"),
            new Truck("TRK789", 2000, "TRK-INS-003")
        };

        int rentalDays = 3;

        for (Vehicle v : vehicles) {
            v.displayVehicleDetails();
            System.out.println("Rental Cost for " + rentalDays + " days: ₹" + v.calculateRentalCost(rentalDays));

            if (v instanceof Insurable) {
                Insurable ins = (Insurable) v;
                System.out.println("Insurance Cost: ₹" + ins.calculateInsurance());
                System.out.println("Insurance Details: " + ins.getInsuranceDetails());
            }

        }
    }
}
