import java.util.*;

class Employee {
    String name;
    String department;

    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String toString() {
        return name;
    }
}

public class GroupByDepartment {
    public static void main(String[] args) {
        // Sample list of employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", "HR"));
        employees.add(new Employee("Bob", "IT"));
        employees.add(new Employee("Carol", "HR"));
        employees.add(new Employee("David", "Finance"));
        employees.add(new Employee("Eve", "IT"));

        // Grouping map
        Map<String, List<Employee>> departmentMap = new HashMap<>();

        for (Employee emp : employees) {
            if (!departmentMap.containsKey(emp.department)) {
                departmentMap.put(emp.department, new ArrayList<>());
            }
            departmentMap.get(emp.department).add(emp);
        }

        // Print grouped result
        for (String dept : departmentMap.keySet()) {
            System.out.println(dept + ": " + departmentMap.get(dept));
        }
    }
}
