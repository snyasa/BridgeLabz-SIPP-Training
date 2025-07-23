import java.util.*;

//  Abstract base class for course types
abstract class CourseType {
    private String title;
    private int credit;

    public CourseType(String title, int credit) {
        this.title = title;
        this.credit = credit;
    }

    public String getTitle() { return title; }

    public int getCredit() { return credit; }

    public abstract String getEvaluationType();

    @Override
    public String toString() {
        return getEvaluationType() + " Course: " + title + " (" + credit + " credits)";
    }
}

//  Concrete Course Types
class ExamCourse extends CourseType {
    public ExamCourse(String title, int credit) {
        super(title, credit);
    }

    @Override
    public String getEvaluationType() {
        return "Exam-Based";
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String title, int credit) {
        super(title, credit);
    }

    @Override
    public String getEvaluationType() {
        return "Assignment-Based";
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String title, int credit) {
        super(title, credit);
    }

    @Override
    public String getEvaluationType() {
        return "Research-Based";
    }
}

//  Generic Course Wrapper
class Course<T extends CourseType> {
    private String courseCode;
    private T type;

    public Course(String courseCode, T type) {
        this.courseCode = courseCode;
        this.type = type;
    }

    public String getCourseCode() { return courseCode; }

    public T getType() { return type; }

    @Override
    public String toString() {
        return "Course Code: " + courseCode + " | " + type.toString();
    }
}

//  Department Catalog - handles any type of course using wildcards
class DepartmentCatalog {
    private List<Course<? extends CourseType>> courseList = new ArrayList<>();

    public void addCourse(Course<? extends CourseType> course) {
        courseList.add(course);
    }

    public void showCourses() {
        for (Course<? extends CourseType> course : courseList) {
            System.out.println(course);
        }
    }
}

//  Main class to test the system
public class UniversityCourseSystem {
    public static void main(String[] args) {
        // Creating different types of courses
        Course<ExamCourse> math101 = new Course<>("MATH101", new ExamCourse("Calculus", 4));
        Course<AssignmentCourse> cs102 = new Course<>("CS102", new AssignmentCourse("Data Structures", 3));
        Course<ResearchCourse> ai501 = new Course<>("AI501", new ResearchCourse("AI Research", 5));

        // Creating department catalog
        DepartmentCatalog catalog = new DepartmentCatalog();
        catalog.addCourse(math101);
        catalog.addCourse(cs102);
        catalog.addCourse(ai501);

        // Display all courses
        System.out.println("=== University Course Catalog ===");
        catalog.showCourses();
    }
}
