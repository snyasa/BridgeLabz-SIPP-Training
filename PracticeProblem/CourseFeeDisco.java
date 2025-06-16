Solution:public class CourseFeeDiscount {
    public static void main(String[] args) {
        double courseFee = 125000;
        double discountRate = 10; 
        double discountAmount = (discountRate / 100) * courseFee;
        double finalPrice = courseFee - discountAmount;
        System.out.println("The discount amount is INR " + discountAmount);
        System.out.println("The discounted price the student will pay is INR " + finalPrice);
    }
}