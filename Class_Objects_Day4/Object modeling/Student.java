import java.util.ArrayList;

class Student {
    private String name;
    private ArrayList<Course> enrolledCourses;

    public Student(String name) {
        this.name = name;
        enrolledCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // Method to enroll in a course
    public void enrollCourse(Course course) {
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            course.addStudent(this);  // Maintain bidirectional relationship
            System.out.println(name + " enrolled in course: " + course.getCourseName());
        }
    }

    public void viewCourses() {
        System.out.println("Student: " + name + " | Enrolled Courses:");
        for (Course c : enrolledCourses) {
            System.out.println(" - " + c.getCourseName());
        }
    }
}
class Professor {
    private String name;
    private ArrayList<Course> teachingCourses;

    public Professor(String name) {
        this.name = name;
        teachingCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // Assign professor to a course
    public void assignCourse(Course course) {
        if (!teachingCourses.contains(course)) {
            teachingCourses.add(course);
            course.setProfessor(this);
            System.out.println(name + " is now teaching course: " + course.getCourseName());
        }
    }

    public void viewTeachingCourses() {
        System.out.println("Professor: " + name + " | Teaching Courses:");
        for (Course c : teachingCourses) {
            System.out.println(" - " + c.getCourseName());
        }
    }
}
class Course {
    private String courseName;
    private Professor professor; // Aggregation: one professor per course
    private ArrayList<Student> students; // Aggregation: many students

    public Course(String name) {
        this.courseName = name;
        this.students = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void viewDetails() {
        System.out.println("Course: " + courseName);
        System.out.println("Taught by: " + (professor != null ? professor.getName() : "No professor assigned"));
        System.out.println("Enrolled students:");
        for (Student s : students) {
            System.out.println(" - " + s.getName());
        }
    }
}
