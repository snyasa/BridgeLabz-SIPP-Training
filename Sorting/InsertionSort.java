public class InsertionSort {
    public static void main(String[] args) {
        int[] empIDs = {1034, 1011, 1056, 1002, 1020};

        System.out.println("Original Employee IDs:");
        printArray(empIDs);

        insertionSort(empIDs);

        System.out.println("\nSorted Employee IDs in Ascending Order:");
        printArray(empIDs);
    }

    // Insertion Sort Method
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i]; // Element to insert
            int j = i - 1;

            // Move elements of arr[0..i-1] that are greater than key
            // one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Insert key at correct position
            arr[j + 1] = key;
        }
    }

    // Utility method to print array
    public static void printArray(int[] arr) {
        for (int id : arr) {
            System.out.print(id + " ");
        }
        System.out.println();
    }
}
