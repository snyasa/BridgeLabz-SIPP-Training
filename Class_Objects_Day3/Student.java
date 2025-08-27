import java.util.Scanner;

class Student {
    // Static variables
    static String universityName = "Global University";
    static int totalStudents = 0;

    // Final variable (cannot be changed)
    final int rollNumber;

    // Instance variables
    String name;
    String grade;

    // Constructor using 'this'
    Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    // Static method to display total students
    static void displayTotalStudents() {
        System.out.println("Total Enrolled Students: " + totalStudents);
    }

    // Method to display student info
    void displayInfo() {
        System.out.println("University: " + universityName);
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Grade: " + grade);
        System.out.println("---------------------------");
    }

    // Method to update grade
    void updateGrade(String newGrade) {
        this.grade = newGrade;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for first student
        System.out.print("Enter student name: ");
        String name1 = sc.nextLine();

        System.out.print("Enter roll number: ");
        int roll1 = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter grade: ");
        String grade1 = sc.nextLine();

        Student s1 = new Student(name1, roll1, grade1);

        // Input for second student
        System.out.print("Enter second student name: ");
        String name2 = sc.nextLine();

        System.out.print("Enter roll number: ");
        int roll2 = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter grade: ");
        String grade2 = sc.nextLine();

        Student s2 = new Student(name2, roll2, grade2);

        // Update grade if object is a Student (using instanceof)
        if (s1 instanceof Student) {
            s1.updateGrade("A");
        }

        if (s2 instanceof Student) {
            s2.updateGrade("B+");
        }

        // Display total students
        Student.displayTotalStudents();

        // Display student details
        if (s1 instanceof Student) {
            s1.displayInfo();
        }

        if (s2 instanceof Student) {
            s2.displayInfo();
        }

        sc.close();
    }
}
