import java.util.HashMap;
import java.util.Map;

@FunctionalInterface
interface LightAction {
    void execute();
}

public class SmartHomeLighting {
    public static void main(String[] args) {

        // Map to store triggers and their corresponding light actions
        Map<String, LightAction> triggers = new HashMap<>();

        // Define behaviors using lambdas instead of creating separate classes
        triggers.put("motion", () -> System.out.println("Lights ON with soft warm glow."));
        triggers.put("evening", () -> System.out.println("Lights ON with cozy dim setting."));
        triggers.put("morning", () -> System.out.println("Lights ON with bright daylight mode."));
        triggers.put("voice_hello", () -> System.out.println("Lights blink twice and stay ON."));
        triggers.put("night_security", () -> System.out.println("Lights flash red for security alert!"));

        // Simulating triggers
        simulateTrigger("motion", triggers);
        simulateTrigger("evening", triggers);
        simulateTrigger("voice_hello", triggers);
        simulateTrigger("night_security", triggers);
    }

    private static void simulateTrigger(String triggerName, Map<String, LightAction> triggers) {
        System.out.print("Trigger: " + triggerName + " → ");
        LightAction action = triggers.get(triggerName);
        if (action != null) {
            action.execute();
        } else {
            System.out.println("No action assigned for this trigger.");
        }
    }
}
