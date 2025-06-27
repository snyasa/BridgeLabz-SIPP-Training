import java.util.ArrayList;

// Employee class
class Employee {
    private String name;
    private String role;

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public void displayEmployee() {
        System.out.println("   - Employee: " + name + ", Role: " + role);
    }
}

// Department class (inner part of composition)
class Department {
    private String deptName;
    private ArrayList<Employee> employees;

    public Department(String deptName) {
        this.deptName = deptName;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(String name, String role) {
        employees.add(new Employee(name, role));
    }

    public void displayDepartment() {
        System.out.println(" Department: " + deptName);
        for (Employee e : employees) {
            e.displayEmployee();
        }
    }

    public void clearEmployees() {
        employees.clear(); // simulate deletion
    }
}

// Company class (whole part of composition)
class Company {
    private String companyName;
    private ArrayList<Department> departments;

    public Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    public void addEmployeeToDepartment(String deptName, String empName, String role) {
        for (Department dept : departments) {
            if (deptName.equals(dept.deptName)) {
                dept.addEmployee(empName, role);
                return;
            }
        }
        System.out.println("Department " + deptName + " not found.");
    }

    public void displayCompanyStructure() {
        System.out.println("Company: " + companyName);
        for (Department dept : departments) {
            dept.displayDepartment();
        }
    }

    // Simulate deleting the company (and everything it owns)
    public void deleteCompany() {
        for (Department dept : departments) {
            dept.clearEmployees();
        }
        departments.clear();
        System.out.println("Company " + companyName + " and all its departments and employees have been deleted.");
    }
}
