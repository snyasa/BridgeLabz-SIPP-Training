import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

class Member {
    String name;
    LocalDate expiryDate;

    public Member(String name, LocalDate expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return name + " (Expires: " + expiryDate + ")";
    }
}

public class ExpiringMemberships {
    public static void main(String[] args) {
        List<Member> members = Arrays.asList(
                new Member("Amit", LocalDate.now().plusDays(5)),
                new Member("Neha", LocalDate.now().plusDays(15)),
                new Member("Ravi", LocalDate.now().plusDays(45)),
                new Member("Pooja", LocalDate.now().plusDays(25)),
                new Member("Arjun", LocalDate.now().plusDays(60))
        );

        LocalDate today = LocalDate.now();
        LocalDate cutoffDate = today.plusDays(30);

        List<Member> expiringSoon = members.stream()
                .filter(m -> !m.expiryDate.isBefore(today)) 
                .filter(m -> !m.expiryDate.isAfter(cutoffDate)) 
                .collect(Collectors.toList());

        System.out.println("Members with expiring memberships (within 30 days):");
        expiringSoon.forEach(System.out::println);
    }
}
