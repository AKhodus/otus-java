package ru.otus.java.homeworks.homework5;

public class Horse extends Animal {
    public Horse(String name, int runSpeed, int swimSpeed) {
        super(name, runSpeed, swimSpeed);
    }

    @Override
    public void swim(int distance) {
        super.swim(distance);
        stamina = stamina - distance * 2;
    }
}
