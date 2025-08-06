import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Resources {
    public static void main(String[] args) {
        // try-with-resources: ensures the resource is closed automatically
        try (BufferedReader reader = new BufferedReader(new FileReader("info.txt"))) {
            String firstLine = reader.readLine(); // Read the first line
            System.out.println("First line: " + firstLine);

        } catch (IOException e) {
            // Handle file not found or other IO errors
            System.out.println("Error reading file");
        }
    }
}
