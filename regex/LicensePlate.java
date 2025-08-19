public class LicensePlate {
    public static void main(String[] args) {
        String[] plates = {"AB1234", "A12345", "XY9876", "abc1234", "AB12C4"};
        String regex = "^[A-Z]{2}[0-9]{4}$";

        for (String plate : plates) {
            if (plate.matches(regex)) {
                System.out.println(plate + " → Valid");
            } else {
                System.out.println(plate + " → Invalid");
            }
        }
    }
}
