import java.util.*;

public class PatientIDPrinting {
    public static void main(String[] args) {

        List<String> patientIDs = Arrays.asList(
                "PAT1001",
                "PAT1002",
                "PAT1003",
                "PAT1004",
                "PAT1005"
        );

        System.out.println("Patient IDs for Admin Verification:");
        
        // Using method reference instead of lambda
        patientIDs.forEach(System.out::println);
    }
}
