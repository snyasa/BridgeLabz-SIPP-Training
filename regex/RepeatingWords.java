import java.util.regex.*;
import java.util.*;

public class RepeatingWords {
    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";
        String regex = "\\b(\\w+)\\b\\s+\\1\\b";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        Set<String> repeated = new HashSet<>();

        while (matcher.find()) {
            repeated.add(matcher.group(1)); // group(1) is the actual word
        }

        System.out.println("Repeating Words:");
        for (String word : repeated) {
            System.out.println(word);
        }
    }
}
