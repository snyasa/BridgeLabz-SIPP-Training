import java.util.Random;
import java.util.Scanner;

public class StudentScoreCard {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] marks = generateMarks(n);
        double[][] results = calculateResults(marks);
        String[] grades = calculateGrades(results);
        displayScoreCard(marks, results, grades);
    }

      public static int[][] generateMarks(int n) {
        Random rand = new Random();
        int[][] marks = new int[n][3]; 
        for (int i = 0; i < n; i++) {
            marks[i][0] = rand.nextInt(60) + 40; 
            marks[i][1] = rand.nextInt(60) + 40; 
            marks[i][2] = rand.nextInt(60) + 40; 
        }
        return marks;
    }
    public static double[][] calculateResults(int[][] marks) {
        double[][] result = new double[marks.length][3]; 
        for (int i = 0; i < marks.length; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            result[i][0] = total;
            result[i][1] = Math.round(average * 100.0) / 100.0;
            result[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return result;
    }
    public static String[] calculateGrades(double[][] result) {
        String[] grades = new String[result.length];
        for (int i = 0; i < result.length; i++) {
            double percent = result[i][2];
            if (percent >= 90)
                grades[i] = "A+";
            else if (percent >= 80)
                grades[i] = "A";
            else if (percent >= 70)
                grades[i] = "B";
            else if (percent >= 60)
                grades[i] = "C";
            else if (percent >= 50)
                grades[i] = "D";
            else
                grades[i] = "F";
        }
        return grades;
    }
    public static void displayScoreCard(int[][] marks, double[][] result, String[] grades) {
        System.out.printf("\n%-10s %-10s %-10s %-10s %-10s %-10s %-12s %-8s\n",
                "Student", "Physics", "Chemistry", "Math", "Total", "Average", "Percentage", "Grade");
        for (int i = 0; i < marks.length; i++) {
            System.out.printf("%-10d %-10d %-10d %-10d %-10.0f %-10.2f %-12.2f %-8s\n",
                    i + 1, marks[i][0], marks[i][1], marks[i][2],
                    result[i][0], result[i][1], result[i][2], grades[i]);
        }
    }
}
