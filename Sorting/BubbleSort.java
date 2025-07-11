public class BubbleSort {
    public static void main(String[] args) {
        int[] marks = {75, 50, 90, 60, 85, 40};

        System.out.println("Original Marks:");
        printArray(marks);

        bubbleSort(marks);

        System.out.println("\nSorted Marks in Ascending Order:");
        printArray(marks);
    }

    // Bubble Sort Method
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        // Outer loop for passes
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Inner loop for comparisons
            for (int j = 0; j < n - 1 - i; j++) {
                // Swap if adjacent elements are in the wrong order
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            // If no swaps in a pass, array is already sorted
            if (!swapped)
                break;
        }
    }

    // Utility method to print array
    public static void printArray(int[] arr) {
        for (int mark : arr) {
            System.out.print(mark + " ");
        }
        System.out.println();
    }
}
