import java.util.Scanner;

public class SimpleGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("\nStudent " + i + ":");
            System.out.print("Enter Physics marks: ");
            int phy = sc.nextInt();
            System.out.print("Enter Chemistry marks: ");
            int chem = sc.nextInt();
            System.out.print("Enter Maths marks: ");
            int math = sc.nextInt();
            int total = phy + chem + math;
            double percent = total / 3.0;
            String grade;
            if (percent >= 80)
                grade = "A";
            else if (percent >= 70)
                grade = "B";
            else if (percent >= 60)
                grade = "C";
            else if (percent >= 50)
                grade = "D";
            else if (percent >= 40)
                grade = "E";
            else
                grade = "R";
            System.out.println("Total Marks = " + total);
            System.out.println("Percentage = " + percent + "%");
            System.out.println("Grade = " + grade);
        }
    }
}
