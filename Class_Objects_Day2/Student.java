class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    // Constructor
    Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    // Public getter
    public double getCGPA() {
        return CGPA;
    }

    // Public setter
    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }
}

// Subclass demonstrating use of protected member
class PostgraduateStudent extends Student {
    String thesisTitle;

    PostgraduateStudent(int rollNumber, String name, double CGPA, String thesisTitle) {
        super(rollNumber, name, CGPA);
        this.thesisTitle = thesisTitle;
    }

    void displayDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name (protected): " + name); // Accessing protected member
        System.out.println("CGPA: " + getCGPA());
        System.out.println("Thesis: " + thesisTitle);
    }
}
