import java.util.*;


interface Vehicle {
    void rent();
    void returnVehicle();
}


class Car implements Vehicle {
    @Override
    public void rent() {
        System.out.println("Car has been rented");
    }

    @Override
    public void returnVehicle() {
        System.out.println("Car has been returned");
    }
}


class Bike implements Vehicle {
    @Override
    public void rent() {
        System.out.println("Bike has been rented");
    }

    @Override
    public void returnVehicle() {
        System.out.println("Bike has been returned");
    }
}


class Bus implements Vehicle {
    @Override
    public void rent() {
        System.out.println("Bus has been rented");
    }

    @Override
    public void returnVehicle() {
        System.out.println("Bus has been returned");
    }
}


public class VehicleRentalSystem {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car());
        vehicles.add(new Bike());
        vehicles.add(new Bus());

        System.out.println("--- Renting all vehicles ---");
        for (Vehicle v : vehicles) {
            v.rent();
        }

        System.out.println("--- Returning all vehicles ---");
        for (Vehicle v : vehicles) {
            v.returnVehicle();
        }
    }
}
