import java.lang.reflect.*;
import java.util.*;
public class Reflection {
    public static void main(String[] args) throws Exception {
        
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter fully qualified class name (e.g., java.util.ArrayList): ");
        String className = sc.nextLine();

        
        Class<?> cls = Class.forName(className);

        
        System.out.println("\nClass: " + cls.getName());

        System.out.println("\n--- Fields ---");
        for (Field f : cls.getDeclaredFields()) {
            System.out.println(f);
        }

        System.out.println("\n--- Methods ---");
        for (Method m : cls.getDeclaredMethods()) {
            System.out.println(m);
        }

        System.out.println("\n--- Constructors ---");
        for (Constructor<?> c : cls.getDeclaredConstructors()) {
            System.out.println(c);
        }
    }
}
