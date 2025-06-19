import java.util.Scanner;

public class SplitCompare {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();
        String[] builtInSplit = input.split(" ");
        String[] manualSplit = manualWordSplit(input);
        boolean isEqual = compareArrays(builtInSplit, manualSplit);
        System.out.println("\nManual Split Result:");
        for (String word : manualSplit) {
            System.out.println(word);
        }

        System.out.println("\nBuilt-in Split Result:");
        for (String word : builtInSplit) {
            System.out.println(word);
        }

        System.out.println("\nAre both results same? " + (isEqual ? "Yes" : "No"));
    }
    public static String[] manualWordSplit(String str) {
        String[] temp = new String[100]; // Assume max 100 words
        int index = 0;
        String currentWord = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch != ' ') {
                currentWord += ch;
            } else if (!currentWord.equals("")) {
                temp[index++] = currentWord;
                currentWord = "";
            }
        }
        if (!currentWord.equals("")) {
            temp[index++] = currentWord;
        }

        // Copy to final array with exact size
        String[] words = new String[index];
        for (int i = 0; i < index; i++) {
            words[i] = temp[i];
        }
        return words;
    }
    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) return false;

        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) return false;
        }

        return true;
    }
}
