import java.util.*;
import java.util.stream.Collectors;

public class Group {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String[]> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter grade: ");
            String grade = sc.nextLine();

            students.add(new String[]{name, grade});
        }

             Map<String, List<String>> grouped =
            students.stream()
                    .collect(Collectors.groupingBy(
                        s -> s[1],  // grade
                        Collectors.mapping(s -> s[0], Collectors.toList()) 
                    ));

        System.out.println("\n--- Grouped Students ---");
        grouped.forEach((grade, names) ->
            System.out.println("Grade " + grade + ": " + names)
        );
    }
}
