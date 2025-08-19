public class ReplaceSpaces {
    public static void main(String[] args) {
        String text = "This   is   an   example   with    multiple    spaces.";
        
        // Replace multiple spaces with a single space
        String cleaned = text.replaceAll("\\s+", " ");
        
        System.out.println("Original: " + text);
        System.out.println("Cleaned: " + cleaned);
    }
}
