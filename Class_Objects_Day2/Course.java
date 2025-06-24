class Course {
    String courseName;
    int duration; // in weeks or months
    double fee;
    static String instituteName = "Default Institute";

    // Constructor
    Course(String name, int duration, double fee) {
        this.courseName = name;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method
    void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
        System.out.println("Fee: ₹" + fee);
        System.out.println("Institute: " + instituteName);
    }

    // Class method
    static void updateInstituteName(String newName) {
        instituteName = newName;
    }
}
