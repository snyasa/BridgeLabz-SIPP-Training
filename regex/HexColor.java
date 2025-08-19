public class HexColor {
    public static void main(String[] args) {
        String[] colors = {"#FFA500", "#ff4500", "#123", "FFA500", "#12FG34"};
        String regex = "^#[A-Fa-f0-9]{6}$";

        for (String color : colors) {
            if (color.matches(regex)) {
                System.out.println(color + " → Valid");
            } else {
                System.out.println(color + " → Invalid");
            }
        }
    }
}
