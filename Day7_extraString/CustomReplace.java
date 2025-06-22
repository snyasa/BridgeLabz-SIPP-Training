public class CustomReplace {
    public static void main(String[] args) {
        String str = "banana";
        char oldChar = 'a';
        char newChar = 'o';

        String result = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == oldChar)
                result += newChar;
            else
                result += ch;
        }

        System.out.println("Original String: " + str);
        System.out.println("Modified String: " + result);
    }
}
