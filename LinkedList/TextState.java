import java.util.Scanner;

class TextState {
    String content;
    TextState prev;
    TextState next;

    public TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

public class TextEditor {
    private TextState head = null;
    private TextState tail = null;
    private TextState current = null;
    private int maxHistory = 10;
    private int historySize = 0;

    // Add a new text state
    public void addTextState(String newText) {
        TextState newState = new TextState(newText);

        // Remove redo history if exists
        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
            tail = current;
        }

        // If no state exists
        if (head == null) {
            head = tail = current = newState;
            historySize = 1;
        } else {
            // Append new state
            tail.next = newState;
            newState.prev = tail;
            tail = newState;
            current = newState;
            historySize++;

            // Remove oldest state if limit exceeded
            if (historySize > maxHistory) {
                head = head.next;
                head.prev = null;
                historySize--;
            }
        }

        System.out.println("New text state added.");
    }

    // Undo
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo successful.");
        } else {
            System.out.println("Cannot undo.");
        }
    }

    // Redo
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo successful.");
        } else {
            System.out.println("Cannot redo.");
        }
    }

    // Display current state
    public void displayCurrentState() {
        if (current != null)
            System.out.println("Current Text: " + current.content);
        else
            System.out.println("No text state available.");
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextEditor editor = new TextEditor();
        int choice;

        do {
            System.out.println("\n--- Text Editor Menu ---");
            System.out.println("1. Type/Add Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. View Current Text");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter new text: ");
                    String text = sc.nextLine();
                    editor.addTextState(text);
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.displayCurrentState();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}
