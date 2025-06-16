import java.util.Scanner;
public class HandshakeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = input.nextInt();
        int handshakes = n * (n - 1) / 2;
        System.out.println("Maximum number of handshakes: " + handshakes);
    }
}