import java.util.*;
import java.util.stream.*;

class InsuranceClaim {
    String claimType;
    double claimAmount;

    public InsuranceClaim(String claimType, double claimAmount) {
        this.claimType = claimType;
        this.claimAmount = claimAmount;
    }
}

public class InsuranceClaimAnalysis {
    public static void main(String[] args) {
        List<InsuranceClaim> claims = Arrays.asList(
                new InsuranceClaim("Health", 25000),
                new InsuranceClaim("Health", 40000),
                new InsuranceClaim("Vehicle", 15000),
                new InsuranceClaim("Vehicle", 20000),
                new InsuranceClaim("Property", 50000),
                new InsuranceClaim("Property", 60000),
                new InsuranceClaim("Health", 30000)
        );
        Map<String, Double> avgClaimAmount = claims.stream()
                .collect(Collectors.groupingBy(
                        c -> c.claimType,
                        Collectors.averagingDouble(c -> c.claimAmount)
                ));

        
        System.out.println("Average Claim Amount by Claim Type:");
        avgClaimAmount.forEach((type, avg) -> 
                System.out.println(type + " → " + avg));
    }
}
