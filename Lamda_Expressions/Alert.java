import java.util.*;
import java.util.function.Predicate;

class Alert {
    String type;     // e.g., "Critical", "Info", "Reminder"
    String message;

    Alert(String type, String message) {
        this.type = type;
        this.message = message;
    }

    @Override
    public String toString() {
        return "[" + type + "] " + message;
    }
}

public class NotificationFiltering {
    public static void main(String[] args) {

        List<Alert> alerts = Arrays.asList(
                new Alert("Critical", "Patient heart rate abnormal!"),
                new Alert("Info", "New lab report available."),
                new Alert("Reminder", "Time for medication."),
                new Alert("Critical", "Low oxygen level detected."),
                new Alert("Info", "Next appointment scheduled.")
        );

        // Example user preference: show only "Critical" alerts
        Predicate<Alert> criticalOnly = alert -> alert.type.equalsIgnoreCase("Critical");

        // Example user preference: show only "Reminder" alerts
        Predicate<Alert> remindersOnly = alert -> alert.type.equalsIgnoreCase("Reminder");

        // Filtering based on chosen preference
        System.out.println("Critical Alerts:");
        filterAlerts(alerts, criticalOnly);

        System.out.println("\nReminder Alerts:");
        filterAlerts(alerts, remindersOnly);
    }

    // Method to filter alerts using a Predicate
    private static void filterAlerts(List<Alert> alerts, Predicate<Alert> condition) {
        alerts.stream()
              .filter(condition)
              .forEach(System.out::println);
    }
}
