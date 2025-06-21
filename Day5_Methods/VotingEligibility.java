import java.util.Scanner;

public class VotingEligibility {
    public static boolean canVote(int age) {
        return age >= 18 && age > 0;
    }

    public static void checkVotes(int[] ages) {
        for (int i = 0; i < ages.length; i++) {
            if (ages[i] < 0) 
            System.out.println("Student " + (i + 1) + ": Invalid age");
            else 
           System.out.println("Student " + (i + 1) + (canVote(ages[i]) ? ": Can Vote" : ": Cannot Vote"));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            ages[i] = sc.nextInt();
        }
        checkVotes(ages);
    }
}
