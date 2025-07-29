// Combined Insurance Policy Management System
import java.time.LocalDate;
import java.util.*;

// Policy Class
class Policy implements Comparable<Policy> {
    String policyNumber;
    String policyholderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;

    public Policy(String policyNumber, String name, LocalDate expiry, String type, double premium) {
        this.policyNumber = policyNumber;
        this.policyholderName = name;
        this.expiryDate = expiry;
        this.coverageType = type;
        this.premiumAmount = premium;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Policy)) return false;
        Policy p = (Policy) o;
        return this.policyNumber.equals(p.policyNumber);
    }

    @Override
    public int hashCode() {
        return policyNumber.hashCode();
    }

    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return policyNumber + " | " + policyholderName + " | " + expiryDate + " | " + coverageType + " | ₹" + premiumAmount;
    }
}

// Policy Manager
class PolicyManager {
    Set<Policy> hashSet = new HashSet<>();
    Set<Policy> linkedHashSet = new LinkedHashSet<>();
    Set<Policy> treeSet = new TreeSet<>();

    public void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    public void displayAllPolicies(Set<Policy> set, String title) {
        System.out.println("\n--- " + title + " ---");
        for (Policy p : set) {
            System.out.println(p);
        }
    }

    public void displayPoliciesExpiringSoon(Set<Policy> set) {
        LocalDate now = LocalDate.now();
        System.out.println("\n--- Policies Expiring in Next 30 Days ---");
        for (Policy p : set) {
            if (!p.expiryDate.isBefore(now) && !p.expiryDate.isAfter(now.plusDays(30))) {
                System.out.println(p);
            }
        }
    }

    public void displayPoliciesByCoverage(Set<Policy> set, String coverageType) {
        System.out.println("\n--- Policies with Coverage Type: " + coverageType + " ---");
        for (Policy p : set) {
            if (p.coverageType.equalsIgnoreCase(coverageType)) {
                System.out.println(p);
            }
        }
    }

    public void detectDuplicates(List<Policy> policyList) {
        Set<String> seen = new HashSet<>();
        System.out.println("\n--- Duplicate Policies (Based on Policy Number) ---");
        for (Policy p : policyList) {
            if (!seen.add(p.policyNumber)) {
                System.out.println(p);
            }
        }
    }
}

// Performance Comparison
class PerformanceComparison {
    public static void compare(Set<Policy> set, String type) {
        long start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            set.add(new Policy("P" + i, "Name", LocalDate.now().plusDays(i % 365), "Auto", 1000));
        }
        long end = System.nanoTime();
        System.out.println(type + " Add Time: " + (end - start) / 1e6 + " ms");

        start = System.nanoTime();
        set.contains(new Policy("P5000", "Test", LocalDate.now(), "Auto", 0));
        end = System.nanoTime();
        System.out.println(type + " Search Time: " + (end - start) + " ns");

        start = System.nanoTime();
        set.remove(new Policy("P5000", "Test", LocalDate.now(), "Auto", 0));
        end = System.nanoTime();
        System.out.println(type + " Remove Time: " + (end - start) + " ns\n");
    }
}

// Main Class
public class InsurancePolicySystem {
    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();

        // Sample data
        manager.addPolicy(new Policy("P101", "Alice", LocalDate.now().plusDays(15), "Health", 3000));
        manager.addPolicy(new Policy("P102", "Bob", LocalDate.now().plusDays(40), "Auto", 2500));
        manager.addPolicy(new Policy("P103", "Carol", LocalDate.now().plusDays(5), "Health", 4000));
        manager.addPolicy(new Policy("P104", "David", LocalDate.now().plusDays(10), "Home", 4500));
        manager.addPolicy(new Policy("P102", "Bob", LocalDate.now().plusDays(40), "Auto", 2500)); // duplicate

        // Display from different sets
        manager.displayAllPolicies(manager.hashSet, "HashSet (Unordered)");
        manager.displayAllPolicies(manager.linkedHashSet, "LinkedHashSet (Insertion Order)");
        manager.displayAllPolicies(manager.treeSet, "TreeSet (Sorted by Expiry Date)");

        // Expiring soon
        manager.displayPoliciesExpiringSoon(manager.treeSet);

        // By Coverage
        manager.displayPoliciesByCoverage(manager.hashSet, "Health");

        // Duplicates detection from a list
        List<Policy> duplicateCheckList = new ArrayList<>(manager.hashSet);
        duplicateCheckList.add(new Policy("P101", "Alice", LocalDate.now().plusDays(15), "Health", 3000));
        manager.detectDuplicates(duplicateCheckList);

        // Performance Comparison
        System.out.println("\n--- Performance Comparison ---");
        PerformanceComparison.compare(new HashSet<>(), "HashSet");
        PerformanceComparison.compare(new LinkedHashSet<>(), "LinkedHashSet");
        PerformanceComparison.compare(new TreeSet<>(), "TreeSet");
    }
}
