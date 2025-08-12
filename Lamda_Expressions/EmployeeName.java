import java.util.*;
import java.util.stream.Collectors;

public class EmployeeName {
    public static void main(String[] args) {

        List<String> employeeNames = Arrays.asList(
                "Amit Sharma",
                "Neha Verma",
                "Rahul Singh",
                "Priya Kapoor"
        );

        System.out.println("Employee Names in Uppercase for HR Letter:");

        // Using String::toUpperCase in a stream
        List<String> uppercasedNames = employeeNames.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        uppercasedNames.forEach(System.out::println);
    }
}
