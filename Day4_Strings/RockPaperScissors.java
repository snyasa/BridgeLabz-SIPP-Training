import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int userWins = 0;
        int computerWins = 0;

        System.out.print("How many rounds do you want to play? ");
        int rounds = sc.nextInt();
        sc.nextLine(); 

        for (int i = 1; i <= rounds; i++) {
            System.out.println("\nRound " + i);
            System.out.print("Enter your choice (rock/paper/scissors): ");
            String user = sc.nextLine().toLowerCase();

            String computer = getComputerChoice();
            System.out.println("Computer chose: " + computer);

            String result = getWinner(user, computer);

            if (result.equals("user")) {
                System.out.println("You win this round!");
                userWins++;
            } else if (result.equals("computer")) {
                System.out.println("Computer wins this round!");
                computerWins++;
            } else {
                System.out.println("It's a draw!");
            }
        }
        System.out.println("\nGame Over!");
        System.out.println("You won: " + userWins + " time(s)");
        System.out.println("Computer won: " + computerWins + " time(s)");
        System.out.println("Draws: " + (rounds - userWins - computerWins));

        double userPercent = (userWins * 100.0) / rounds;
        double compPercent = (computerWins * 100.0) / rounds;

        System.out.println("\nYour Win Percentage: " + String.format("%.2f", userPercent) + "%");
        System.out.println("Computer Win Percentage: " + String.format("%.2f", compPercent) + "%");
    }
    public static String getComputerChoice() {
        int random = (int) (Math.random() * 3); // 0 to 2
        if (random == 0) return "rock";
        else if (random == 1) return "paper";
        else return "scissors";
    }
    public static String getWinner(String user, String computer) {
        if (user.equals(computer)) return "draw";
        if ((user.equals("rock") && computer.equals("scissors")) ||
            (user.equals("paper") && computer.equals("rock")) ||
            (user.equals("scissors") && computer.equals("paper"))) {
            return "user";
        } else {
            return "computer";
        }
    }
}
