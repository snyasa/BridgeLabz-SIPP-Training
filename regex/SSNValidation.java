public class SSNValidation {
    public static void main(String[] args) {
        String[] ssns = {
            "123-45-6789",   // Valid
            "123456789",     // Invalid (missing dashes)
            "12-345-6789",   // Invalid (wrong grouping)
            "123-45-678"     // Invalid (too short)
        };

        String regex = "^\\d{3}-\\d{2}-\\d{4}$";

        for (String ssn : ssns) {
            if (ssn.matches(regex)) {
                System.out.println(ssn + " → Valid");
            } else {
                System.out.println(ssn + " → Invalid");
            }
        }
    }
}
