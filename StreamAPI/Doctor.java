import java.util.*;
import java.util.stream.*;

class Doctor {
    String name;
    String specialty;
    boolean availableOnWeekend;

    public Doctor(String name, String specialty, boolean availableOnWeekend) {
        this.name = name;
        this.specialty = specialty;
        this.availableOnWeekend = availableOnWeekend;
    }

    @Override
    public String toString() {
        return name + " - " + specialty + " (Weekend: " + (availableOnWeekend ? "Yes" : "No") + ")";
    }
}

public class HospitalDoctorAvailability {
    public static void main(String[] args) {
        List<Doctor> doctors = Arrays.asList(
                new Doctor("Dr. Sharma", "Cardiologist", true),
                new Doctor("Dr. Mehta", "Neurologist", false),
                new Doctor("Dr. Kapoor", "Orthopedic", true),
                new Doctor("Dr. Singh", "Dermatologist", true),
                new Doctor("Dr. Patel", "Pediatrician", false),
                new Doctor("Dr. Iyer", "Oncologist", true)
        );

        List<Doctor> weekendDoctors = doctors.stream()
                .filter(d -> d.availableOnWeekend) // Only those available on weekends
                .sorted(Comparator.comparing(d -> d.specialty)) // Sort by specialty (alphabetically)
                .collect(Collectors.toList());

        System.out.println("Doctors available on weekends (sorted by specialty):");
        weekendDoctors.forEach(System.out::println);
    }
}
