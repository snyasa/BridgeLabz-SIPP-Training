import java.util.*;

public class InvertMapBasic {
    public static void main(String[] args) {
        HashMap<String, Integer> original = new HashMap<>();
        original.put("A", 1);
        original.put("B", 2);
        original.put("C", 1);

        HashMap<Integer, ArrayList<String>> inverted = new HashMap<>();

        for (String key : original.keySet()) {
            int value = original.get(key);

            if (!inverted.containsKey(value)) {
                inverted.put(value, new ArrayList<>());
            }

            inverted.get(value).add(key);
        }

        System.out.println(inverted);
    }
}
