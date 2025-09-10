import java.util.*;
import java.util.stream.*;

public class IoTSensorReadings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Double> sensorReadings = Arrays.asList(
                22.5, 35.8, 18.2, 40.1, 29.7, 45.3, 15.0
        );

        System.out.print("Enter threshold value: ");
        double threshold = sc.nextDouble();

        System.out.println("\nIoT Sensor Readings above threshold (" + threshold + "):");
        sensorReadings.stream()
                .filter(reading -> reading > threshold)
                .forEach(reading ->
                        System.out.println("Reading: " + reading)
                );

        sc.close();
    }
}
