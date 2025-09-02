import java.text.SimpleDateFormat;
import java.util.Date;

interface DateFormatter {
    static String formatDate(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }
}

public class InvoiceDateFormatter {
    public static void main(String[] args) {
        Date today = new Date();
        System.out.println("Default date: " + today);

        String formatted1 = DateFormatter.formatDate(today, "dd-MM-yyyy");
        String formatted2 = DateFormatter.formatDate(today, "yyyy/MM/dd HH:mm");

        System.out.println("Formatted (dd-MM-yyyy): " + formatted1);
        System.out.println("Formatted (yyyy/MM/dd HH:mm): " + formatted2);
    }
}
