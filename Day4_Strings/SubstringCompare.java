import java.util.Scanner;

public class SubstringCompare {

    public static String createSubstring(String str, int start, int end) {
        String sub = "";
        for (int i = start; i < end && i < str.length(); i++) sub += str.charAt(i);
        return sub;
    }

    public static boolean compare(String s1, String s2) {
        return s1.equals(s2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        int start = sc.nextInt();
        int end = sc.nextInt();
        String userSub = createSubstring(text, start, end);
        String builtInSub = text.substring(start, end);
        System.out.println("Match: " + compare(userSub, builtInSub));
    }
}
