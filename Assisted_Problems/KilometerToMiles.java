import java.util.*;

class KilometerToMiles {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        double km = sc.nextDouble();

        double miles = km * 0.621371;
        System.out.println("Distance in miles: " + miles);
    }
}
