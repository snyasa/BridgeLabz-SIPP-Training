import java.util.regex.*;
import java.util.*;

public class Language {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        String regex = "\\b(Java|Python|JavaScript|C\\+\\+|C#|Go|Ruby|PHP|Swift|Kotlin|Rust|TypeScript)\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        List<String> languages = new ArrayList<>();

        while (matcher.find()) {
            languages.add(matcher.group());
        }

        System.out.println("Extracted Programming Languages:");
        for (String lang : languages) {
            System.out.println(lang);
        }
    }
}
