import java.util.*;

public class BankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Store account number -> balance
        HashMap<String, Double> accounts = new HashMap<>();

        // Sample accounts
        accounts.put("ACC101", 5000.0);
        accounts.put("ACC102", 8000.0);
        accounts.put("ACC103", 3000.0);
        accounts.put("ACC104", 10000.0);

        // Withdrawal request queue (FIFO)
        Queue<String> withdrawalQueue = new LinkedList<>();

        System.out.print("Enter number of withdrawal requests: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Account Number for withdrawal: ");
            String acc = sc.nextLine();
            withdrawalQueue.add(acc);
        }

        // Process withdrawal requests
        while (!withdrawalQueue.isEmpty()) {
            String acc = withdrawalQueue.poll();

            if (accounts.containsKey(acc)) {
                System.out.print("Enter amount to withdraw from " + acc + ": ");
                double amount = sc.nextDouble();

                double balance = accounts.get(acc);
                if (amount <= balance) {
                    accounts.put(acc, balance - amount);
                    System.out.println("Withdrawal successful. New balance: ₹" + accounts.get(acc));
                } else {
                    System.out.println("Insufficient funds for account " + acc);
                }
            } else {
                System.out.println("Account not found: " + acc);
            }
        }

        // Sort accounts by balance using TreeMap
        TreeMap<Double, List<String>> sortedAccounts = new TreeMap<>();
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            double bal = entry.getValue();
            sortedAccounts.putIfAbsent(bal, new ArrayList<>());
            sortedAccounts.get(bal).add(entry.getKey());
        }

        System.out.println("\nAccounts Sorted by Balance:");
        for (Map.Entry<Double, List<String>> entry : sortedAccounts.entrySet()) {
            for (String accNum : entry.getValue()) {
                System.out.println(accNum + " -> ₹" + entry.getKey());
            }
        }
    }
}
