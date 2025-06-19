import java.util.Scanner;

public class WordLength2DArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();
        String[] words = splitWords(input);
        String[][] wordLengthArray = getWordLengthArray(words);
        System.out.println("\nWord\t\tLength");
        System.out.println("-----------------------");
        for (int i = 0; i < wordLengthArray.length; i++) {
            System.out.println(wordLengthArray[i][0] + "\t\t" + wordLengthArray[i][1]);
        }
    }
    public static String[] splitWords(String text) {
        String word = "";
        String[] temp = new String[100]; 
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch != ' ') {
                word += ch;
            } else {
                if (!word.equals("")) {
                    temp[count++] = word;
                    word = "";
                }
            }
        }
        if (!word.equals("")) {
            temp[count++] = word;
        }
        String[] result = new String[count];
        for (int i = 0; i < count; i++) {
            result[i] = temp[i];
        }
        return result;
    }
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
    public static String[][] getWordLengthArray(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }
        return result;
    }
}
