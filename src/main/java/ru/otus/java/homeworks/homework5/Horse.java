package ru.otus.java.homeworks.homework5;

public class Horse extends Animal {
    public Horse(String name, int runSpeed, int swimSpeed) {
        super(name, runSpeed, swimSpeed);
    }

    public void swim(int distance) {
        int time;
        stamina = stamina - distance * 4;
        if (stamina <= 0) {
            time = -1;
        } else {
            time = distance / swimSpeed;
        }
        System.out.println(name + " затратил времени на плавание: " + time + " секунд");
    }
}
