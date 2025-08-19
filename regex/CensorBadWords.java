import java.util.regex.*;

public class CensorBadWords {
    public static void main(String[] args) {
        String text = "This is a damn bad example with some stupid words.";
        String[] badWords = {"damn", "stupid"}; // List of bad words

        for (String word : badWords) {
            // Regex with word boundaries (\b) to match whole words only
            String regex = "\\b" + Pattern.quote(word) + "\\b";
            text = text.replaceAll(regex, "****");
        }

        System.out.println("Censored Sentence:");
        System.out.println(text);
    }
}
