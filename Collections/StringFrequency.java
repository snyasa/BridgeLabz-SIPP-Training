import java.util.*;

public class StringFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read input list size
        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        List<String> stringList = new ArrayList<>();

        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            stringList.add(sc.nextLine());
        }

        // Call method to count frequencies
        Map<String, Integer> frequencyMap = countFrequency(stringList);

        // Print the frequency map
        System.out.println("Frequency Map: " + frequencyMap);
    }

    // Method to count frequency of each string
    public static Map<String, Integer> countFrequency(List<String> list) {
        Map<String, Integer> map = new HashMap<>();

        for (String str : list) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        return map;
    }
}
