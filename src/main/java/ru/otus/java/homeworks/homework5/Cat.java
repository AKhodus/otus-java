package ru.otus.java.homeworks.homework5;

public class Cat extends Animal {
    public Cat(String name, int runSpeed, int swimSpeed) {
        super(name, runSpeed, swimSpeed);
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать");
    }
}
