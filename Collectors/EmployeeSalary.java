import java.util.*;
import java.util.stream.Collectors;

public class EmployeeSalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String[]> employees = new ArrayList<>();

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

            for (int i = 1; i <= n; i++) {
            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter department: ");
            String dept = sc.nextLine();

            System.out.print("Enter salary: ");
            double salary = sc.nextDouble();
            sc.nextLine(); 

            employees.add(new String[]{name, dept, String.valueOf(salary)});
        }

        
        Map<String, Double> avgSalary =
            employees.stream()
                     .collect(Collectors.groupingBy(
                         e -> e[1], // department
                         Collectors.averagingDouble(e -> Double.parseDouble(e[2]))
                     ));

        
        System.out.println("\n--- Average Salary by Department ---");
        avgSalary.forEach((dept, avg) ->
            System.out.println(dept + " -> " + avg)
        );
    }
}
