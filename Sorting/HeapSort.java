public class HeapSort {
    public static void main(String[] args) {
        int[] salaries = {55000, 42000, 75000, 31000, 60000, 48000};

        System.out.println("Original Salary Demands:");
        printArray(salaries);

        heapSort(salaries);

        System.out.println("\nSorted Salary Demands in Ascending Order:");
        printArray(salaries);
    }

    // Heap Sort function
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Step 1: Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Step 2: Extract elements one by one from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root (largest) to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // Heapify a subtree rooted at index i
    public static void heapify(int[] arr, int heapSize, int i) {
        int largest = i;         // Initialize largest as root
        int left = 2 * i + 1;    // Left child
        int right = 2 * i + 2;   // Right child

        // If left child is larger than root
        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected subtree
            heapify(arr, heapSize, largest);
        }
    }

    // Utility method to print array
    public static void printArray(int[] arr) {
        for (int salary : arr) {
            System.out.print(salary + " ");
        }
        System.out.println();
    }
}
