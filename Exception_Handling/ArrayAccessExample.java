import java.util.Scanner;

public class ArrayAccessExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Uncomment the below line to simulate a null array
        // int[] arr = null;

        // Comment the below line to simulate a null array
        int[] arr = {10, 20, 30, 40, 50};

        try {
            System.out.print("Enter the index to retrieve: ");
            int index = scanner.nextInt();

            // Try to access the element at the given index
            int value = arr[index];
            System.out.println("Value at index " + index + ": " + value);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");

        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");

        } finally {
            scanner.close();
        }
    }
}
