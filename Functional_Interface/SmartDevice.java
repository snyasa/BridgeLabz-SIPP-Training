
import java.util.*;

interface SmartDevice {
    void turnOn();
    void turnOff();
}


class Light implements SmartDevice {
    @Override
    public void turnOn() {
        System.out.println("Light is turned ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Light is turned OFF");
    }
}


class AC implements SmartDevice {
    @Override
    public void turnOn() {
        System.out.println("AC is turned ON");
    }

    @Override
    public void turnOff() {
        System.out.println("AC is turned OFF");
    }
}


class TV implements SmartDevice {
    @Override
    public void turnOn() {
        System.out.println("TV is turned ON");
    }

    @Override
    public void turnOff() {
        System.out.println("TV is turned OFF");
    }
}


public class SmartHomeController {
    public static void main(String[] args) {
        // Create a list of devices
        List<SmartDevice> devices = new ArrayList<>();
        devices.add(new Light());
        devices.add(new AC());
        devices.add(new TV());

        System.out.println("--- Turning ON all devices ---");
        for (SmartDevice device : devices) {
            device.turnOn();
        }

        System.out.println("--- Turning OFF all devices ---");
        for (SmartDevice device : devices) {
            device.turnOff();
        }
    }
}
