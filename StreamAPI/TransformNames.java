import java.util.*;
import java.util.stream.*;

public class TransformNames {
    public static void main(String[] args) {
        List<String> customers = Arrays.asList(
                "Riya", "Amit", "Sneha", "Vikram", "Anjali", "Karan"
        );

        List<String> transformed = customers.stream()
                .map(String::toUpperCase)   
                .sorted()                   
                .collect(Collectors.toList());

        System.out.println("Transformed Customer Names (Uppercase & Sorted):");
        transformed.forEach(System.out::println);
    }
}
