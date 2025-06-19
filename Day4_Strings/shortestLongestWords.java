import java.util.Scanner;

public class shortestLongestWords {
    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
        }
        return count;
    }

    public static String[] splitWords(String text) {
        int len = getLength(text);
        String[] words = new String[100]; 
        String word = "";
        int index = 0;

        for (int i = 0; i < len; i++) {
            char ch = text.charAt(i);
            if (ch == ' ') {
                if (!word.equals("")) {
                    words[index++] = word;
                    word = "";
                }
            } else {
                word += ch;
            }
        }

        if (!word.equals("")) {
            words[index++] = word;
        }

        String[] result = new String[index];
        for (int i = 0; i < index; i++) {
            result[i] = words[i];
        }

        return result;
    }

    public static int[] findMinMaxWord(String[] words) {
        int min = getLength(words[0]);
        int max = min;
        for (int i = 1; i < words.length; i++) {
            int len = getLength(words[i]);
            if (len < min) min = len;
            if (len > max) max = len;
        }
        return new int[]{min, max};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String input = sc.nextLine();

        String[] words = splitWords(input);
        int[] result = findMinMaxWord(words);

        System.out.println("Shortest word length: " + result[0]);
        System.out.println("Longest word length: " + result[1]);
    }
}
