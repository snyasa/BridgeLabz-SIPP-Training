import java.util.*;

public class GenerateBinaryNumbers {
    public static void main(String[] args) {
        int N = 5;
        List<String> result = generateBinary(N);
        System.out.println("Binary Numbers: " + result);
    }

    public static List<String> generateBinary(int n) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("1");

        for (int i = 0; i < n; i++) {
            String current = queue.remove();
            result.add(current);
            queue.add(current + "0");
            queue.add(current + "1");
        }

        return result;
    }
}
