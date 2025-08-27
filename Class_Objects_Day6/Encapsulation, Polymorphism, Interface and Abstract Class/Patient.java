interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}
abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public String getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }

    public void getPatientDetails() {
        System.out.println("ID: " + patientId + ", Name: " + name + ", Age: " + age);
    }

    public abstract double calculateBill();
}
class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyCharge;

    private String[] records = new String[5]; // fixed-size record storage
    private int recordCount = 0;

    public InPatient(String patientId, String name, int age, int daysAdmitted, double dailyCharge) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyCharge = dailyCharge;
    }

    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    public void addRecord(String record) {
        if (recordCount < records.length) {
            records[recordCount++] = record;
        } else {
            System.out.println("Medical record storage full!");
        }
    }

    public void viewRecords() {
        System.out.println("Medical Records:");
        for (int i = 0; i < recordCount; i++) {
            System.out.println("- " + records[i]);
        }
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;

    private String[] records = new String[5]; // fixed-size record storage
    private int recordCount = 0;

    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }

    public double calculateBill() {
        return consultationFee;
    }

    public void addRecord(String record) {
        if (recordCount < records.length) {
            records[recordCount++] = record;
        } else {
            System.out.println("Medical record storage full!");
        }
    }

    public void viewRecords() {
        System.out.println("Medical Records:");
        for (int i = 0; i < recordCount; i++) {
            System.out.println("- " + records[i]);
        }
    }
}
public class HospitalSystem {
    public static void main(String[] args) {
        Patient p1 = new InPatient("P001", "Alice", 30, 5, 1500);
        Patient p2 = new OutPatient("P002", "Bob", 40, 500);

        ((MedicalRecord) p1).addRecord("Appendicitis surgery completed.");
        ((MedicalRecord) p1).addRecord("3-day ICU stay.");

        ((MedicalRecord) p2).addRecord("Routine health checkup.");

        Patient[] patients = { p1, p2 };

        for (Patient p : patients) {
            p.getPatientDetails();
            System.out.println("Bill: ₹" + p.calculateBill());

            if (p instanceof MedicalRecord) {
                ((MedicalRecord) p).viewRecords();
            }
        }
    }
}
