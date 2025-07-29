import java.util.*;

public class ReverseListProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose List Type:\n1. ArrayList\n2. LinkedList");
        int choice = sc.nextInt();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        List<Integer> list;

        if (choice == 1) {
            list = new ArrayList<>();
        } else if (choice == 2) {
            list = new LinkedList<>();
        } else {
            System.out.println("Invalid choice!");
            return;
        }

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        System.out.println("Original List: " + list);

        if (choice == 1) {
            reverseArrayList((ArrayList<Integer>) list);
        } else {
            list = reverseLinkedList((LinkedList<Integer>) list);
        }

        System.out.println("Reversed List: " + list);
    }

    // In-place reverse for ArrayList
    public static void reverseArrayList(ArrayList<Integer> list) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }

    // New list for reversed LinkedList
    public static LinkedList<Integer> reverseLinkedList(LinkedList<Integer> list) {
        LinkedList<Integer> reversed = new LinkedList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reversed.add(list.get(i));
        }
        return reversed;
    }
}
