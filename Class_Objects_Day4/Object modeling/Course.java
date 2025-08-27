import java.util.ArrayList;

// Course class
class Course {
    private String courseName;
    private ArrayList<Student> enrolledStudents;

    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void enrollStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
        }
    }

    public void displayEnrolledStudents() {
        System.out.println("Course: " + courseName + " | Enrolled Students:");
        for (Student student : enrolledStudents) {
            System.out.println(" - " + student.getName());
        }
    }
}
// Student class
class Student {
    private String name;
    private ArrayList<Course> enrolledCourses;

    public Student(String name) {
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollInCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            course.enrollStudent(this); // Maintain bidirectional association
        }
    }

    public void viewEnrolledCourses() {
        System.out.println("Student: " + name + " | Enrolled Courses:");
        for (Course course : enrolledCourses) {
            System.out.println(" - " + course.getCourseName());
        }
    }
}
// School class
class School {
    private String schoolName;
    private ArrayList<Student> students;

    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student); // Aggregation: school has students
    }

    public void displayAllStudents() {
        System.out.println("School: " + schoolName + " | Students:");
        for (Student student : students) {
            System.out.println(" - " + student.getName());
        }
    }
}
