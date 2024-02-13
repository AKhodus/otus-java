package ru.otus.java.homeworks.homework5;

public class Dog extends Animal {
    public Dog(String name, int runSpeed, int swimSpeed) {
        super(name, runSpeed, swimSpeed);
    }

    public void swim(int distance) {
        int time;
        stamina = stamina - distance * 2;
        if (stamina <= 0) {
            time = -1;
        } else {
            time = distance / swimSpeed;
        }
        System.out.println(name + " затратил времени на плавание: " + time + " секунд");
    }
}
