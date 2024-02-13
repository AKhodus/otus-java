package ru.otus.java.homeworks.homework5;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", 2, 1);
        Dog dog = new Dog("Sharik", 4, 2);
        Horse horse = new Horse("Veter", 6, 1);
        cat.run(100);
        cat.info();
        dog.run(80);
        dog.info();
        //dog.swim(25);
        //dog.info();
        horse.run(90);
        horse.info();
        //horse.swim(20);
        //horse.info();
    }
}
