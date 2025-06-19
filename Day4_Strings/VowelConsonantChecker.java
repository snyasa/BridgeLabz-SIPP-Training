import java.util.Scanner;

public class VowelConsonantChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String[][] result = findCharacterTypes(input);
        displayTable(result);
    }
    public static String checkCharacterType(char ch) {
        ch = Character.toLowerCase(ch); // convert to lowercase

        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        } else {
            return "Not a Letter";
        }
    }
    public static String[][] findCharacterTypes(String str) {
        int len = str.length();
        String[][] result = new String[len][2];

        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = checkCharacterType(ch);
        }

        return result;
    }
    public static void displayTable(String[][] arr) {
        System.out.printf("\n%-10s %-15s\n", "Character", "Type");
        System.out.println("----------------------------");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%-10s %-15s\n", arr[i][0], arr[i][1]);
        }
    }
}
