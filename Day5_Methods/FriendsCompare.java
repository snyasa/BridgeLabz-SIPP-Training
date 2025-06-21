import java.util.Scanner;

public class FriendsCompare {
    public static int findYoungest(int[] ages) {
        int index = 0;
        for (int i = 1; i < ages.length; i++)
            if (ages[i] < ages[index]) index = i;
        return index;
    }
    public static int findTallest(int[] heights) {
        int index = 0;
        for (int i = 1; i < heights.length; i++)
            if (heights[i] > heights[index]) index = i;
        return index;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3], heights = new int[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age and height of " + names[i] + ": ");
            ages[i] = sc.nextInt();
            heights[i] = sc.nextInt();
        }
        System.out.println("Youngest: " + names[findYoungest(ages)]);
        System.out.println("Tallest: " + names[findTallest(heights)]);
    }
}
