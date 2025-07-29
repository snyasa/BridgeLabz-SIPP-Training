import java.util.*;

public class RotateList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        int rotateBy = 2;

        rotateList(list, rotateBy);
        System.out.println("Rotated List: " + list);
    }

    public static void rotateList(List<Integer> list, int k) {
        int n = list.size();
        k = k % n; // In case k > n

        if (k == 0) return;

        List<Integer> rotated = new ArrayList<>();
        rotated.addAll(list.subList(k, n));
        rotated.addAll(list.subList(0, k));

        list.clear();
        list.addAll(rotated);
    }
}
