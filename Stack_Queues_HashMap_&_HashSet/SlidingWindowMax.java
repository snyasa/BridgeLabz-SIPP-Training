import java.util.*;

class SlidingWindowMax {

    public List<Integer> maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {

            // Remove out-of-window indices
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // Remove smaller elements
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offer(i);

            // Add max for window
            if (i >= k - 1) {
                result.add(nums[deque.peek()]);
            }
        }

        return result;
    }
}
