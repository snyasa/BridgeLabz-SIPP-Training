import java.util.Scanner;

public class CharArrayCompare {

    public static char[] getChars(String str) {
        char[] arr = new char[str.length()];
        for (int i = 0; i < str.length(); i++) arr[i] = str.charAt(i);
        return arr;
    }

    public static boolean compare(char[] a, char[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++)
            if (a[i] != b[i]) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        char[] userChars = getChars(text);
        char[] builtInChars = text.toCharArray();
        System.out.println("Match: " + compare(userChars, builtInChars));
    }
}
