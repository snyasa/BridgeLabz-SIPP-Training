import java.util.*;

//  Abstract base class for Job Roles
abstract class JobRole {
    private String candidateName;

    public JobRole(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public abstract String getRoleName();

    public abstract List<String> getSkills();

    @Override
    public String toString() {
        return getRoleName() + " Applicant: " + candidateName + ", Skills: " + getSkills();
    }
}

//  Job Role Implementations
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName) {
        super(candidateName);
    }

    @Override
    public String getRoleName() {
        return "Software Engineer";
    }

    @Override
    public List<String> getSkills() {
        return Arrays.asList("Java", "Data Structures", "Algorithms", "Git");
    }
}

class DataScientist extends JobRole {
    public DataScientist(String candidateName) {
        super(candidateName);
    }

    @Override
    public String getRoleName() {
        return "Data Scientist";
    }

    @Override
    public List<String> getSkills() {
        return Arrays.asList("Python", "Machine Learning", "Statistics", "SQL");
    }
}

class ProductManager extends JobRole {
    public ProductManager(String candidateName) {
        super(candidateName);
    }

    @Override
    public String getRoleName() {
        return "Product Manager";
    }

    @Override
    public List<String> getSkills() {
        return Arrays.asList("Communication", "Agile", "Roadmapping", "Team Leadership");
    }
}

//  Resume class with bounded type parameter
class Resume<T extends JobRole> {
    private T jobRole;

    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    public T getJobRole() {
        return jobRole;
    }

    public void display() {
        System.out.println(jobRole);
    }
}

//  Screening utility with wildcard method
class ResumeScreeningUtil {

    // Generic method to screen individual resume
    public static <T extends JobRole> void screenResume(Resume<T> resume) {
        System.out.println("Screening Resume for " + resume.getJobRole().getRoleName());
        System.out.println("Candidate: " + resume.getJobRole().getCandidateName());
        System.out.println("Skills: " + resume.getJobRole().getSkills());
        System.out.println("Status:  Passed Basic Screening\n");
    }

    // Wildcard method to process list of resumes
    public static void bulkScreen(List<? extends JobRole> applicants) {
        for (JobRole role : applicants) {
            System.out.println("📄 " + role);
        }
    }
}

//  Main class to test everything
public class ResumeScreeningSystem {
    public static void main(String[] args) {
        // Individual resumes
        Resume<SoftwareEngineer> seResume = new Resume<>(new SoftwareEngineer("Alice"));
        Resume<DataScientist> dsResume = new Resume<>(new DataScientist("Bob"));
        Resume<ProductManager> pmResume = new Resume<>(new ProductManager("Carol"));

        System.out.println("=== Individual Resume Screening ===\n");
        ResumeScreeningUtil.screenResume(seResume);
        ResumeScreeningUtil.screenResume(dsResume);
        ResumeScreeningUtil.screenResume(pmResume);

        // Bulk Screening
        List<JobRole> applicantList = Arrays.asList(
                new SoftwareEngineer("David"),
                new DataScientist("Eva"),
                new ProductManager("Frank")
        );

        System.out.println("=== Bulk Resume Overview ===\n");
        ResumeScreeningUtil.bulkScreen(applicantList);
    }
}
