class Student {
    String name;

    public Student() {
        this.name = "Default Student";
    }

    public void show() {
        System.out.println("Student name: " + name);
    }
}

public class ReflectionDemo4 {
    public static void main(String[] args) throws Exception {
        
        Class<?> cls = Class.forName("Student");
        Object obj = cls.getDeclaredConstructor().newInstance();

        
        Student s = (Student) obj;
        s.show();
    }
}
