import java.util.*;


interface Payment {
    void pay(double amount);
}


class UPI implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI");
    }
}


class CreditCard implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card");
    }
}


class Wallet implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Wallet");
    }
}


public class DigitalPaymentSystem {
    public static void main(String[] args) {
        List<Payment> payments = new ArrayList<>();
        payments.add(new UPI());
        payments.add(new CreditCard());
        payments.add(new Wallet());

        double amount = 500.0;

        System.out.println("--- Processing Payments ---");
        for (Payment p : payments) {
            p.pay(amount);
        }
    }
}
