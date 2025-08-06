public class ExceptionPropagation {

    // method1 throws an ArithmeticException
    static void method1() {
        int result = 10 / 0;  // This will cause ArithmeticException
    }

    // method2 calls method1
    static void method2() {
        method1();
    }

    // main calls method2 and handles the exception
    public static void main(String[] args) {
        try {
            method2();  // Exception will propagate here
        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main");
        }
    }
}
