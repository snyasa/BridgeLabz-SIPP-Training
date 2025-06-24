class Vehicle {
    String ownerName;
    String vehicleType;
    static double registrationFee = 5000.0; // Default fee

    // Constructor
    Vehicle(String owner, String type) {
        this.ownerName = owner;
        this.vehicleType = type;
    }

    // Instance method
    void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: ₹" + registrationFee);
    }

    // Class method
    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }
}
