import java.lang.reflect.*;

class Person {
    private int age = 25;
}

public class Reflection {
    public static void main(String[] args) throws Exception {
        Person p = new Person();

        Field field = Person.class.getDeclaredField("age");
        field.setAccessible(true);  // allow access to private field

        
        field.set(p, 30);

        
        int ageValue = (int) field.get(p);

        System.out.println("Modified Age: " + ageValue);
    }
}
