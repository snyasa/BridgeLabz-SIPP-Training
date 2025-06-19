import java.util.Scanner;

public class TrimString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string with leading and trailing spaces: ");
        String input = sc.nextLine();

        int[] indexes = findTrimIndexes(input);
        String trimmedByCharAt = customSubstring(input, indexes[0], indexes[1]);

        // Using built-in trim() for comparison
        String trimmedByBuiltIn = input.trim();

        // Compare both trimmed strings
        boolean areEqual = compareStrings(trimmedByCharAt, trimmedByBuiltIn);

        System.out.println("\nTrimmed String using charAt(): \"" + trimmedByCharAt + "\"");
        System.out.println("Trimmed String using trim():    \"" + trimmedByBuiltIn + "\"");
        System.out.println("Both strings are equal: " + areEqual);
    }
    public static int[] findTrimIndexes(String str) {
        int start = 0;
        int end = -1;

        // Find start
        while (start < str.length() && str.charAt(start) == ' ') {
            start++;
        }
        end = str.length() - 1;
        while (end >= 0 && str.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }
    public static String customSubstring(String str, int start, int end) {
        String result = "";
        for (int i = start; i <= end; i++) {
            result += str.charAt(i);
        }
        return result;
    }
    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) return false;
        }
        return true;
    }
}
