import java.io.*;

public class FileReaderExample {
    public static void main(String[] args) {
        try {
            // Create a FileReader wrapped in BufferedReader
            BufferedReader reader = new BufferedReader(new FileReader("data.txt"));

            String line;
            System.out.println("Contents of data.txt:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close(); // Always close resources
        } catch (IOException e) {
            // Handle the IOException (File not found or read error)
            System.out.println("File not found");
        }
    }
}
