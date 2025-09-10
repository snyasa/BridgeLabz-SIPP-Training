import java.util.*;
import java.util.stream.Collectors;
import java.util.IntSummaryStatistics;

public class BookSummary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String[]> books = new ArrayList<>();

        System.out.print("Enter number of books: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter title: ");
            String title = sc.nextLine();

            System.out.print("Enter genre: ");
            String genre = sc.nextLine();

            System.out.print("Enter pages: ");
            int pages = sc.nextInt();
            sc.nextLine();

            books.add(new String[]{title, genre, String.valueOf(pages)});
        }

        
        Map<String, IntSummaryStatistics> summary =
            books.stream().collect(Collectors.groupingBy(
                b -> b[1], 
                Collectors.summarizingInt(b -> Integer.parseInt(b[2]))
            ));

        
        System.out.println("\n--- Summary by Genre ---");
        summary.forEach((genre, stats) -> {
            System.out.println("Genre: " + genre);
            System.out.println("  Total Pages: " + stats.getSum());
            System.out.println("  Average Pages: " + stats.getAverage());
            System.out.println("  Max Pages: " + stats.getMax());
        });
    }
}
