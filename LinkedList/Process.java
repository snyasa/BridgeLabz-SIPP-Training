import java.util.*;

class Process {
    int processId;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime;
    int turnaroundTime;
    Process next;

    public Process(int id, int bt, int pr) {
        processId = id;
        burstTime = bt;
        remainingTime = bt;
        priority = pr;
        waitingTime = 0;
        turnaroundTime = 0;
        next = null;
    }
}

public class RoundRobinScheduler {
    private Process head = null;
    private Process tail = null;
    private int timeQuantum;

    public RoundRobinScheduler(int tq) {
        this.timeQuantum = tq;
    }

    // Add process at the end
    public void addProcess(int id, int burstTime, int priority) {
        Process newProcess = new Process(id, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            tail.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
    }

    // Remove process by ID (used after execution)
    private void removeProcess(int id) {
        if (head == null) return;

        Process current = head, prev = tail;
        do {
            if (current.processId == id) {
                if (current == head && current == tail) {
                    head = tail = null;
                } else {
                    prev.next = current.next;
                    if (current == head) head = head.next;
                    if (current == tail) tail = prev;
                }
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
    }

    // Display the process list
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in queue.");
            return;
        }
        Process current = head;
        System.out.println("Process Queue:");
        do {
            System.out.printf("P%d [BT: %d, RT: %d, PR: %d] -> ", current.processId, current.burstTime, current.remainingTime, current.priority);
            current = current.next;
        } while (current != head);
        System.out.println("(back to head)");
    }

    // Simulate round-robin scheduling
    public void simulate() {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int time = 0;
        Map<Integer, Integer> completionTime = new HashMap<>();
        Map<Integer, Integer> waitingTime = new HashMap<>();
        Map<Integer, Integer> turnaroundTime = new HashMap<>();

        Process current = head;

        System.out.println("\n--- Starting Round-Robin Scheduling ---");

        while (head != null) {
            displayProcesses();

            if (current.remainingTime <= timeQuantum) {
                time += current.remainingTime;
                current.remainingTime = 0;
                completionTime.put(current.processId, time);
                turnaroundTime.put(current.processId, time);
                waitingTime.put(current.processId, time - current.burstTime);
                System.out.printf("P%d finished at time %d\n", current.processId, time);
                Process nextProcess = current.next;
                removeProcess(current.processId);
                current = (head != null) ? nextProcess : null;
            } else {
                time += timeQuantum;
                current.remainingTime -= timeQuantum;
                System.out.printf("P%d executed till %d, remaining: %d\n", current.processId, time, current.remainingTime);
                current = current.next;
            }
        }

        // Print stats
        System.out.println("\n--- Scheduling Complete ---");
        int totalWaiting = 0, totalTurnaround = 0;
        int count = waitingTime.size();

        for (int id : waitingTime.keySet()) {
            int wt = waitingTime.get(id);
            int tat = turnaroundTime.get(id);
            totalWaiting += wt;
            totalTurnaround += tat;
            System.out.printf("P%d -> Waiting Time: %d, Turnaround Time: %d\n", id, wt, tat);
        }

        System.out.printf("\nAverage Waiting Time: %.2f\n", (double) totalWaiting / count);
        System.out.printf("Average Turnaround Time: %.2f\n", (double) totalTurnaround / count);
    }

    // Main menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Time Quantum: ");
        int tq = sc.nextInt();
        RoundRobinScheduler scheduler = new RoundRobinScheduler(tq);

        int choice;
        do {
            System.out.println("\n--- Round-Robin Scheduler Menu ---");
            System.out.println("1. Add Process");
            System.out.println("2. Display Processes");
            System.out.println("3. Start Scheduling");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            int id, bt, pr;

            switch (choice) {
                case 1:
                    System.out.print("Enter Process ID, Burst Time, Priority: ");
                    id = sc.nextInt();
                    bt = sc.nextInt();
                    pr = sc.nextInt();
                    scheduler.addProcess(id, bt, pr);
                    break;
                case 2:
                    scheduler.displayProcesses();
                    break;
                case 3:
                    scheduler.simulate();
                    break;
                case 4:
                    System.out.println("Exiting Scheduler...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}
