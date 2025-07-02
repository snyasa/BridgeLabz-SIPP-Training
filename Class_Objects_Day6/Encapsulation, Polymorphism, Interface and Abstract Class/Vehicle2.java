interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String location;

    public Vehicle(String vehicleId, String driverName, double ratePerKm, String location) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.location = location;
    }

    // Getters
    public String getVehicleId() { return vehicleId; }
    public String getDriverName() { return driverName; }
    public double getRatePerKm() { return ratePerKm; }
    public String getLocation() { return location; }

    // Setter for location (encapsulation)
    public void setLocation(String location) {
        this.location = location;
    }

    // Concrete method
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate/km: ₹" + ratePerKm);
    }

    // Abstract method
    public abstract double calculateFare(double distance);
}
class Car extends Vehicle implements GPS {
    public Car(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
    }

    public double calculateFare(double distance) {
        return distance * getRatePerKm(); // No extra charges
    }

    public String getCurrentLocation() {
        return getLocation();
    }

    public void updateLocation(String newLocation) {
        setLocation(newLocation);
    }
}

class Bike extends Vehicle implements GPS {
    public Bike(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
    }

    public double calculateFare(double distance) {
        return distance * getRatePerKm() * 0.9; // 10% discount
    }

    public String getCurrentLocation() {
        return getLocation();
    }

    public void updateLocation(String newLocation) {
        setLocation(newLocation);
    }
}

class Auto extends Vehicle implements GPS {
    public Auto(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
    }

    public double calculateFare(double distance) {
        return (distance * getRatePerKm()) + 10; // ₹10 base charge
    }

    public String getCurrentLocation() {
        return getLocation();
    }

    public void updateLocation(String newLocation) {
        setLocation(newLocation);
    }
}
public class RideHailingApp {
    public static void main(String[] args) {
        Vehicle[] rides = {
            new Car("CAR101", "Alice", 15.0, "Sector 21"),
            new Bike("BIKE202", "Bob", 10.0, "MG Road"),
            new Auto("AUTO303", "Charlie", 12.0, "Central Park")
        };

        double distance = 10.0; // Ride distance in kilometers

        for (Vehicle v : rides) {
            v.getVehicleDetails();
            System.out.println("Location: " + ((GPS)v).getCurrentLocation());
            System.out.println("Fare for " + distance + " km: ₹" + v.calculateFare(distance));
            ((GPS)v).updateLocation("Destination Reached");
            System.out.println("Updated Location: " + ((GPS)v).getCurrentLocation());
        }
    }
}
