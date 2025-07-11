public class CountingSort {
    public static void main(String[] args) {
        int[] ages = {12, 18, 11, 13, 15, 10, 12, 14, 17, 11};

        System.out.println("Original Student Ages:");
        printArray(ages);

        int[] sortedAges = countingSort(ages, 10, 18);

        System.out.println("\nSorted Student Ages in Ascending Order:");
        printArray(sortedAges);
    }

    // Counting Sort method for range 10 to 18
    public static int[] countingSort(int[] arr, int min, int max) {
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[arr.length];

        // Step 1: Count frequency of each age
        for (int age : arr) {
            count[age - min]++;
        }

        // Step 2: Compute cumulative frequency
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Step 3: Place elements in correct position (stable sort - from end)
        for (int i = arr.length - 1; i >= 0; i--) {
            int age = arr[i];
            output[count[age - min] - 1] = age;
            count[age - min]--;
        }

        return output;
    }

    // Utility method to print array
    public static void printArray(int[] arr) {
        for (int age : arr) {
            System.out.print(age + " ");
        }
        System.out.println();
    }
}
