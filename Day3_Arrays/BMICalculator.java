import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();
        double[][] personData = new double[number][3]; 
        String[] weightStatus = new String[number];
        for (int i = 0; i < number; i++) {
            System.out.println("\nEnter data for Person " + (i + 1));
            while (true) {
                System.out.print("Enter weight in kg: ");
                double weight = sc.nextDouble();
                if (weight <= 0) {
                    System.out.println("Weight must be positive. Try again.");
                } else {
                    personData[i][0] = weight;
                    break;
                }
            }
            while (true) {
                System.out.print("Enter height in meters: ");
                double height = sc.nextDouble();
                if (height <= 0) {
                    System.out.println("Height must be positive. Try again.");
                } else {
                    personData[i][1] = height;
                    break;
                }
            }
            double bmi = personData[i][0] / (personData[i][1] * personData[i][1]);
            personData[i][2] = bmi;

            // Step 4: Determine weight status
            if (bmi <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (bmi <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (bmi <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }
        System.out.println("\n--- BMI Report ---");
        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1));
            System.out.printf("Weight: %.2f kg\n", personData[i][0]);
            System.out.printf("Height: %.2f m\n", personData[i][1]);
            System.out.printf("BMI: %.2f\n", personData[i][2]);
            System.out.println("Status: " + weightStatus[i]);
            System.out.println("--------------------------");
        }
    }
}
