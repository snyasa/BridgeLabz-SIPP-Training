
import java.util.*;

public class VotingCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] ages = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            ages[i] = rand.nextInt(91) + 10; 
        }
        System.out.println("\nStudent\tAge\tCan Vote?");
        for (int i = 0; i < n; i++) {
            boolean canVote = ages[i] >= 18;
            System.out.println((i+1) + "\t" + ages[i] + "\t" + (canVote ? "Yes" : "No"));
        }
    }
}
