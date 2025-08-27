class Animal {
    String name;
    int age;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    Dog(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " barks!");
    }
}

class Cat extends Animal {
    Cat(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " meows!");
    }
}

class Bird extends Animal {
    Bird(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " chirps!");
    }
}

public class AnimalTest {
    public static void main(String[] args) {
        Animal[] animals = {
            new Dog("Tommy", 5),
            new Cat("Whiskers", 3),
            new Bird("Tweety", 2)
        };

        for (Animal a : animals) {
            a.makeSound();  // Demonstrates polymorphism
        }
    }
}
