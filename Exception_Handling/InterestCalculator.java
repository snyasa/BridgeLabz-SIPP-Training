public class InterestCalculator {

    // Method that throws an exception — using 'throws'
    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0) {
            // Throwing an exception explicitly — using 'throw'
            throw new IllegalArgumentException("Amount and rate must be positive");
        }

        return (amount * rate * years) / 100; // Simple Interest
    }

    public static void main(String[] args) {
        try {
            double amount = 10000;
            double rate = -5;   // Example of invalid input
            int years = 2;

            double interest = calculateInterest(amount, rate, years);
            System.out.println("Calculated Interest: " + interest);

        } catch (IllegalArgumentException e) {
            // Handling the exception thrown from the method
            System.out.println("Invalid input: " + e.getMessage());
        }
    }
}
