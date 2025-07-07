import java.util.Scanner;

class Task {
    int taskId;
    String taskName;
    String priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, String priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

public class CircularTaskScheduler {
    private Task head = null;
    private Task tail = null;
    private Task currentTask = null;

    // Add at beginning
    public void addAtBeginning(int id, String name, String priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            newTask.next = head;
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head;
        }
    }

    // Add at end
    public void addAtEnd(int id, String name, String priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            newTask.next = head;
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head;
        }
    }

    // Add at specific position
    public void addAtPosition(int pos, int id, String name, String priority, String dueDate) {
        if (pos <= 0) {
            System.out.println("Invalid position.");
            return;
        }

        if (pos == 1) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        }

        Task newTask = new Task(id, name, priority, dueDate);
        Task temp = head;

        for (int i = 1; i < pos - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        newTask.next = temp.next;
        temp.next = newTask;

        if (temp == tail) {
            tail = newTask;
        }
    }

    // Remove by Task ID
    public void removeById(int id) {
        if (head == null) {
            System.out.println("No tasks to remove.");
            return;
        }

        Task temp = head, prev = tail;
        do {
            if (temp.taskId == id) {
                if (temp == head) {
                    if (head == tail) {
                        head = tail = null;
                    } else {
                        head = head.next;
                        tail.next = head;
                    }
                } else {
                    prev.next = temp.next;
                    if (temp == tail) {
                        tail = prev;
                    }
                }
                if (currentTask == temp) currentTask = temp.next;
                System.out.println("Task removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Task not found.");
    }

    // View current task
    public void viewCurrentTask() {
        if (currentTask == null) {
            currentTask = head;
        }

        if (currentTask != null) {
            System.out.println("Current Task:");
            displayTask(currentTask);
        } else {
            System.out.println("No tasks scheduled.");
        }
    }

    // Move to next task
    public void moveToNextTask() {
        if (currentTask == null) {
            currentTask = head;
        } else {
            currentTask = currentTask.next;
        }

        if (currentTask != null) {
            System.out.println("Moved to Next Task:");
            displayTask(currentTask);
        } else {
            System.out.println("No tasks to move.");
        }
    }

    // Display all tasks
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }

        System.out.println("All Scheduled Tasks:");
        Task temp = head;
        do {
            displayTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // Search by priority
    public void searchByPriority(String priority) {
        if (head == null) {
            System.out.println("No tasks to search.");
            return;
        }

        boolean found = false;
        Task temp = head;
        do {
            if (temp.priority.equalsIgnoreCase(priority)) {
                displayTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No task with given priority.");
        }
    }

    // Display task details
    private void displayTask(Task task) {
        System.out.println("ID: " + task.taskId + ", Name: " + task.taskName + ", Priority: " + task.priority + ", Due: " + task.dueDate);
    }

    // Main menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularTaskScheduler scheduler = new CircularTaskScheduler();
        int choice;

        do {
            System.out.println("\n--- Task Scheduler Menu ---");
            System.out.println("1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Position");
            System.out.println("4. Remove Task by ID");
            System.out.println("5. View Current Task");
            System.out.println("6. Move to Next Task");
            System.out.println("7. Display All Tasks");
            System.out.println("8. Search Task by Priority");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            int id, pos;
            String name, priority, due;

            switch (choice) {
                case 1:
                    System.out.print("Enter ID, Name, Priority, Due Date: ");
                    id = sc.nextInt(); sc.nextLine();
                    name = sc.nextLine();
                    priority = sc.nextLine();
                    due = sc.nextLine();
                    scheduler.addAtBeginning(id, name, priority, due);
                    break;
                case 2:
                    System.out.print("Enter ID, Name, Priority, Due Date: ");
                    id = sc.nextInt(); sc.nextLine();
                    name = sc.nextLine();
                    priority = sc.nextLine();
                    due = sc.nextLine();
                    scheduler.addAtEnd(id, name, priority, due);
                    break;
                case 3:
                    System.out.print("Enter Position, ID, Name, Priority, Due Date: ");
                    pos = sc.nextInt();
                    id = sc.nextInt(); sc.nextLine();
                    name = sc.nextLine();
                    priority = sc.nextLine();
                    due = sc.nextLine();
                    scheduler.addAtPosition(pos, id, name, priority, due);
                    break;
                case 4:
                    System.out.print("Enter Task ID to remove: ");
                    id = sc.nextInt();
                    scheduler.removeById(id);
                    break;
                case 5:
                    scheduler.viewCurrentTask();
                    break;
                case 6:
                    scheduler.moveToNextTask();
                    break;
                case 7:
                    scheduler.displayAllTasks();
                    break;
                case 8:
                    System.out.print("Enter Priority to search: ");
                    priority = sc.nextLine();
                    scheduler.searchByPriority(priority);
                    break;
                case 9:
                    System.out.println("Exiting Scheduler...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 9);

        sc.close();
    }
}
