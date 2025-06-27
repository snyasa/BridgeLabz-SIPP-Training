import java.util.ArrayList;

class Patient {
    private String name;
    private ArrayList<Doctor> consultedDoctors;

    public Patient(String name) {
        this.name = name;
        this.consultedDoctors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addDoctor(Doctor doctor) {
        if (!consultedDoctors.contains(doctor)) {
            consultedDoctors.add(doctor);
        }
    }

    public void viewConsultedDoctors() {
        System.out.println("Patient: " + name + " | Consulted Doctors:");
        for (Doctor doctor : consultedDoctors) {
            System.out.println(" - " + doctor.getName());
        }
    }
}
class Doctor {
    private String name;
    private String specialty;
    private ArrayList<Patient> patients;

    public Doctor(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
        this.patients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void consult(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
        }
        patient.addDoctor(this);  // maintain bidirectional association

        System.out.println("Consultation: Dr. " + name + " (Specialist in " + specialty + ") is consulting patient " + patient.getName());
    }

    public void viewPatients() {
        System.out.println("Doctor: " + name + " | Patients consulted:");
        for (Patient patient : patients) {
            System.out.println(" - " + patient.getName());
        }
    }
}
import java.util.ArrayList;

class Hospital {
    private String name;
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;

    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void showHospitalInfo() {
        System.out.println("Hospital: " + name);
        System.out.println("Doctors:");
        for (Doctor d : doctors) {
            System.out.println(" - " + d.getName());
        }
        System.out.println("Patients:");
        for (Patient p : patients) {
            System.out.println(" - " + p.getName());
        }
    }
}
