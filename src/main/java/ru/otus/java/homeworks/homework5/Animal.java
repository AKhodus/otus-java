package ru.otus.java.homeworks.homework5;

public class Animal {
    String name;
    int runSpeed;
    int swimSpeed;
    int stamina = 100;

    public Animal(String name, int runSpeed, int swimSpeed) {
        this.name = name;
        this.runSpeed = runSpeed;
        this.swimSpeed = swimSpeed;
    }


    public void run(int distance) {
        int time;
        stamina = stamina - distance;
        if (stamina <= 0) {
            time = -1;
        } else {
            time = distance / runSpeed;
        }
        System.out.println(name + " затратил времени на бег: " + time + " секунд");
    }

    public void info() {
        if (stamina > 0) {
            System.out.println("Текущая выносливость: " + stamina);
        } else System.out.println(name + " устал");
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