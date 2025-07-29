import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 1, 2, 2, 3, 4);

        List<Integer> result = removeDuplicates(list);
        System.out.println("List without duplicates: " + result);
    }

    public static List<Integer> removeDuplicates(List<Integer> list) {
        Set<Integer> seen = new LinkedHashSet<>();
        for (Integer num : list) {
            seen.add(num);
        }
        return new ArrayList<>(seen);
    }
}
