import java.util.*;

class ZeroSumSubarrays {

    public List<int[]> findSubarrays(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<int[]> result = new ArrayList<>();
        int sum = 0;
        map.put(0, new ArrayList<>(List.of(-1)));  // To handle subarrays starting at index 0

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (map.containsKey(sum)) {
                for (int start : map.get(sum)) {
                    result.add(new int[]{start + 1, i});
                }
            }

            map.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }

        return result;
    }
}
