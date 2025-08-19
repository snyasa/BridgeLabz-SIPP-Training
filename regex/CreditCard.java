public class CreditCard {
    public static void main(String[] args) {
        String[] cards = {
            "4123456789012345", // Visa - Valid
            "5123456789012345", // MasterCard - Valid
            "6123456789012345", // Invalid (starts with 6)
            "41234567890123",   // Invalid (too short)
            "51234567890123456" // Invalid (too long)
        };

        String regex = "^(4[0-9]{15}|5[0-9]{15})$";

        for (String card : cards) {
            if (card.matches(regex)) {
                System.out.println(card + " → Valid");
            } else {
                System.out.println(card + " → Invalid");
            }
        }
    }
}
