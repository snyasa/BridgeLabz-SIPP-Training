class Faculty {
    private String name;
    private String specialization;

    public Faculty(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public void displayFaculty() {
        System.out.println("Faculty: " + name + ", Specialization: " + specialization);
    }

    public String getName() {
        return name;
    }
}
import java.util.ArrayList;

class Department {
    private String deptName;
    private ArrayList<Faculty> faculties;

    public Department(String deptName) {
        this.deptName = deptName;
        this.faculties = new ArrayList<>();
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public void displayDepartment() {
        System.out.println("Department: " + deptName);
        for (Faculty faculty : faculties) {
            faculty.displayFaculty();
        }
    }

    public void clearFaculty() {
        faculties.clear(); // simulate delete
    }

    public String getDeptName() {
        return deptName;
    }
}
class University {
    private String name;
    private ArrayList<Department> departments;
    private ArrayList<Faculty> allFaculties;  // aggregation

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
        this.allFaculties = new ArrayList<>();
    }

    // Composition: university owns the department
    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    // Aggregation: faculty is associated, not owned
    public void addFaculty(Faculty faculty) {
        allFaculties.add(faculty);
    }

    public void assignFacultyToDepartment(String deptName, Faculty faculty) {
        for (Department dept : departments) {
            if (dept.getDeptName().equals(deptName)) {
                dept.addFaculty(faculty);
                return;
            }
        }
        System.out.println("Department " + deptName + " not found.");
    }

    public void displayUniversity() {
        System.out.println("University: " + name);
        for (Department dept : departments) {
            dept.displayDepartment();
        }
        System.out.println("All Faculty Members (University Level):");
        for (Faculty f : allFaculties) {
            System.out.println(" - " + f.getName());
        }
    }

    // Simulate delete: remove all departments and their data
    public void deleteUniversity() {
        for (Department dept : departments) {
            dept.clearFaculty();
        }
        departments.clear(); // destroys the whole-part structure
        System.out.println("University " + name + " and all its departments have been deleted.");
    }
}
