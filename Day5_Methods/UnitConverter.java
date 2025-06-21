public class UnitConverter {
    public static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    public static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    public static double poundsToKg(double p) {
        return p * 0.453592;
    }

    public static double kgToPounds(double kg) {
        return kg * 2.20462;
    }

    public static double gallonsToLiters(double g) {
        return g * 3.78541;
    }

    public static double litersToGallons(double l) {
        return l * 0.264172;
    }

    public static void main(String[] args) {
        System.out.println("100°F to Celsius: " + fahrenheitToCelsius(100));
        System.out.println("37°C to Fahrenheit: " + celsiusToFahrenheit(37));
        System.out.println("150 pounds to kg: " + poundsToKg(150));
        System.out.println("68 kg to pounds: " + kgToPounds(68));
        System.out.println("10 gallons to liters: " + gallonsToLiters(10));
        System.out.println("3 liters to gallons: " + litersToGallons(3));
    }
}
