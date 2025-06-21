public class DistanceConverter {
    public static double kmToMiles(double km) {
        return km * 0.621371;
    }
    public static double milesToKm(double mi) {
        return mi * 1.60934;
    }
    public static double metersToFeet(double m) {
        return m * 3.28084;
    }
    public static double feetToMeters(double ft) {
        return ft * 0.3048;
    }
    public static void main(String[] args) {
        System.out.println("10 km = " + kmToMiles(10) + " miles");
        System.out.println("6 miles = " + milesToKm(6) + " km");
        System.out.println("5 meters = " + metersToFeet(5) + " feet");
        System.out.println("16 feet = " + feetToMeters(16) + " meters");
    }
}
