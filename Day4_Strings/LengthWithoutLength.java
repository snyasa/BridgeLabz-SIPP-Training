import java.util.Scanner;

public class LengthWithoutLength {
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();

        int calculatedLength = findLength(input);
        System.out.println("Custom calculated length: " + calculatedLength);
        System.out.println("Built-in length: " + input.length());
    }
}
