public class SelectionSort {
    public static void main(String[] args) {
        int[] scores = {88, 73, 95, 60, 85, 77};

        System.out.println("Original Exam Scores:");
        printArray(scores);

        selectionSort(scores);

        System.out.println("\nSorted Exam Scores in Ascending Order:");
        printArray(scores);
    }

    // Selection Sort Method
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // Traverse through all array elements
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find the minimum element in the remaining unsorted array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Utility method to print array
    public static void printArray(int[] arr) {
        for (int score : arr) {
            System.out.print(score + " ");
        }
        System.out.println();
    }
}
