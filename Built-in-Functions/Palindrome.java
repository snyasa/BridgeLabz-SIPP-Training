import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        String input = getInput();
        boolean isPalin = isPalindrome(input);
        displayResult(input, isPalin);
    }

    public static String getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to check for palindrome: ");
        return scanner.nextLine();
    }

    public static boolean isPalindrome(String str) {
        str = str.replaceAll("\\s+", "").toLowerCase(); 
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) return false;
        }
        return true;
    }

    public static void displayResult(String input, boolean result) {
        if (result)
            System.out.println("\"" + input + "\" is a palindrome.");
        else
            System.out.println("\"" + input + "\" is NOT a palindrome.");
    }
}
