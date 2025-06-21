import java.util.*;

public class RandomStats {
    public static int[] generateRandom4DigitNumbers(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = 1000 + (int)(Math.random() * 9000);
        return arr;
    }
    public static void printStats(int[] arr) {
        int sum = 0, min = arr[0], max = arr[0];
        for (int num : arr) {
            sum += num;
            if (num < min) min = num;
            if (num > max) max = num;
        }
        double avg = sum / (double)arr.length;
        System.out.println("Numbers: " + Arrays.toString(arr));
        System.out.println("Average: " + avg + ", Min: " + min + ", Max: " + max);
    }
    public static void main(String[] args) {
        int[] arr = generateRandom4DigitNumbers(5);
        printStats(arr);
    }
}
