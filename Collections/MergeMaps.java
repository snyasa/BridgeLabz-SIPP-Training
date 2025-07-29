import java.util.*;

public class MergeMaps {
    public static void main(String[] args) {
        HashMap<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        HashMap<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        HashMap<String, Integer> result = new HashMap<>();

        for (String key : map1.keySet()) {
            result.put(key, map1.get(key));
        }

        for (String key : map2.keySet()) {
            if (result.containsKey(key)) {
                result.put(key, result.get(key) + map2.get(key));
            } else {
                result.put(key, map2.get(key));
            }
        }

        System.out.println(result);
    }
}
