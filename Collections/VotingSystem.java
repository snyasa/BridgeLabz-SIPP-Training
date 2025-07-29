import java.util.*;

public class VotingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // HashMap to store total votes
        HashMap<String, Integer> voteCount = new HashMap<>();

        // LinkedHashMap to track vote insertion order
        LinkedHashMap<String, Integer> voteOrder = new LinkedHashMap<>();

        // Input voting data
        System.out.print("Enter number of votes: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        for (int i = 0; i < n; i++) {
            System.out.print("Enter candidate name for vote " + (i + 1) + ": ");
            String candidate = sc.nextLine();

            // Update HashMap
            voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);

            // Track in LinkedHashMap if not already present
            voteOrder.putIfAbsent(candidate, 0);
        }

        // Display vote count from HashMap
        System.out.println("\nTotal Votes (HashMap - Unordered):");
        for (Map.Entry<String, Integer> entry : voteCount.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Display insertion order from LinkedHashMap
        System.out.println("\nVote Order (LinkedHashMap - Insertion Order):");
        for (String candidate : voteOrder.keySet()) {
            System.out.println(candidate);
        }

        // Display sorted result using TreeMap
        TreeMap<String, Integer> sortedVotes = new TreeMap<>(voteCount);
        System.out.println("\nSorted Results (TreeMap - Alphabetical Order):");
        for (Map.Entry<String, Integer> entry : sortedVotes.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
