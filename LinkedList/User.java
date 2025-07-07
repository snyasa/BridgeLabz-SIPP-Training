import java.util.*;

class User {
    int userId;
    String name;
    int age;
    List<Integer> friendIds;
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

public class SocialMedia {
    private User head = null;

    // Add a new user
    public void addUser(int id, String name, int age) {
        User newUser = new User(id, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newUser;
        }
    }

    // Get user by ID
    private User getUserById(int id) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    // Add friend connection
    public void addFriendConnection(int id1, int id2) {
        User u1 = getUserById(id1);
        User u2 = getUserById(id2);
        if (u1 == null || u2 == null || id1 == id2) {
            System.out.println("Invalid user IDs.");
            return;
        }

        if (!u1.friendIds.contains(id2))
            u1.friendIds.add(id2);
        if (!u2.friendIds.contains(id1))
            u2.friendIds.add(id1);

        System.out.println("Friend connection added between " + u1.name + " and " + u2.name);
    }

    // Remove friend connection
    public void removeFriendConnection(int id1, int id2) {
        User u1 = getUserById(id1);
        User u2 = getUserById(id2);
        if (u1 == null || u2 == null) {
            System.out.println("Invalid user IDs.");
            return;
        }

        u1.friendIds.remove(Integer.valueOf(id2));
        u2.friendIds.remove(Integer.valueOf(id1));

        System.out.println("Friend connection removed.");
    }

    // Find mutual friends
    public void findMutualFriends(int id1, int id2) {
        User u1 = getUserById(id1);
        User u2 = getUserById(id2);

        if (u1 == null || u2 == null) {
            System.out.println("Invalid user IDs.");
            return;
        }

        Set<Integer> mutual = new HashSet<>(u1.friendIds);
        mutual.retainAll(u2.friendIds);

        if (mutual.isEmpty()) {
            System.out.println("No mutual friends.");
        } else {
            System.out.println("Mutual Friends:");
            for (int id : mutual) {
                User u = getUserById(id);
                if (u != null)
                    System.out.println("- " + u.name + " (ID: " + u.userId + ")");
            }
        }
    }

    // Display all friends of a user
    public void displayFriends(int userId) {
        User u = getUserById(userId);
        if (u == null) {
            System.out.println("User not found.");
            return;
        }

        if (u.friendIds.isEmpty()) {
            System.out.println(u.name + " has no friends.");
        } else {
            System.out.println(u.name + "'s Friends:");
            for (int fid : u.friendIds) {
                User friend = getUserById(fid);
                if (friend != null)
                    System.out.println("- " + friend.name + " (ID: " + friend.userId + ")");
            }
        }
    }

    // Search user by name or ID
    public void searchUser(String keyword) {
        boolean found = false;
        User temp = head;

        while (temp != null) {
            if (String.valueOf(temp.userId).equals(keyword) || temp.name.equalsIgnoreCase(keyword)) {
                System.out.printf("User Found - ID: %d, Name: %s, Age: %d\n", temp.userId, temp.name, temp.age);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) System.out.println("User not found.");
    }

    // Count friends for each user
    public void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIds.size() + " friend(s).");
            temp = temp.next;
        }
    }

    // Display all users
    public void displayAllUsers() {
        User temp = head;
        System.out.println("\nAll Users:");
        while (temp != null) {
            System.out.printf("ID: %d, Name: %s, Age: %d\n", temp.userId, temp.name, temp.age);
            temp = temp.next;
        }
    }

    // Main menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SocialMedia sm = new SocialMedia();

        int choice;

        do {
            System.out.println("\n--- Social Media Friend System ---");
            System.out.println("1. Add User");
            System.out.println("2. Add Friend Connection");
            System.out.println("3. Remove Friend Connection");
            System.out.println("4. Find Mutual Friends");
            System.out.println("5. Display Friends of a User");
            System.out.println("6. Search User by Name or ID");
            System.out.println("7. Count Friends of Each User");
            System.out.println("8. Display All Users");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt(); sc.nextLine();

            int id1, id2, age;
            String name, keyword;

            switch (choice) {
                case 1:
                    System.out.print("Enter User ID, Name, Age: ");
                    id1 = sc.nextInt(); sc.nextLine();
                    name = sc.nextLine();
                    age = sc.nextInt();
                    sm.addUser(id1, name, age);
                    break;
                case 2:
                    System.out.print("Enter User IDs to connect: ");
                    id1 = sc.nextInt();
                    id2 = sc.nextInt();
                    sm.addFriendConnection(id1, id2);
                    break;
                case 3:
                    System.out.print("Enter User IDs to disconnect: ");
                    id1 = sc.nextInt();
                    id2 = sc.nextInt();
                    sm.removeFriendConnection(id1, id2);
                    break;
                case 4:
                    System.out.print("Enter two User IDs: ");
                    id1 = sc.nextInt();
                    id2 = sc.nextInt();
                    sm.findMutualFriends(id1, id2);
                    break;
                case 5:
                    System.out.print("Enter User ID: ");
                    id1 = sc.nextInt();
                    sm.displayFriends(id1);
                    break;
                case 6:
                    System.out.print("Enter Name or ID to search: ");
                    keyword = sc.nextLine();
                    sm.searchUser(keyword);
                    break;
                case 7:
                    sm.countFriends();
                    break;
                case 8:
                    sm.displayAllUsers();
                    break;
                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 9);

        sc.close();
    }
}
