public class QuickSort {
    public static void main(String[] args) {
        int[] prices = {799, 299, 1099, 149, 499, 650};

        System.out.println("Original Product Prices:");
        printArray(prices);

        quickSort(prices, 0, prices.length - 1);

        System.out.println("\nSorted Product Prices in Ascending Order:");
        printArray(prices);
    }

    // Quick Sort method
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pi = partition(arr, low, high);

            // Recursively sort the left and right parts
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Partition method (using last element as pivot)
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Pivot element
        int i = low - 1; // Index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than pivot
            if (arr[j] < pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot in the correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // Return the partition index
    }

    // Utility method to print array
    public static void printArray(int[] arr) {
        for (int price : arr) {
            System.out.print(price + " ");
        }
        System.out.println();
    }
}
