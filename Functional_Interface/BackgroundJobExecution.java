public class BackgroundJobExecution {
    public static void main(String[] args) {
        System.out.println("Main thread started");

        
        Runnable task1 = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Task1 - Number: " + i);
                try {
                    Thread.sleep(500); // simulate work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        
        Runnable task2 = () -> {
            for (char c = 'A'; c <= 'E'; c++) {
                System.out.println("Task2 - Letter: " + c);
                try {
                    Thread.sleep(700); // simulate work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();

        System.out.println("Main thread continues running...");

       
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All background tasks completed");
    }
}
